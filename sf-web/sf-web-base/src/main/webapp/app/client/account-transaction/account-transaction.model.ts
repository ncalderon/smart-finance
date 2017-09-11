import { BaseEntity, User } from './../../shared';

const enum TranStatus {
    'UNCLEARED',
    'CLEARED',
    'RECONCILED',
    'VOID'
}

const enum TranType {
    'EXPENSE',
    'INCOME'
}

const enum PaymentMethod {
    'CASH',
    'CHECK',
    'CREDIT_CARD',
    'DEBIT',
    'ELECTRONIC_TRANSFER'
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
        public paymentMethod?: PaymentMethod,
        public user?: User,
        public bankAccount?: BaseEntity,
        public tranCategory?: BaseEntity,
    ) {
    }
}
