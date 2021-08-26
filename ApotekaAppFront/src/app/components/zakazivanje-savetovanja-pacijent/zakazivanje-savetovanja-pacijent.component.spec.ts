import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZakazivanjeSavetovanjaPacijentComponent } from './zakazivanje-savetovanja-pacijent.component';

describe('ZakazivanjeSavetovanjaPacijentComponent', () => {
  let component: ZakazivanjeSavetovanjaPacijentComponent;
  let fixture: ComponentFixture<ZakazivanjeSavetovanjaPacijentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZakazivanjeSavetovanjaPacijentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZakazivanjeSavetovanjaPacijentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
