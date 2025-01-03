import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AcessoService {

  private apiUrl = '/api';

  constructor(private http: HttpClient) {}

  // Metodo para cadastrar acesso
  cadastrarAcesso(acesso: {descricao:string}):Observable<any>{

    return this.http.post(`${this.apiUrl}/saveAcesso`, acesso);
  }

  // Método para listar acessos
  listarAcessos():Observable<any[]>{
    return this.http.get<any[]>(`${this.apiUrl}/getAllAcessos`);
  }

}
