import { TestBed } from '@angular/core/testing';

import { ExamOperationService } from './exam-operation.service';

describe('ExamOperationService', () => {
  let service: ExamOperationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamOperationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
