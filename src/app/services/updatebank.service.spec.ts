import { TestBed } from '@angular/core/testing';

import { UpdatebankService } from './updatebank.service';

describe('UpdatebankService', () => {
  let service: UpdatebankService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdatebankService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
