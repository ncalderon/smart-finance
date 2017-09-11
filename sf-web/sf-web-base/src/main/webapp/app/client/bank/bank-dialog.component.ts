import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Bank } from './bank.model';
import { BankPopupService } from './bank-popup.service';
import { BankService } from './bank.service';
import { User, UserService } from '../../shared';
import { ResponseWrapper } from '../../shared';
import {Principal} from '../../shared/auth/principal.service';

@Component({
    selector: 'jhi-bank-dialog',
    templateUrl: './bank-dialog.component.html'
})
export class BankDialogComponent implements OnInit {

    currentAccount: any;
    bank: Bank;
    isSaving: boolean;

    users: User[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private bankService: BankService,
        private userService: UserService,
        private eventManager: JhiEventManager,
        private principal: Principal,
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.userService.query()
            .subscribe((res: ResponseWrapper) => { this.users = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        this.bank.user = this.currentAccount;
        if (this.bank.id !== undefined) {
            this.subscribeToSaveResponse(
                this.bankService.update(this.bank));
        } else {
            this.subscribeToSaveResponse(
                this.bankService.create(this.bank));
        }
    }

    private subscribeToSaveResponse(result: Observable<Bank>) {
        result.subscribe((res: Bank) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Bank) {
        this.eventManager.broadcast({ name: 'bankListModification', content: 'OK'});
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
}

@Component({
    selector: 'jhi-bank-popup',
    template: ''
})
export class BankPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private bankPopupService: BankPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.bankPopupService
                    .open(BankDialogComponent as Component, params['id']);
            } else {
                this.bankPopupService
                    .open(BankDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
