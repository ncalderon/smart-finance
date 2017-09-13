import {Component, OnDestroy, OnInit} from '@angular/core';
import {FileUploader} from 'ng2-file-upload';
import {ActivatedRoute} from '@angular/router';
import {UploadAccountTransactionPopupService} from './upload-account-transaction-popup.service';
import {UserService} from '../../../shared/user/user.service';
import {JhiAlertService, JhiEventManager} from 'ng-jhipster';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'jhi-upload-account-transaction-dialog',
  templateUrl: './upload-account-transaction-dialog.component.html',
  styles: []
})

export class UploadAccountTransactionDialogComponent implements OnInit {

    uploader: FileUploader = new FileUploader({url: 'api/account-transactions'});
    hasBaseDropZoneOver = false;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private userService: UserService,
        private eventManager: JhiEventManager
    ) { }

    ngOnInit() {

    }

    public fileOverBase(e: any):void {
        this.hasBaseDropZoneOver = e;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
    }
}

@Component({
    selector: 'jhi-upload-account-transaction-popup',
    template: ''
})
export class UploadAccountTransactionPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private uploadAccountTransactionPopupService: UploadAccountTransactionPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.uploadAccountTransactionPopupService.open(UploadAccountTransactionDialogComponent as Component);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
