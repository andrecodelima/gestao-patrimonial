import { Component, OnInit } from '@angular/core';
import { AcessoService } from '../../services/acesso.service';

@Component({
  selector: 'app-cadastro-acesso',
  templateUrl: './cadastro-acesso.component.html',
  styleUrls: ['./cadastro-acesso.component.css']
})
export class CadastroAcessoComponent implements OnInit {

  descricao:string = '';
  acessos:any[] = [];

  constructor(private acessoService:AcessoService){}

  ngOnInit(): void {
      this.listarAcessos();
  }

  cadastrar(){
    // alert("Ok");
    const novoAcesso = {descricao: this.descricao};
    this.acessoService.cadastrarAcesso(novoAcesso).subscribe(
      (res)=>{
        alert('Acesso cadastrado com sucesso');
        this.descricao = '';
        this.listarAcessos();
      },
      (err)=>{
        console.error('Erro ao cadastrar acesso', err);
        alert('Erro ao cadastrar acesso');
      }
    )
  };

  listarAcessos(){
    this.acessoService.listarAcessos().subscribe(
      (res)=>{
        this.acessos = res;
      },
      (err)=>{
        console.error('Erro ao listar acessos', err);
        alert('Erro ao listar acessos')
      }
    )
  };
}
