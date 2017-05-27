package com.calderon.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Nathaniel on 5/27/2017.
 */
@Entity
@Table(name = "account", schema = "heroku_7847d3e246e99bb", catalog = "")
public class AccountEntity {
    private int id;
    private Timestamp created;
    private Timestamp modified;
    private String accNum;
    private String accName;
    private String accDescription;
    private BigDecimal accBalance;

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
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (accNum != null ? accNum.hashCode() : 0);
        result = 31 * result + (accName != null ? accName.hashCode() : 0);
        result = 31 * result + (accDescription != null ? accDescription.hashCode() : 0);
        result = 31 * result + (accBalance != null ? accBalance.hashCode() : 0);
        return result;
    }
}
