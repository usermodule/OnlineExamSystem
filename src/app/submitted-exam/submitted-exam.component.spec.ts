import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmittedExamComponent } from './submitted-exam.component';

describe('SubmittedExamComponent', () => {
  let component: SubmittedExamComponent;
  let fixture: ComponentFixture<SubmittedExamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubmittedExamComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubmittedExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
