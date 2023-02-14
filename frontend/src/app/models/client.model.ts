export interface IClient {

  id: number;
  name: string;
  cpf: string;
  phone: string;

}

export interface IClientCreate {
  name: string;
  cpf: string;
  phone: string;
}
