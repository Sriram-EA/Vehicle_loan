import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanProceduresComponent } from './loan-procedures.component';

describe('LoanProceduresComponent', () => {
  let component: LoanProceduresComponent;
  let fixture: ComponentFixture<LoanProceduresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanProceduresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanProceduresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
