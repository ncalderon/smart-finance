package com.calderon.sf.persistence.dto;

import com.calderon.sf.persistence.interceptor.AbstractEntityListener;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Nathaniel on 6/17/2017.
 */
@Entity
@EntityListeners(AbstractEntityListener.class)
@Table(name = "account", schema = "heroku_7847d3e246e99bb", catalog = "")
public class AccountEntity extends AbstractEntity {
    private int id;
    private Integer statusId;
    private Integer bankId;
    private Integer typeId;
    private Timestamp created;
    private Timestamp modified;
    private String accNum;
    private String accName;
    private String accDescription;
    private BigDecimal accBalance;
    private AccountStatusEntity accountStatusByStatusId;
    private BankEntity bankByBankId;
    private AccountTypeEntity accountTypeByTypeId;
    private Collection<TransactionEntity> transactionsById;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status_id")
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "bank_id")
    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    @Basic
    @Column(name = "type_id")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "modified")
    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    @NaturalId
    @Basic
    @Column(name = "acc_num")
    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    @NaturalId
    @Basic
    @Column(name = "acc_name")
    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    @Basic
    @Column(name = "acc_description")
    public String getAccDescription() {
        return accDescription;
    }

    public void setAccDescription(String accDescription) {
        this.accDescription = accDescription;
    }

    @Basic
    @Column(name = "acc_balance")
    public BigDecimal getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(BigDecimal accBalance) {
        this.accBalance = accBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", insertable = false, updatable = false)
    public AccountStatusEntity getAccountStatusByStatusId() {
        return accountStatusByStatusId;
    }

    public void setAccountStatusByStatusId(AccountStatusEntity accountStatusByStatusId) {
        this.accountStatusByStatusId = accountStatusByStatusId;
    }

    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id", insertable = false, updatable = false)
    public BankEntity getBankByBankId() {
        return bankByBankId;
    }

    public void setBankByBankId(BankEntity bankByBankId) {
        this.bankByBankId = bankByBankId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
    public AccountTypeEntity getAccountTypeByTypeId() {
        return accountTypeByTypeId;
    }

    public void setAccountTypeByTypeId(AccountTypeEntity accountTypeByTypeId) {
        this.accountTypeByTypeId = accountTypeByTypeId;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<TransactionEntity> getTransactionsById() {
        return transactionsById;
    }

    public void setTransactionsById(Collection<TransactionEntity> transactionsById) {
        this.transactionsById = transactionsById;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", statusId=" + statusId +
                ", bankId=" + bankId +
                ", typeId=" + typeId +
                ", created=" + created +
                ", modified=" + modified +
                ", accNum='" + accNum + '\'' +
                ", accName='" + accName + '\'' +
                ", accDescription='" + accDescription + '\'' +
                ", accBalance=" + accBalance +
                '}';
    }
}
