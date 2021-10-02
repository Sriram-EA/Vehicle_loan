import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FourWheelerEligibilityCheckerComponent } from './four-wheeler-eligibility-checker.component';

describe('FourWheelerEligibilityCheckerComponent', () => {
  let component: FourWheelerEligibilityCheckerComponent;
  let fixture: ComponentFixture<FourWheelerEligibilityCheckerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FourWheelerEligibilityCheckerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FourWheelerEligibilityCheckerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
