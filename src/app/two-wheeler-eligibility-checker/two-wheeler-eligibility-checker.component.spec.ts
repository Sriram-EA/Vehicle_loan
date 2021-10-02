import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwoWheelerEligibilityCheckerComponent } from './two-wheeler-eligibility-checker.component';

describe('TwoWheelerEligibilityCheckerComponent', () => {
  let component: TwoWheelerEligibilityCheckerComponent;
  let fixture: ComponentFixture<TwoWheelerEligibilityCheckerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TwoWheelerEligibilityCheckerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TwoWheelerEligibilityCheckerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
