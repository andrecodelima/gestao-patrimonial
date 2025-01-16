import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CadastroAcessoComponent } from './components/cadastro-acesso/cadastro-acesso.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CadastroAcessoComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'], // Corrigido
})
export class AppComponent {
  title = 'gestao-patrimonio';
}
