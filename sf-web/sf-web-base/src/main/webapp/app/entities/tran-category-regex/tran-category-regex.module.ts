import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SfWebBaseSharedModule } from '../../shared';
import { SfWebBaseAdminModule } from '../../admin/admin.module';
import {
    TranCategoryRegexService,
    TranCategoryRegexPopupService,
    TranCategoryRegexComponent,
    TranCategoryRegexDetailComponent,
    TranCategoryRegexDialogComponent,
    TranCategoryRegexPopupComponent,
    TranCategoryRegexDeletePopupComponent,
    TranCategoryRegexDeleteDialogComponent,
    tranCategoryRegexRoute,
    tranCategoryRegexPopupRoute,
    TranCategoryRegexResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...tranCategoryRegexRoute,
    ...tranCategoryRegexPopupRoute,
];

@NgModule({
    imports: [
        SfWebBaseSharedModule,
        SfWebBaseAdminModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        TranCategoryRegexComponent,
        TranCategoryRegexDetailComponent,
        TranCategoryRegexDialogComponent,
        TranCategoryRegexDeleteDialogComponent,
        TranCategoryRegexPopupComponent,
        TranCategoryRegexDeletePopupComponent,
    ],
    entryComponents: [
        TranCategoryRegexComponent,
        TranCategoryRegexDialogComponent,
        TranCategoryRegexPopupComponent,
        TranCategoryRegexDeleteDialogComponent,
        TranCategoryRegexDeletePopupComponent,
    ],
    providers: [
        TranCategoryRegexService,
        TranCategoryRegexPopupService,
        TranCategoryRegexResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SfWebBaseTranCategoryRegexModule {}
