import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environments';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class CadastroAcessoService {

  private urlApiLocal = environment.urlApiLocal + 'login';
  constructor(private http: HttpClient) { 

  }

  logar(usuario: Usuario){

    return this.http.post<String>(this.urlApiLocal, usuario);
  }

}
