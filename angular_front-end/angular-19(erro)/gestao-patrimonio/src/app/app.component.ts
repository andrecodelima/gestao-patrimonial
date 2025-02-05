import { Component } from '@angular/core';
// import { RouterOutlet } from '@angular/router';
import { CadastroAcessoComponent } from './components/cadastro-acesso/cadastro-acesso.component';

@Component({
  selector: 'app-root',
  imports: [CadastroAcessoComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'gestao-patrimonio';
}
