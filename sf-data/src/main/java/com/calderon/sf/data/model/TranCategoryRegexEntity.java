package com.calderon.sf.data.model;

import javax.persistence.*;
/**
 * Created by Nathaniel on 6/17/2017.
 */
@Entity
@Table(name = "tran_category_regex", schema = "heroku_7847d3e246e99bb", catalog = "")
public class TranCategoryRegexEntity {
    private int id;
    private int categoryId;
    private String regexstr;
    private String description;
    private TranCategoryEntity tranCategoryByCategoryId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "regexstr")
    public String getRegexstr() {
        return regexstr;
    }

    public void setRegexstr(String regexstr) {
        this.regexstr = regexstr;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TranCategoryRegexEntity that = (TranCategoryRegexEntity) o;

        if (id != that.id) return false;
        if (categoryId != that.categoryId) return false;
        if (regexstr != null ? !regexstr.equals(that.regexstr) : that.regexstr != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + categoryId;
        result = 31 * result + (regexstr != null ? regexstr.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public TranCategoryEntity getTranCategoryByCategoryId() {
        return tranCategoryByCategoryId;
    }

    public void setTranCategoryByCategoryId(TranCategoryEntity tranCategoryByCategoryId) {
        this.tranCategoryByCategoryId = tranCategoryByCategoryId;
    }

    @Override
    public String toString() {
        return "TranCategoryRegexEntity{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", regexstr='" + regexstr + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
