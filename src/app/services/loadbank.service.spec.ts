import { TestBed } from '@angular/core/testing';

import { LoadbankService } from './loadbank.service';

describe('LoadbankService', () => {
  let service: LoadbankService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoadbankService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
