import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AsstesListComponent } from './asstes-list.component';

describe('AsstesListComponent', () => {
  let component: AsstesListComponent;
  let fixture: ComponentFixture<AsstesListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AsstesListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AsstesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
