import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SfCategoryComponent } from './sf-category.component';
import { SfCategoryDialogComponent } from './sf-category-dialog/sf-category-dialog.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [SfCategoryComponent, SfCategoryDialogComponent]
})
export class SfCategoryModule { }
