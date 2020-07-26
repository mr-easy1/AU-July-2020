import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourceChildComponent } from './resource-child.component';

describe('ResourceChildComponent', () => {
  let component: ResourceChildComponent;
  let fixture: ComponentFixture<ResourceChildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResourceChildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResourceChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
