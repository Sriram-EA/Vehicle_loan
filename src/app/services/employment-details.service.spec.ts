import { TestBed } from '@angular/core/testing';

import { EmploymentDetailsService } from './employment-details.service';

describe('EmploymentDetailsService', () => {
  let service: EmploymentDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmploymentDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
