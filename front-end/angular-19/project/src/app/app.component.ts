import { Component } from '@angular/core';
import { LoginComponent } from "./pages/login/login.component";
import { LoginLayoutComponent } from "./components/layouts/login-layout/login-layout.component";

@Component({
  selector: 'app-root',
  imports: [LoginComponent, LoginLayoutComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'project';
}
