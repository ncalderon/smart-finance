import {Component, OnDestroy, OnInit} from '@angular/core';
import {FileUploader} from 'ng2-file-upload';
import {ActivatedRoute} from '@angular/router';
import {UploadAccountTransactionPopupService} from './upload-account-transaction-popup.service';

@Component({
  selector: 'jhi-upload-account-transaction-dialog',
  templateUrl: './upload-account-transaction-dialog.component.html',
  styles: []
})

export class UploadAccountTransactionDialogComponent implements OnInit {
    public uploader: FileUploader = new FileUploader({url: 'api/account-transactions'});
    public hasBaseDropZoneOver = false;

    constructor() { }

    ngOnInit() {

    }

    public fileOverBase(e: any):void {
        this.hasBaseDropZoneOver = e;
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
