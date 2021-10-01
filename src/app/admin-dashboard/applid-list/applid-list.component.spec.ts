import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplidListComponent } from './applid-list.component';

describe('ApplidListComponent', () => {
  let component: ApplidListComponent;
  let fixture: ComponentFixture<ApplidListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApplidListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplidListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
