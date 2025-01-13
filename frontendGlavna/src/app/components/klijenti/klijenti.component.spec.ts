import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KlijentiComponent } from './klijenti.component';

describe('KlijentiComponent', () => {
  let component: KlijentiComponent;
  let fixture: ComponentFixture<KlijentiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KlijentiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KlijentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
