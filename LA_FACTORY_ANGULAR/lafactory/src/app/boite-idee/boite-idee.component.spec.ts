import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BoiteIdeeComponent } from './boite-idee.component';

describe('BoiteIdeeComponent', () => {
  let component: BoiteIdeeComponent;
  let fixture: ComponentFixture<BoiteIdeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BoiteIdeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoiteIdeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
