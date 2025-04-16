import { Component } from '@angular/core';
import { LoginComponent } from "../../../pages/login/login.component";

@Component({
  selector: 'app-login-layout',
  imports: [LoginComponent],
  templateUrl: './login-layout.component.html',
  styleUrl: './login-layout.component.scss'
})
export class LoginLayoutComponent {

  title:string="Não tem acesso?"
  text:string="Caso não tenha acesso, clique no botão abaixo e faça seu cadastro"
  btnText:string = "Cadastrar"
}
