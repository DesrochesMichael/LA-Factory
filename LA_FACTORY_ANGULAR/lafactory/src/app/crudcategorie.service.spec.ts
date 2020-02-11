import { TestBed } from '@angular/core/testing';

import { CRUDCategorieService } from './crudcategorie.service';

describe('CRUDCategorieService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CRUDCategorieService = TestBed.get(CRUDCategorieService);
    expect(service).toBeTruthy();
  });
});
