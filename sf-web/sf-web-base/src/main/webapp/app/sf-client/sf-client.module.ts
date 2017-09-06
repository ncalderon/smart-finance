import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {SfDashboardModule} from "./sf-dashboard/sf-dashboard.module";
import {SfAccountModule} from "./sf-account/sf-account.module";
import {SfBankModule} from "./sf-bank/sf-bank.module";
import {SfCategoryModule} from "./sf-category/sf-category.module";
import {SfTransactionModule} from "./sf-transaction/sf-transaction.module";

@NgModule({
    imports: [
        SfDashboardModule,
        SfAccountModule,
        SfBankModule,
        SfCategoryModule,
        SfTransactionModule
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})

export class SfClientModule {
}
