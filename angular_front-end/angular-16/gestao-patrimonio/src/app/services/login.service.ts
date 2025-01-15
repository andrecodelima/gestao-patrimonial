import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environments';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private urlApiLocal = environment.urlApiLocal + 'login';
  constructor(private http: HttpClient) { 

  }

  logar(usuario: Usuario) {
    return this.http.post<any>(this.urlApiLocal, usuario, {
      headers: {
        'Content-Type': 'application/json',
      }
    }).subscribe({
      next: (res) => {
        // Mostre a mensagem da resposta JSON
        if (res && res.message) {
          alert(res.message);
        } else {
          alert('Login realizado, mas sem mensagem específica.');
        }
      },
      error: (error) => {
        console.error('Erro no login:', error);
        if (error.error && error.error.error) {
          alert(error.error.error); // Mostra mensagem de erro retornada pela API
        } else {
          alert('Erro ao realizar login.');
        }
      }
    });
  }
  
  

}

