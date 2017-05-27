package com.calderon.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Nathaniel on 5/27/2017.
 */
@Entity
@Table(name = "transaction", schema = "heroku_7847d3e246e99bb", catalog = "")
public class TransactionEntity {
    private int id;
    private Timestamp created;
    private Timestamp modified;
    private String tranNum;
    private String tranRefNum;
    private Timestamp tranDate;
    private Timestamp tranPostDate;
    private String tranDesc;
    private BigDecimal tranAmount;

    @Id
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
    @Column(name = "tran_num")
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
    @Column(name = "tran_date")
    public Timestamp getTranDate() {
        return tranDate;
    }

    public void setTranDate(Timestamp tranDate) {
        this.tranDate = tranDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (id != that.id) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (modified != null ? !modified.equals(that.modified) : that.modified != null) return false;
        if (tranNum != null ? !tranNum.equals(that.tranNum) : that.tranNum != null) return false;
        if (tranRefNum != null ? !tranRefNum.equals(that.tranRefNum) : that.tranRefNum != null) return false;
        if (tranDate != null ? !tranDate.equals(that.tranDate) : that.tranDate != null) return false;
        if (tranPostDate != null ? !tranPostDate.equals(that.tranPostDate) : that.tranPostDate != null) return false;
        if (tranDesc != null ? !tranDesc.equals(that.tranDesc) : that.tranDesc != null) return false;
        if (tranAmount != null ? !tranAmount.equals(that.tranAmount) : that.tranAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (tranNum != null ? tranNum.hashCode() : 0);
        result = 31 * result + (tranRefNum != null ? tranRefNum.hashCode() : 0);
        result = 31 * result + (tranDate != null ? tranDate.hashCode() : 0);
        result = 31 * result + (tranPostDate != null ? tranPostDate.hashCode() : 0);
        result = 31 * result + (tranDesc != null ? tranDesc.hashCode() : 0);
        result = 31 * result + (tranAmount != null ? tranAmount.hashCode() : 0);
        return result;
    }
}
