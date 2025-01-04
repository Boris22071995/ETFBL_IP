import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrotinetComponent } from './trotinet.component';

describe('TrotinetComponent', () => {
  let component: TrotinetComponent;
  let fixture: ComponentFixture<TrotinetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TrotinetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrotinetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
