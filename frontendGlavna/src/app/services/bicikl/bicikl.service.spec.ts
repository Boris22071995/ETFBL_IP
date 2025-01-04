import { TestBed } from '@angular/core/testing';

import { BiciklService } from './bicikl.service';

describe('BiciklService', () => {
  let service: BiciklService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BiciklService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
