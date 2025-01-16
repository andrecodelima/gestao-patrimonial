import { TestBed } from '@angular/core/testing';

import { CadastroAcessoService } from './cadastro-acesso.service';

describe('CadastroAcessoService', () => {
  let service: CadastroAcessoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CadastroAcessoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
