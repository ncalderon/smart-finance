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
    uploadAccountTransactionPopupRoute
} from './';
import {
    UploadAccountTransactionDialogComponent,
    UploadAccountTransactionPopupComponent
} from './upload-account-transaction-dialog/upload-account-transaction-dialog.component';
import {UploadAccountTransactionPopupService} from './upload-account-transaction-dialog/upload-account-transaction-popup.service';


const ENTITY_STATES = [
    ...accountTransactionRoute,
    ...accountTransactionPopupRoute,
    ...uploadAccountTransactionPopupRoute
];

@NgModule({
    imports: [
        SfWebBaseSharedModule,
        SfWebBaseAdminModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        AccountTransactionComponent,
        AccountTransactionDetailComponent,
        AccountTransactionDialogComponent,
        AccountTransactionDeleteDialogComponent,
        AccountTransactionPopupComponent,
        AccountTransactionDeletePopupComponent,
        UploadAccountTransactionDialogComponent,
        UploadAccountTransactionPopupComponent
    ],
    entryComponents: [
        AccountTransactionComponent,
        AccountTransactionDialogComponent,
        AccountTransactionPopupComponent,
        AccountTransactionDeleteDialogComponent,
        AccountTransactionDeletePopupComponent,
        UploadAccountTransactionDialogComponent,
        UploadAccountTransactionPopupComponent
    ],
    providers: [
        AccountTransactionService,
        AccountTransactionPopupService,
        AccountTransactionResolvePagingParams,
        UploadAccountTransactionPopupService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SfWebBaseAccountTransactionModule {}
