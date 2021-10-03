import { TestBed } from '@angular/core/testing';

import { GetempbankidService } from './getempbankid.service';

describe('GetempbankidService', () => {
  let service: GetempbankidService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetempbankidService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
