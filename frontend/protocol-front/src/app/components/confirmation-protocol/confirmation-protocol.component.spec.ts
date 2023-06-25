import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmationProtocolComponent } from './confirmation-protocol.component';

describe('ConfirmationProtocolComponent', () => {
  let component: ConfirmationProtocolComponent;
  let fixture: ComponentFixture<ConfirmationProtocolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfirmationProtocolComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConfirmationProtocolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
