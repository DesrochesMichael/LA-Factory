import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListModelCategorieComponent } from './list-model-categorie.component';

describe('ListModelCategorieComponent', () => {
  let component: ListModelCategorieComponent;
  let fixture: ComponentFixture<ListModelCategorieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListModelCategorieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListModelCategorieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
