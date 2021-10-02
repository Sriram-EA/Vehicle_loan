import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThreeWheelerEligibilityCheckerComponent } from './three-wheeler-eligibility-checker.component';

describe('ThreeWheelerEligibilityCheckerComponent', () => {
  let component: ThreeWheelerEligibilityCheckerComponent;
  let fixture: ComponentFixture<ThreeWheelerEligibilityCheckerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThreeWheelerEligibilityCheckerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThreeWheelerEligibilityCheckerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
