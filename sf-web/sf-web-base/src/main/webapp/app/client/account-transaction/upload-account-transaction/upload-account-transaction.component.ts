import {Component, OnDestroy, OnInit} from '@angular/core';
import {JhiEventManager} from 'ng-jhipster';
import {ActivatedRoute} from '@angular/router';
import {Subscription} from 'rxjs/Subscription';
import {AccountTransaction} from '../account-transaction.model';

@Component({
  selector: 'jhi-upload-account-transaction',
  templateUrl: './upload-account-transaction.component.html',
  styles: []
})
export class UploadAccountTransactionComponent implements OnInit, OnDestroy {

    private subscription: Subscription;
    private eventSubscriber: Subscription;
    accountTransactions: AccountTransaction[] = [];

    constructor(
        private eventManager: JhiEventManager,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load();
        });
        /*this.registerChangeInAccountTransactions();*/
    }

    load() {

    }

    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInAccountTransactions() {
        /*this.eventSubscriber = this.eventManager.subscribe(
            'accountTransactionListModification',
            (response) => this.load(this.accountTransaction.id)
        );*/
    }
}
