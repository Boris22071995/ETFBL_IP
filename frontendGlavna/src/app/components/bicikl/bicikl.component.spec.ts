import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BiciklComponent } from './bicikl.component';

describe('BiciklComponent', () => {
  let component: BiciklComponent;
  let fixture: ComponentFixture<BiciklComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BiciklComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BiciklComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
