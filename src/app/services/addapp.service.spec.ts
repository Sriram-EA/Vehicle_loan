import { TestBed } from '@angular/core/testing';

import { AddappService } from './addapp.service';

describe('AddappService', () => {
  let service: AddappService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddappService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
