import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { SfWebBaseBankAccountModule } from './bank-account/bank-account.module';
import { SfWebBaseBankModule } from './bank/bank.module';
import { SfWebBaseTranCategoryModule } from './tran-category/tran-category.module';
import { SfWebBaseTranCategoryRegexModule } from './tran-category-regex/tran-category-regex.module';
import { SfWebBaseAccountTransactionModule } from './account-transaction/account-transaction.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        SfWebBaseBankAccountModule,
        SfWebBaseBankModule,
        SfWebBaseTranCategoryModule,
        SfWebBaseTranCategoryRegexModule,
        SfWebBaseAccountTransactionModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SfWebBaseEntityModule {}
