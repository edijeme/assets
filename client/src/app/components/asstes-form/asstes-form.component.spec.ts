import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AsstesFormComponent } from './asstes-form.component';

describe('AsstesFormComponent', () => {
  let component: AsstesFormComponent;
  let fixture: ComponentFixture<AsstesFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AsstesFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AsstesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
