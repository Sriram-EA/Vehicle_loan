import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateEmploymentComponent } from './update-employment.component';

describe('UpdateEmploymentComponent', () => {
  let component: UpdateEmploymentComponent;
  let fixture: ComponentFixture<UpdateEmploymentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateEmploymentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateEmploymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
