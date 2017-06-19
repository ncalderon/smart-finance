package com.calderon.sf.persistence.external.em.dto;

import javax.persistence.*;

/**
 * Created by Nathaniel on 6/18/2017.
 */
@Entity
@Table(name = "expense_report", schema = "main", catalog = "")
public class ExpenseReportEntity {
    private long id;
    private String account;
    private String amount;
    private String category;
    private String subcategory;
    private String paymentMethod;
    private String description;
    private long expensed;
    private long modified;
    private String referenceNumber;
    private String property;
    private String status;
    private String property2;
    private String property3;
    private String property4;
    private String property5;
    private String tax;
    private String expenseTag;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "amount")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "subcategory")
    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    @Basic
    @Column(name = "payment_method")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "expensed")
    public long getExpensed() {
        return expensed;
    }

    public void setExpensed(long expensed) {
        this.expensed = expensed;
    }

    @Basic
    @Column(name = "modified")
    public long getModified() {
        return modified;
    }

    public void setModified(long modified) {
        this.modified = modified;
    }

    @Basic
    @Column(name = "reference_number")
    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @Basic
    @Column(name = "property")
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "property2")
    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    @Basic
    @Column(name = "property3")
    public String getProperty3() {
        return property3;
    }

    public void setProperty3(String property3) {
        this.property3 = property3;
    }

    @Basic
    @Column(name = "property4")
    public String getProperty4() {
        return property4;
    }

    public void setProperty4(String property4) {
        this.property4 = property4;
    }

    @Basic
    @Column(name = "property5")
    public String getProperty5() {
        return property5;
    }

    public void setProperty5(String property5) {
        this.property5 = property5;
    }

    @Basic
    @Column(name = "tax")
    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    @Basic
    @Column(name = "expense_tag")
    public String getExpenseTag() {
        return expenseTag;
    }

    public void setExpenseTag(String expenseTag) {
        this.expenseTag = expenseTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpenseReportEntity that = (ExpenseReportEntity) o;

        if (id != that.id) return false;
        if (expensed != that.expensed) return false;
        if (modified != that.modified) return false;
        if (!account.equals(that.account)) return false;
        if (!amount.equals(that.amount)) return false;
        if (!category.equals(that.category)) return false;
        if (!subcategory.equals(that.subcategory)) return false;
        if (!paymentMethod.equals(that.paymentMethod)) return false;
        if (!description.equals(that.description)) return false;
        if (!referenceNumber.equals(that.referenceNumber)) return false;
        if (!property.equals(that.property)) return false;
        if (!status.equals(that.status)) return false;
        if (!property2.equals(that.property2)) return false;
        if (!property3.equals(that.property3)) return false;
        if (!property4.equals(that.property4)) return false;
        if (!property5.equals(that.property5)) return false;
        if (!tax.equals(that.tax)) return false;
        return expenseTag.equals(that.expenseTag);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + account.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + subcategory.hashCode();
        result = 31 * result + paymentMethod.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (int) (expensed ^ (expensed >>> 32));
        result = 31 * result + (int) (modified ^ (modified >>> 32));
        result = 31 * result + referenceNumber.hashCode();
        result = 31 * result + property.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + property2.hashCode();
        result = 31 * result + property3.hashCode();
        result = 31 * result + property4.hashCode();
        result = 31 * result + property5.hashCode();
        result = 31 * result + tax.hashCode();
        result = 31 * result + expenseTag.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ExpenseReportEntity{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", amount='" + amount + '\'' +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", description='" + description + '\'' +
                ", expensed=" + expensed +
                ", modified=" + modified +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", property='" + property + '\'' +
                ", status='" + status + '\'' +
                ", property2='" + property2 + '\'' +
                ", property3='" + property3 + '\'' +
                ", property4='" + property4 + '\'' +
                ", property5='" + property5 + '\'' +
                ", tax='" + tax + '\'' +
                ", expenseTag='" + expenseTag + '\'' +
                '}';
    }
}
