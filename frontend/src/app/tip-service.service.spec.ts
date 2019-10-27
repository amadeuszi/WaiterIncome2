import { TestBed } from '@angular/core/testing';

import { TipServiceService } from './tip-service.service';

describe('TipServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TipServiceService = TestBed.get(TipServiceService);
    expect(service).toBeTruthy();
  });
});
