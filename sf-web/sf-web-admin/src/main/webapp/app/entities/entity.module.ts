import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { SfWebAdminBankAccountModule } from './bank-account/bank-account.module';
import { SfWebAdminBankModule } from './bank/bank.module';
import { SfWebAdminTranCategoryModule } from './tran-category/tran-category.module';
import { SfWebAdminTranCategoryRegexModule } from './tran-category-regex/tran-category-regex.module';
import { SfWebAdminAccountTransactionModule } from './account-transaction/account-transaction.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        SfWebAdminBankAccountModule,
        SfWebAdminBankModule,
        SfWebAdminTranCategoryModule,
        SfWebAdminTranCategoryRegexModule,
        SfWebAdminAccountTransactionModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SfWebAdminEntityModule {}
