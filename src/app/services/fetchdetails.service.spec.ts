import { TestBed } from '@angular/core/testing';

import { FetchdetailsService } from './fetchdetails.service';

describe('FetchdetailsService', () => {
  let service: FetchdetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FetchdetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
