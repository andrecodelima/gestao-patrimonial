import { TestBed } from '@angular/core/testing';

import { AcesspService } from './acesso.service';

describe('AcesspService', () => {
  let service: AcesspService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AcesspService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
