import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Usuario } from 'src/app/model/usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private fb: FormBuilder){

  }

  // Pegando os dados do formulario
  loginForm = this.fb.group({
    id:[],
    login:[null, Validators.required],
    senha:[null, Validators.required]
  })


  // Transformando em objeto
  loginObjeto(): Usuario{
    return{
      login: this.loginForm.get('login')?.value!,
      senha: this.loginForm.get('senha')?.value!
    }
  }

  fazerLogin(){
    const usuario = this.loginObjeto();
    console.info('dados de login ->' + usuario.login);
    console.info('dados de login ->' + usuario.senha);

  }
}
