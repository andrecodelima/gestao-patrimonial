import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroAcessoComponent } from './cadastro-acesso.component';

describe('CadastroAcessoComponent', () => {
  let component: CadastroAcessoComponent;
  let fixture: ComponentFixture<CadastroAcessoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroAcessoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastroAcessoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
