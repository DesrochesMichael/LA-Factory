import { TestBed } from '@angular/core/testing';

import { CRUDNoteService } from './crudnote.service';

describe('CRUDNoteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CRUDNoteService = TestBed.get(CRUDNoteService);
    expect(service).toBeTruthy();
  });
});
