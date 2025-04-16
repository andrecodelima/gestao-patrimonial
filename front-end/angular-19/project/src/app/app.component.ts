import { Component } from '@angular/core';
import { LoginLayoutComponent } from "./components/layouts/login-layout/login-layout.component";

@Component({
  selector: 'app-root',
  imports: [LoginLayoutComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'project';
}
