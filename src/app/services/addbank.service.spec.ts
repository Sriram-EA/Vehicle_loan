import { TestBed } from '@angular/core/testing';

import { AddbankService } from './addbank.service';

describe('AddbankService', () => {
  let service: AddbankService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddbankService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
