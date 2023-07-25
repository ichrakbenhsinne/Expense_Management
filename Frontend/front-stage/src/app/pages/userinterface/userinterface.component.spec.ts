import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserinterfaceComponent } from './userinterface.component';

describe('UserinterfaceComponent', () => {
  let component: UserinterfaceComponent;
  let fixture: ComponentFixture<UserinterfaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserinterfaceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserinterfaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
