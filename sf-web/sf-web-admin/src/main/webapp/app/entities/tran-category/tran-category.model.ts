import { BaseEntity } from './../../shared';

export class TranCategory implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public description?: string,
        public categoryRegex?: BaseEntity,
        public parent?: BaseEntity,
    ) {
    }
}
