import { TestBed } from '@angular/core/testing';

import { TrotinetService } from './trotinet.service';

describe('TrotinetService', () => {
  let service: TrotinetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TrotinetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
