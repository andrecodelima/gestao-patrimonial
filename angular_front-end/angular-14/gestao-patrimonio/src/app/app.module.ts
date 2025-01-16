import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { CadastroAcessoComponent } from './components/cadastro-acesso/cadastro-acesso.component';
import { AcessoService } from './services/acesso.service';

@NgModule({
  declarations: [
    AppComponent,
    CadastroAcessoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AcessoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
