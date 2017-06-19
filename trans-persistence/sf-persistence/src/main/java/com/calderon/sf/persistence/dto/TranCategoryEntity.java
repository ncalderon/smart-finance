package com.calderon.sf.persistence.dto;

import com.calderon.sf.persistence.interceptor.AbstractEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Nathaniel on 6/17/2017.
 */
@Entity
@EntityListeners(AbstractEntityListener.class)
@Table(name = "tran_category", schema = "heroku_7847d3e246e99bb", catalog = "")
public class TranCategoryEntity extends AbstractEntity {
    private int id;
    private Timestamp created;
    private Timestamp modified;
    private int parentId;
    private String name;
    private Collection<TranCategoryRegexEntity> tranCategoryRegexesById;
    private Collection<TransactionEntity> transactionsById;

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
    @Column(name = "parent_id")
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TranCategoryEntity that = (TranCategoryEntity) o;

        if (id != that.id) return false;
        if (parentId != that.parentId) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (modified != null ? !modified.equals(that.modified) : that.modified != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + parentId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tranCategoryByCategoryId")
    public Collection<TranCategoryRegexEntity> getTranCategoryRegexesById() {
        return tranCategoryRegexesById;
    }

    public void setTranCategoryRegexesById(Collection<TranCategoryRegexEntity> tranCategoryRegexesById) {
        this.tranCategoryRegexesById = tranCategoryRegexesById;
    }

    @OneToMany(mappedBy = "tranCategoryByCategoryId")
    public Collection<TransactionEntity> getTransactionsById() {
        return transactionsById;
    }

    public void setTransactionsById(Collection<TransactionEntity> transactionsById) {
        this.transactionsById = transactionsById;
    }

    @Override
    public String toString() {
        return "TranCategoryEntity{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                '}';
    }
}
