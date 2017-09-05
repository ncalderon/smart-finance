import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('AccountTransaction e2e test', () => {

    let navBarPage: NavBarPage;
    let accountTransactionDialogPage: AccountTransactionDialogPage;
    let accountTransactionComponentsPage: AccountTransactionComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load AccountTransactions', () => {
        navBarPage.goToEntity('account-transaction');
        accountTransactionComponentsPage = new AccountTransactionComponentsPage();
        expect(accountTransactionComponentsPage.getTitle()).toMatch(/sfWebBaseApp.accountTransaction.home.title/);

    });

    it('should load create AccountTransaction dialog', () => {
        accountTransactionComponentsPage.clickOnCreateButton();
        accountTransactionDialogPage = new AccountTransactionDialogPage();
        expect(accountTransactionDialogPage.getModalTitle()).toMatch(/sfWebBaseApp.accountTransaction.home.createOrEditLabel/);
        accountTransactionDialogPage.close();
    });

   /* it('should create and save AccountTransactions', () => {
        accountTransactionComponentsPage.clickOnCreateButton();
        accountTransactionDialogPage.tranStatusSelectLastOption();
        accountTransactionDialogPage.tranTypeSelectLastOption();
        accountTransactionDialogPage.setTranNumberInput('tranNumber');
        expect(accountTransactionDialogPage.getTranNumberInput()).toMatch('tranNumber');
        accountTransactionDialogPage.setReferenceNumberInput('referenceNumber');
        expect(accountTransactionDialogPage.getReferenceNumberInput()).toMatch('referenceNumber');
        accountTransactionDialogPage.setPostDateInput(12310020012301);
        expect(accountTransactionDialogPage.getPostDateInput()).toMatch('2001-12-31T02:30');
        accountTransactionDialogPage.setDescriptionInput('description');
        expect(accountTransactionDialogPage.getDescriptionInput()).toMatch('description');
        accountTransactionDialogPage.setAmountInput('5');
        expect(accountTransactionDialogPage.getAmountInput()).toMatch('5');
        accountTransactionDialogPage.tranMethodSelectLastOption();
        accountTransactionDialogPage.bankAccountSelectLastOption();
        accountTransactionDialogPage.tranCategorySelectLastOption();
        accountTransactionDialogPage.save();
        expect(accountTransactionDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); */

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class AccountTransactionComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-account-transaction div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class AccountTransactionDialogPage {
    modalTitle = element(by.css('h4#myAccountTransactionLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    tranStatusSelect = element(by.css('select#field_tranStatus'));
    tranTypeSelect = element(by.css('select#field_tranType'));
    tranNumberInput = element(by.css('input#field_tranNumber'));
    referenceNumberInput = element(by.css('input#field_referenceNumber'));
    postDateInput = element(by.css('input#field_postDate'));
    descriptionInput = element(by.css('input#field_description'));
    amountInput = element(by.css('input#field_amount'));
    tranMethodSelect = element(by.css('select#field_tranMethod'));
    bankAccountSelect = element(by.css('select#field_bankAccount'));
    tranCategorySelect = element(by.css('select#field_tranCategory'));

    getModalTitle() {
        return this.modalTitle.getAttribute('jhiTranslate');
    }

    setTranStatusSelect = function (tranStatus) {
        this.tranStatusSelect.sendKeys(tranStatus);
    }

    getTranStatusSelect = function () {
        return this.tranStatusSelect.element(by.css('option:checked')).getText();
    }

    tranStatusSelectLastOption = function () {
        this.tranStatusSelect.all(by.tagName('option')).last().click();
    }
    setTranTypeSelect = function (tranType) {
        this.tranTypeSelect.sendKeys(tranType);
    }

    getTranTypeSelect = function () {
        return this.tranTypeSelect.element(by.css('option:checked')).getText();
    }

    tranTypeSelectLastOption = function () {
        this.tranTypeSelect.all(by.tagName('option')).last().click();
    }
    setTranNumberInput = function (tranNumber) {
        this.tranNumberInput.sendKeys(tranNumber);
    }

    getTranNumberInput = function () {
        return this.tranNumberInput.getAttribute('value');
    }

    setReferenceNumberInput = function (referenceNumber) {
        this.referenceNumberInput.sendKeys(referenceNumber);
    }

    getReferenceNumberInput = function () {
        return this.referenceNumberInput.getAttribute('value');
    }

    setPostDateInput = function (postDate) {
        this.postDateInput.sendKeys(postDate);
    }

    getPostDateInput = function () {
        return this.postDateInput.getAttribute('value');
    }

    setDescriptionInput = function (description) {
        this.descriptionInput.sendKeys(description);
    }

    getDescriptionInput = function () {
        return this.descriptionInput.getAttribute('value');
    }

    setAmountInput = function (amount) {
        this.amountInput.sendKeys(amount);
    }

    getAmountInput = function () {
        return this.amountInput.getAttribute('value');
    }

    setTranMethodSelect = function (tranMethod) {
        this.tranMethodSelect.sendKeys(tranMethod);
    }

    getTranMethodSelect = function () {
        return this.tranMethodSelect.element(by.css('option:checked')).getText();
    }

    tranMethodSelectLastOption = function () {
        this.tranMethodSelect.all(by.tagName('option')).last().click();
    }
    bankAccountSelectLastOption = function () {
        this.bankAccountSelect.all(by.tagName('option')).last().click();
    }

    bankAccountSelectOption = function (option) {
        this.bankAccountSelect.sendKeys(option);
    }

    getBankAccountSelect = function () {
        return this.bankAccountSelect;
    }

    getBankAccountSelectedOption = function () {
        return this.bankAccountSelect.element(by.css('option:checked')).getText();
    }

    tranCategorySelectLastOption = function () {
        this.tranCategorySelect.all(by.tagName('option')).last().click();
    }

    tranCategorySelectOption = function (option) {
        this.tranCategorySelect.sendKeys(option);
    }

    getTranCategorySelect = function () {
        return this.tranCategorySelect;
    }

    getTranCategorySelectedOption = function () {
        return this.tranCategorySelect.element(by.css('option:checked')).getText();
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
