import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProizvodjacComponent } from './proizvodjac.component';

describe('ProizvodjacComponent', () => {
  let component: ProizvodjacComponent;
  let fixture: ComponentFixture<ProizvodjacComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProizvodjacComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProizvodjacComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
