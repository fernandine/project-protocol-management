import { TestBed } from '@angular/core/testing';

import { ProtocolResolver } from './protocol.resolver';

describe('ProtocolResolver', () => {
  let resolver: ProtocolResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(ProtocolResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
