package com.calderon.sf.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

import com.calderon.sf.domain.enumeration.TranStatus;

import com.calderon.sf.domain.enumeration.TranType;

import com.calderon.sf.domain.enumeration.TranMethod;

/**
 * A AccountTransaction.
 */
@Entity
@Table(name = "account_transaction")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tran_status", nullable = false)
    private TranStatus tranStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tran_type", nullable = false)
    private TranType tranType;

    @NotNull
    @Column(name = "tran_number", nullable = false)
    private String tranNumber;

    @Column(name = "reference_number")
    private String referenceNumber;

    @NotNull
    @Column(name = "post_date", nullable = false)
    private Instant postDate;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "amount", precision=10, scale=2, nullable = false)
    private BigDecimal amount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tran_method", nullable = false)
    private TranMethod tranMethod;

    @OneToOne
    @JoinColumn(unique = true)
    private TranCategory tranCategory;

    @OneToOne
    @JoinColumn(unique = true)
    private BankAccount bankAccount;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TranStatus getTranStatus() {
        return tranStatus;
    }

    public AccountTransaction tranStatus(TranStatus tranStatus) {
        this.tranStatus = tranStatus;
        return this;
    }

    public void setTranStatus(TranStatus tranStatus) {
        this.tranStatus = tranStatus;
    }

    public TranType getTranType() {
        return tranType;
    }

    public AccountTransaction tranType(TranType tranType) {
        this.tranType = tranType;
        return this;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public String getTranNumber() {
        return tranNumber;
    }

    public AccountTransaction tranNumber(String tranNumber) {
        this.tranNumber = tranNumber;
        return this;
    }

    public void setTranNumber(String tranNumber) {
        this.tranNumber = tranNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public AccountTransaction referenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Instant getPostDate() {
        return postDate;
    }

    public AccountTransaction postDate(Instant postDate) {
        this.postDate = postDate;
        return this;
    }

    public void setPostDate(Instant postDate) {
        this.postDate = postDate;
    }

    public String getDescription() {
        return description;
    }

    public AccountTransaction description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public AccountTransaction amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TranMethod getTranMethod() {
        return tranMethod;
    }

    public AccountTransaction tranMethod(TranMethod tranMethod) {
        this.tranMethod = tranMethod;
        return this;
    }

    public void setTranMethod(TranMethod tranMethod) {
        this.tranMethod = tranMethod;
    }

    public TranCategory getTranCategory() {
        return tranCategory;
    }

    public AccountTransaction tranCategory(TranCategory tranCategory) {
        this.tranCategory = tranCategory;
        return this;
    }

    public void setTranCategory(TranCategory tranCategory) {
        this.tranCategory = tranCategory;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public AccountTransaction bankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    // jhipster-needle-entity-add-getters-setters - Jhipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountTransaction accountTransaction = (AccountTransaction) o;
        if (accountTransaction.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), accountTransaction.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
            "id=" + getId() +
            ", tranStatus='" + getTranStatus() + "'" +
            ", tranType='" + getTranType() + "'" +
            ", tranNumber='" + getTranNumber() + "'" +
            ", referenceNumber='" + getReferenceNumber() + "'" +
            ", postDate='" + getPostDate() + "'" +
            ", description='" + getDescription() + "'" +
            ", amount='" + getAmount() + "'" +
            ", tranMethod='" + getTranMethod() + "'" +
            "}";
    }
}