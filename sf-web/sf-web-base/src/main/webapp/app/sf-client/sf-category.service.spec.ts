import { TestBed, inject } from '@angular/core/testing';

import { SfCategoryService } from './sf-category.service';

describe('SfCategoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SfCategoryService]
    });
  });

  it('should be created', inject([SfCategoryService], (service: SfCategoryService) => {
    expect(service).toBeTruthy();
  }));
});
