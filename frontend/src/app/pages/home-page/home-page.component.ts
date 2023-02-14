import { DecimalPipe } from '@angular/common';
import { Component, OnDestroy, OnInit, QueryList, ViewChildren } from '@angular/core';
import { Observable } from 'rxjs';
import { ShortTableHeaderDirective, SortEvent } from 'src/app/directives/short-table-header.directive';

import { IClient } from 'src/app/models/client.model';
import { ClientService } from 'src/app/services/client.service';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
  providers: [ClientService, DecimalPipe]
})
export class HomePageComponent implements OnInit {

  clients$: Observable<IClient[]> | undefined;
	total$: Observable<number> | undefined;

	@ViewChildren(ShortTableHeaderDirective) headers: QueryList<ShortTableHeaderDirective> | any;

  public clients: Observable<Array<IClient>> | undefined;
  public total: number =  0;

  constructor(
    public clientService: ClientService,
  ) {

    this.clients$ = clientService.clients$;
		this.total$ = clientService.total$;

  }

  ngOnInit(): void {}

  onSort({ column, direction }: SortEvent) {

		this.headers.forEach((header: any) => {
			if (header.sortable !== column) {
				header.direction = '';
			}
		});

		this.clientService.sortColumn = column;
		this.clientService.sortDirection = direction;
	}

}
