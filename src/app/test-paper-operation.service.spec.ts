import { TestBed } from '@angular/core/testing';

import { TestPaperOperationService } from './test-paper-operation.service';

describe('TestPaperOperationService', () => {
  let service: TestPaperOperationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TestPaperOperationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
