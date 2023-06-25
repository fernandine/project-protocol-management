import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProtocolReaderComponent } from './protocol-reader.component';

describe('ProtocolReaderComponent', () => {
  let component: ProtocolReaderComponent;
  let fixture: ComponentFixture<ProtocolReaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProtocolReaderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProtocolReaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
