import { TestBed } from '@angular/core/testing';

import { CRUDModelService } from './crudmodel.service';

describe('CRUDModelService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CRUDModelService = TestBed.get(CRUDModelService);
    expect(service).toBeTruthy();
  });
});
