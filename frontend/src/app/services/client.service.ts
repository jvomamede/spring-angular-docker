import { DecimalPipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable, PipeTransform } from '@angular/core';
import { BehaviorSubject, debounceTime, delay, Observable, of, Subject, switchMap, tap } from 'rxjs';
import { environment } from 'src/environments/environment';
import { SortColumn, SortDirection } from '../directives/short-table-header.directive';
import { IClient, IClientCreate } from '../models/client.model';
import { IClientService } from './client-service.interface';


interface SearchResult {
	clients: IClient[];
	total: number;
}

interface State {
	page: number;
	pageSize: number;
	searchTerm: string;
	sortColumn: SortColumn;
	sortDirection: SortDirection;
}

const compare = (v1: string | number, v2: string | number) => (v1 < v2 ? -1 : v1 > v2 ? 1 : 0);

function sort(clients: IClient[], column: SortColumn, direction: string): IClient[] {
	if (direction === '' || column === '') {
		return clients;
	} else {
		return [...clients].sort((a, b) => {
			const res = compare(a[column], b[column]);
			return direction === 'asc' ? res : -res;
		});
	}
}

function matches(client: IClient, term: string, pipe: PipeTransform) {
	return (
		client.name.toLowerCase().includes(term.toLowerCase()) ||
		pipe.transform(client.id).includes(term) ||
		client.cpf.includes(term)
	);
}

@Injectable({
  providedIn: 'root'
})
export class ClientService implements IClientService {


  private _loading$ = new BehaviorSubject<boolean>(true);
	private _search$ = new Subject<void>();
	private _clients$ = new BehaviorSubject<IClient[]>([]);
	private _total$ = new BehaviorSubject<number>(0);

  private _state: State = {
		page: 1,
		pageSize: 4,
		searchTerm: '',
		sortColumn: '',
		sortDirection: '',
	};


  public clients: Array<IClient> = [];

  constructor(
    private http: HttpClient,
    private pipe: DecimalPipe
  ) {

    this.getAll();

    this._search$
			.pipe(
				tap(() => this._loading$.next(true)),
				debounceTime(200),
				switchMap(() => this._search()),
				delay(200),
				tap(() => this._loading$.next(false)),
			).subscribe((result) => {
				this._clients$.next(result.clients);
				this._total$.next(result.total);
			});

		this._search$.next();
  }


  getAll(): Observable<Array<IClient>> {

    let clients = this.http.get<Array<IClient>>(`${environment.apiUrl}/client`).subscribe(res => {
      this.clients = res;
    });

    return of(clients) as any;
  }

  getById(id: number): Observable<IClient> {

    return this.http.get<IClient>(`${environment.apiUrl}/client/${id}}`);

  }

  create(data: IClientCreate): Observable<IClient> {
    return this.http.post<IClient>(`${environment.apiUrl}/client`, data);
  }


  search(text: string, pipe: PipeTransform): IClient[] {

    return this.clients.filter((client) => {
      const term = text.toLowerCase();
      return (
        client.name.toLowerCase().includes(term) ||
        pipe.transform(client.id).includes(term) ||
        client.cpf.includes(term)
      );
    });

  }

  get clients$() {
		return this._clients$.asObservable();
	}
	get total$() {
		return this._total$.asObservable();
	}
	get loading$() {
		return this._loading$.asObservable();
	}
	get page() {
		return this._state.page;
	}
	get pageSize() {
		return this._state.pageSize;
	}
	get searchTerm() {
		return this._state.searchTerm;
	}

	set page(page: number) {
		this._set({ page });
	}
	set pageSize(pageSize: number) {
		this._set({ pageSize });
	}
	set searchTerm(searchTerm: string) {
		this._set({ searchTerm });
	}
	set sortColumn(sortColumn: SortColumn) {
		this._set({ sortColumn });
	}
	set sortDirection(sortDirection: SortDirection) {
		this._set({ sortDirection });
	}

	private _set(patch: Partial<State>) {
		Object.assign(this._state, patch);
		this._search$.next();
	}


  private _search(): Observable<SearchResult> {

		const { sortColumn, sortDirection, pageSize, page, searchTerm } = this._state;

		let clients = sort(this.clients, sortColumn, sortDirection);

		clients = clients.filter((client) => matches(client, searchTerm, this.pipe));
		const total = clients.length;

		clients = clients.slice((page - 1) * pageSize, (page - 1) * pageSize + pageSize);
		return of({ clients, total });

	}


}
