import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { AccountTransaction } from './account-transaction.model';
import { AccountTransactionPopupService } from './account-transaction-popup.service';
import { AccountTransactionService } from './account-transaction.service';
import { TranCategory, TranCategoryService } from '../tran-category';
import { BankAccount, BankAccountService } from '../bank-account';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-account-transaction-dialog',
    templateUrl: './account-transaction-dialog.component.html'
})
export class AccountTransactionDialogComponent implements OnInit {

    accountTransaction: AccountTransaction;
    isSaving: boolean;

    trancategories: TranCategory[];

    bankaccounts: BankAccount[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private accountTransactionService: AccountTransactionService,
        private tranCategoryService: TranCategoryService,
        private bankAccountService: BankAccountService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.tranCategoryService
            .query({filter: 'accounttransaction-is-null'})
            .subscribe((res: ResponseWrapper) => {
                if (!this.accountTransaction.tranCategory || !this.accountTransaction.tranCategory.id) {
                    this.trancategories = res.json;
                } else {
                    this.tranCategoryService
                        .find(this.accountTransaction.tranCategory.id)
                        .subscribe((subRes: TranCategory) => {
                            this.trancategories = [subRes].concat(res.json);
                        }, (subRes: ResponseWrapper) => this.onError(subRes.json));
                }
            }, (res: ResponseWrapper) => this.onError(res.json));
        this.bankAccountService
            .query({filter: 'accounttransaction-is-null'})
            .subscribe((res: ResponseWrapper) => {
                if (!this.accountTransaction.bankAccount || !this.accountTransaction.bankAccount.id) {
                    this.bankaccounts = res.json;
                } else {
                    this.bankAccountService
                        .find(this.accountTransaction.bankAccount.id)
                        .subscribe((subRes: BankAccount) => {
                            this.bankaccounts = [subRes].concat(res.json);
                        }, (subRes: ResponseWrapper) => this.onError(subRes.json));
                }
            }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.accountTransaction.id !== undefined) {
            this.subscribeToSaveResponse(
                this.accountTransactionService.update(this.accountTransaction));
        } else {
            this.subscribeToSaveResponse(
                this.accountTransactionService.create(this.accountTransaction));
        }
    }

    private subscribeToSaveResponse(result: Observable<AccountTransaction>) {
        result.subscribe((res: AccountTransaction) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: AccountTransaction) {
        this.eventManager.broadcast({ name: 'accountTransactionListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError(error) {
        try {
            error.json();
        } catch (exception) {
            error.message = error.text();
        }
        this.isSaving = false;
        this.onError(error);
    }

    private onError(error) {
        this.alertService.error(error.message, null, null);
    }

    trackTranCategoryById(index: number, item: TranCategory) {
        return item.id;
    }

    trackBankAccountById(index: number, item: BankAccount) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-account-transaction-popup',
    template: ''
})
export class AccountTransactionPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private accountTransactionPopupService: AccountTransactionPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.accountTransactionPopupService
                    .open(AccountTransactionDialogComponent as Component, params['id']);
            } else {
                this.accountTransactionPopupService
                    .open(AccountTransactionDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
