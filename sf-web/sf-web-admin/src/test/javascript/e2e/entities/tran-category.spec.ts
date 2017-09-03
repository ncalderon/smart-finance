import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('TranCategory e2e test', () => {

    let navBarPage: NavBarPage;
    let tranCategoryDialogPage: TranCategoryDialogPage;
    let tranCategoryComponentsPage: TranCategoryComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load TranCategories', () => {
        navBarPage.goToEntity('tran-category');
        tranCategoryComponentsPage = new TranCategoryComponentsPage();
        expect(tranCategoryComponentsPage.getTitle()).toMatch(/sfWebAdminApp.tranCategory.home.title/);

    });

    it('should load create TranCategory dialog', () => {
        tranCategoryComponentsPage.clickOnCreateButton();
        tranCategoryDialogPage = new TranCategoryDialogPage();
        expect(tranCategoryDialogPage.getModalTitle()).toMatch(/sfWebAdminApp.tranCategory.home.createOrEditLabel/);
        tranCategoryDialogPage.close();
    });

    it('should create and save TranCategories', () => {
        tranCategoryComponentsPage.clickOnCreateButton();
        tranCategoryDialogPage.setNameInput('name');
        expect(tranCategoryDialogPage.getNameInput()).toMatch('name');
        tranCategoryDialogPage.setDescriptionInput('description');
        expect(tranCategoryDialogPage.getDescriptionInput()).toMatch('description');
        tranCategoryDialogPage.categoryRegexSelectLastOption();
        tranCategoryDialogPage.parentSelectLastOption();
        tranCategoryDialogPage.save();
        expect(tranCategoryDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class TranCategoryComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-tran-category div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class TranCategoryDialogPage {
    modalTitle = element(by.css('h4#myTranCategoryLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    descriptionInput = element(by.css('input#field_description'));
    categoryRegexSelect = element(by.css('select#field_categoryRegex'));
    parentSelect = element(by.css('select#field_parent'));

    getModalTitle() {
        return this.modalTitle.getAttribute('jhiTranslate');
    }

    setNameInput = function (name) {
        this.nameInput.sendKeys(name);
    }

    getNameInput = function () {
        return this.nameInput.getAttribute('value');
    }

    setDescriptionInput = function (description) {
        this.descriptionInput.sendKeys(description);
    }

    getDescriptionInput = function () {
        return this.descriptionInput.getAttribute('value');
    }

    categoryRegexSelectLastOption = function () {
        this.categoryRegexSelect.all(by.tagName('option')).last().click();
    }

    categoryRegexSelectOption = function (option) {
        this.categoryRegexSelect.sendKeys(option);
    }

    getCategoryRegexSelect = function () {
        return this.categoryRegexSelect;
    }

    getCategoryRegexSelectedOption = function () {
        return this.categoryRegexSelect.element(by.css('option:checked')).getText();
    }

    parentSelectLastOption = function () {
        this.parentSelect.all(by.tagName('option')).last().click();
    }

    parentSelectOption = function (option) {
        this.parentSelect.sendKeys(option);
    }

    getParentSelect = function () {
        return this.parentSelect;
    }

    getParentSelectedOption = function () {
        return this.parentSelect.element(by.css('option:checked')).getText();
    }

    save() {
        this.saveButton.click();
    }

    close() {
        this.closeButton.click();
    }

    getSaveButton() {
        return this.saveButton;
    }
}
