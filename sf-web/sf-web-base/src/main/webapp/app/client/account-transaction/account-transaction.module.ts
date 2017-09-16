import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SfWebBaseSharedModule } from '../../shared';
import { SfWebBaseAdminModule } from '../../admin/admin.module';
import {
    AccountTransactionService,
    AccountTransactionPopupService,
    AccountTransactionComponent,
    AccountTransactionDetailComponent,
    AccountTransactionDialogComponent,
    AccountTransactionPopupComponent,
    AccountTransactionDeletePopupComponent,
    AccountTransactionDeleteDialogComponent,
    accountTransactionRoute,
    accountTransactionPopupRoute,
    AccountTransactionResolvePagingParams,
    UploadAccountTransactionComponent
} from './';

import {FileUploadModule} from 'ng2-file-upload';


const ENTITY_STATES = [
    ...accountTransactionRoute,
    ...accountTransactionPopupRoute
];

@NgModule({
    imports: [
        SfWebBaseSharedModule,
        SfWebBaseAdminModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true }),
        FileUploadModule
    ],
    declarations: [
        AccountTransactionComponent,
        AccountTransactionDetailComponent,
        AccountTransactionDialogComponent,
        AccountTransactionDeleteDialogComponent,
        AccountTransactionPopupComponent,
        AccountTransactionDeletePopupComponent
    ],
    entryComponents: [
        AccountTransactionComponent,
        AccountTransactionDialogComponent,
        AccountTransactionPopupComponent,
        AccountTransactionDeleteDialogComponent,
        AccountTransactionDeletePopupComponent
    ],
    providers: [
        AccountTransactionService,
        AccountTransactionPopupService,
        AccountTransactionResolvePagingParams
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SfWebBaseAccountTransactionModule {}
