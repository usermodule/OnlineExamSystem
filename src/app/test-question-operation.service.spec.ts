import { TestBed } from '@angular/core/testing';

import { TestQuestionOperationService } from './test-question-operation.service';

describe('TestQuestionOperationService', () => {
  let service: TestQuestionOperationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TestQuestionOperationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
