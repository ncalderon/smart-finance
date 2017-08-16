package com.calderon.sf.em.data.model;

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
    private String category = "";
    private String subcategory = "";
    private String paymentMethod;
    private String description;
    private long expensed;
    private long modified;
    private String referenceNumber = "";
    private String property = "";
    private String status;
    private String property2 = "";
    private String property3 = "";
    private String property4 = "";
    private String property5 = "";
    private String tax = "";
    private String expenseTag = "";

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
        if (!(o instanceof ExpenseReportEntity)) return false;

        ExpenseReportEntity that = (ExpenseReportEntity) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
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
