package com.calderon.sf.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A TranCategoryRegex.
 */
@Entity
@Table(name = "tran_category_regex")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TranCategoryRegex implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category_regex")
    private String categoryRegex;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public TranCategoryRegex name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public TranCategoryRegex description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryRegex() {
        return categoryRegex;
    }

    public TranCategoryRegex categoryRegex(String categoryRegex) {
        this.categoryRegex = categoryRegex;
        return this;
    }

    public void setCategoryRegex(String categoryRegex) {
        this.categoryRegex = categoryRegex;
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
        TranCategoryRegex tranCategoryRegex = (TranCategoryRegex) o;
        if (tranCategoryRegex.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tranCategoryRegex.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TranCategoryRegex{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", categoryRegex='" + getCategoryRegex() + "'" +
            "}";
    }
}
