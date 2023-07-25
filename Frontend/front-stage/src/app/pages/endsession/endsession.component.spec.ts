import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EndsessionComponent } from './endsession.component';

describe('EndsessionComponent', () => {
  let component: EndsessionComponent;
  let fixture: ComponentFixture<EndsessionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EndsessionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EndsessionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
