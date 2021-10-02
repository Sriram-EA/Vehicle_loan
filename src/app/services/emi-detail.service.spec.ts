import { TestBed } from '@angular/core/testing';

import { EmiDetailService } from './emi-detail.service';

describe('EmiDetailService', () => {
  let service: EmiDetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmiDetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
