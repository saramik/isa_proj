import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZakazivanjeDermatologPacijentComponent } from './zakazivanje-dermatolog-pacijent.component';

describe('ZakazivanjeDermatologPacijentComponent', () => {
  let component: ZakazivanjeDermatologPacijentComponent;
  let fixture: ComponentFixture<ZakazivanjeDermatologPacijentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZakazivanjeDermatologPacijentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZakazivanjeDermatologPacijentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
