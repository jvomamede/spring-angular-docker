import { Observable } from "rxjs";
import { IClient, IClientCreate } from "../models/client.model";

export interface IClientService {

  getAll(): Observable<Array<IClient>>;
  getById(id: number): Observable<IClient>;
  create(data: IClientCreate): Observable<IClient>;

}
