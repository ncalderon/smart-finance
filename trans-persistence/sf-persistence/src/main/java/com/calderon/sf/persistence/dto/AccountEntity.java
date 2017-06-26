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
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
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

        if (id != that.id) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (bankId != null ? !bankId.equals(that.bankId) : that.bankId != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (modified != null ? !modified.equals(that.modified) : that.modified != null) return false;
        if (accNum != null ? !accNum.equals(that.accNum) : that.accNum != null) return false;
        if (accName != null ? !accName.equals(that.accName) : that.accName != null) return false;
        if (accDescription != null ? !accDescription.equals(that.accDescription) : that.accDescription != null)
            return false;
        if (accBalance != null ? !accBalance.equals(that.accBalance) : that.accBalance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (bankId != null ? bankId.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (accNum != null ? accNum.hashCode() : 0);
        result = 31 * result + (accName != null ? accName.hashCode() : 0);
        result = 31 * result + (accDescription != null ? accDescription.hashCode() : 0);
        result = 31 * result + (accBalance != null ? accBalance.hashCode() : 0);
        return result;
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
