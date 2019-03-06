import { TestBed } from '@angular/core/testing';

import { AsstesService } from './asstes.service';

describe('AsstesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AsstesService = TestBed.get(AsstesService);
    expect(service).toBeTruthy();
  });
});
