import { TestBed } from '@angular/core/testing';

import { StudentOperationService } from './student-operation.service';

describe('StudentOperationService', () => {
  let service: StudentOperationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentOperationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
