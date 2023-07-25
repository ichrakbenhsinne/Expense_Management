import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IntermStatComponent } from './interm-stat.component';

describe('IntermStatComponent', () => {
  let component: IntermStatComponent;
  let fixture: ComponentFixture<IntermStatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IntermStatComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IntermStatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
