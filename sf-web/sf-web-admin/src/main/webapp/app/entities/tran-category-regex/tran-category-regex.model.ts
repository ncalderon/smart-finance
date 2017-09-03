import { BaseEntity } from './../../shared';

export class TranCategoryRegex implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public description?: string,
        public categoryRegex?: string,
    ) {
    }
}