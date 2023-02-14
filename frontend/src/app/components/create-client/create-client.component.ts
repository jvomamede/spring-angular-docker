import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { IClient, IClientCreate } from 'src/app/models/client.model';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.sass'],
  providers: [ClientService]
})
export class CreateClientComponent implements OnInit {

  public formGroup: FormGroup = new FormGroup({});

  constructor(
    private _formBuilder: FormBuilder,
    private _clientService: ClientService
  ) { }

  ngOnInit(): void {

    this.formGroup = this._formBuilder.group({
      name: ['', Validators.required],
      cpf: ['', Validators.required],
      phone: ['', Validators.required],
    });

  }

  public createClient(formGroup: FormGroup): void {

    if(formGroup.valid) {

      let data: IClientCreate = {
        cpf: formGroup.get('cpf')?.value,
        name: formGroup.get('name')?.value,
        phone: formGroup.get('phone')?.value
      }

      this._clientService.create(data).subscribe((res: IClient) => {
        console.log('Client created: ', res);
      })

    }

  }

}
