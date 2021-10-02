import { TestBed } from '@angular/core/testing';

import { EligibilityCheckerService } from './eligibility-checker.service';

describe('EligibilityCheckerService', () => {
  let service: EligibilityCheckerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EligibilityCheckerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
