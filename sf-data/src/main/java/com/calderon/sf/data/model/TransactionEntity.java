package com.calderon.sf.data.model;

import com.calderon.sf.data.interceptor.AbstractEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * Created by Nathaniel on 6/17/2017.
 */
@Entity
@EntityListeners(AbstractEntityListener.class)
@Table(name = "transaction", schema = "heroku_7847d3e246e99bb", catalog = "")
public class TransactionEntity extends AbstractEntity {
    private int id;
    private Timestamp created;
    private Timestamp modified;
    private Integer statusId;
    private Integer typeId;
    private Integer categoryId;
    private Integer accountId;
    private String tranNum;
    private String tranRefNum;
    private Timestamp tranPostDate;
    private String tranDesc;
    private BigDecimal tranAmount;
    private String tranMethod;
    private TranStatusEntity tranStatusByStatusId;
    private TranTypeEntity tranTypeByTypeId;
    private TranCategoryEntity tranCategoryByCategoryId;
    private AccountEntity accountByAccountId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Basic
    @Column(name = "status_id")
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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
    @Column(name = "category_id")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @NaturalId
    @Basic
    @Column(name = "account_id")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @NaturalId
    @Basic
    @Column(name = "tran_num", unique = true)
    public String getTranNum() {
        return tranNum;
    }

    public void setTranNum(String tranNum) {
        this.tranNum = tranNum;
    }

    @Basic
    @Column(name = "tran_ref_num")
    public String getTranRefNum() {
        return tranRefNum;
    }

    public void setTranRefNum(String tranRefNum) {
        this.tranRefNum = tranRefNum;
    }

    @Basic
    @Column(name = "tran_post_date")
    public Timestamp getTranPostDate() {
        return tranPostDate;
    }

    public void setTranPostDate(Timestamp tranPostDate) {
        this.tranPostDate = tranPostDate;
    }

    @Basic
    @Column(name = "tran_desc")
    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    @Basic
    @Column(name = "tran_amount")
    public BigDecimal getTranAmount() {
        return tranAmount;
    }

    public void setTranAmount(BigDecimal tranAmount) {
        this.tranAmount = tranAmount;
    }

    @Basic
    @Column(name = "tran_method")
    public String getTranMethod() {
        return tranMethod;
    }

    public void setTranMethod(String tranMethod) {
        this.tranMethod = tranMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", insertable = false, updatable = false)
    public TranStatusEntity getTranStatusByStatusId() {
        return tranStatusByStatusId;
    }

    public void setTranStatusByStatusId(TranStatusEntity tranStatusByStatusId) {
        this.tranStatusByStatusId = tranStatusByStatusId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
    public TranTypeEntity getTranTypeByTypeId() {
        return tranTypeByTypeId;
    }

    public void setTranTypeByTypeId(TranTypeEntity tranTypeByTypeId) {
        this.tranTypeByTypeId = tranTypeByTypeId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    public TranCategoryEntity getTranCategoryByCategoryId() {
        return tranCategoryByCategoryId;
    }

    public void setTranCategoryByCategoryId(TranCategoryEntity tranCategoryByCategoryId) {
        this.tranCategoryByCategoryId = tranCategoryByCategoryId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", insertable = false, updatable = false)
    public AccountEntity getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(AccountEntity accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                ", statusId=" + statusId +
                ", typeId=" + typeId +
                ", categoryId=" + categoryId +
                ", accountId=" + accountId +
                ", tranNum='" + tranNum + '\'' +
                ", tranRefNum='" + tranRefNum + '\'' +
                ", tranPostDate=" + tranPostDate +
                ", tranDesc='" + tranDesc + '\'' +
                ", tranAmount=" + tranAmount +
                ", tranMethod='" + tranMethod + '\'' +
                '}';
    }
}
