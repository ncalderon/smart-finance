import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SfWebBaseSharedModule } from '../../shared';
import {
    TranCategoryService,
    TranCategoryPopupService,
    TranCategoryComponent,
    TranCategoryDetailComponent,
    TranCategoryDialogComponent,
    TranCategoryPopupComponent,
    TranCategoryDeletePopupComponent,
    TranCategoryDeleteDialogComponent,
    tranCategoryRoute,
    tranCategoryPopupRoute,
    TranCategoryResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...tranCategoryRoute,
    ...tranCategoryPopupRoute,
];

@NgModule({
    imports: [
        SfWebBaseSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        TranCategoryComponent,
        TranCategoryDetailComponent,
        TranCategoryDialogComponent,
        TranCategoryDeleteDialogComponent,
        TranCategoryPopupComponent,
        TranCategoryDeletePopupComponent,
    ],
    entryComponents: [
        TranCategoryComponent,
        TranCategoryDialogComponent,
        TranCategoryPopupComponent,
        TranCategoryDeleteDialogComponent,
        TranCategoryDeletePopupComponent,
    ],
    providers: [
        TranCategoryService,
        TranCategoryPopupService,
        TranCategoryResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SfWebBaseTranCategoryModule {}
