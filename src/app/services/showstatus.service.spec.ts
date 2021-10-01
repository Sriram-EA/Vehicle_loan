import { TestBed } from '@angular/core/testing';

import { ShowstatusService } from './showstatus.service';

describe('ShowstatusService', () => {
  let service: ShowstatusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShowstatusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
