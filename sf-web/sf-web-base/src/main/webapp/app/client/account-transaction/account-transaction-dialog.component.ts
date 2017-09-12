import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { AccountTransaction } from './account-transaction.model';
import { AccountTransactionPopupService } from './account-transaction-popup.service';
import { AccountTransactionService } from './account-transaction.service';
import { User, UserService } from '../../shared';
import { BankAccount, BankAccountService } from '../bank-account';
import { TranCategory, TranCategoryService } from '../tran-category';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-account-transaction-dialog',
    templateUrl: './account-transaction-dialog.component.html'
})
export class AccountTransactionDialogComponent implements OnInit {

    accountTransaction: AccountTransaction;
    isSaving: boolean;

    users: User[];

    bankaccounts: BankAccount[];

    trancategories: TranCategory[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private accountTransactionService: AccountTransactionService,
        private userService: UserService,
        private bankAccountService: BankAccountService,
        private tranCategoryService: TranCategoryService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.userService.query()
            .subscribe((res: ResponseWrapper) => { this.users = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.bankAccountService.query()
            .subscribe((res: ResponseWrapper) => { this.bankaccounts = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.tranCategoryService.query()
            .subscribe((res: ResponseWrapper) => { this.trancategories = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
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

    trackUserById(index: number, item: User) {
        return item.id;
    }

    trackBankAccountById(index: number, item: BankAccount) {
        return item.id;
    }

    trackTranCategoryById(index: number, item: TranCategory) {
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