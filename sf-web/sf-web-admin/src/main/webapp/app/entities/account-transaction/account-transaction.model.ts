import { BaseEntity } from './../../shared';

const enum TranStatus {
    'PENDING',
    'EXPORTED',
    'DELETED'
}

const enum TranType {
    'DB',
    'CR'
}

const enum TranMethod {
    'DEFAULT'
}

export class AccountTransaction implements BaseEntity {
    constructor(
        public id?: number,
        public tranStatus?: TranStatus,
        public tranType?: TranType,
        public tranNumber?: string,
        public referenceNumber?: string,
        public postDate?: any,
        public description?: string,
        public amount?: number,
        public tranMethod?: TranMethod,
        public tranCategory?: BaseEntity,
        public bankAccount?: BaseEntity,
    ) {
    }
}
