import { TestBed } from '@angular/core/testing';

import { InstitutionTypesService } from './institution-types.service';

describe('InstitutionTypesService', () => {
  let service: InstitutionTypesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InstitutionTypesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
