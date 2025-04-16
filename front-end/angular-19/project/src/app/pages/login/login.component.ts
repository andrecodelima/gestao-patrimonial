import { Component } from '@angular/core';
import { PrimaryInputComponent } from "../../components/primary-input/primary-input.component";

@Component({
  selector: 'app-login',
  imports: [PrimaryInputComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  title:string = "Login"
  forgetpass:string = "Esqueceu sua senha?"
  btnText:string = "Login"
}
