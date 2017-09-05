import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { TranCategory } from './tran-category.model';
import { TranCategoryPopupService } from './tran-category-popup.service';
import { TranCategoryService } from './tran-category.service';
import { TranCategoryRegex, TranCategoryRegexService } from '../tran-category-regex';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-tran-category-dialog',
    templateUrl: './tran-category-dialog.component.html'
})
export class TranCategoryDialogComponent implements OnInit {

    tranCategory: TranCategory;
    isSaving: boolean;

    trancategoryregexes: TranCategoryRegex[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private tranCategoryService: TranCategoryService,
        private tranCategoryRegexService: TranCategoryRegexService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.tranCategoryRegexService.query()
            .subscribe((res: ResponseWrapper) => { this.trancategoryregexes = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.tranCategory.id !== undefined) {
            this.subscribeToSaveResponse(
                this.tranCategoryService.update(this.tranCategory));
        } else {
            this.subscribeToSaveResponse(
                this.tranCategoryService.create(this.tranCategory));
        }
    }

    private subscribeToSaveResponse(result: Observable<TranCategory>) {
        result.subscribe((res: TranCategory) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: TranCategory) {
        this.eventManager.broadcast({ name: 'tranCategoryListModification', content: 'OK'});
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

    trackTranCategoryRegexById(index: number, item: TranCategoryRegex) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-tran-category-popup',
    template: ''
})
export class TranCategoryPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private tranCategoryPopupService: TranCategoryPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.tranCategoryPopupService
                    .open(TranCategoryDialogComponent as Component, params['id']);
            } else {
                this.tranCategoryPopupService
                    .open(TranCategoryDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}