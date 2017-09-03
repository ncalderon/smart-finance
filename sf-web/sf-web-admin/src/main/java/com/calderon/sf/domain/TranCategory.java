package com.calderon.sf.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A TranCategory.
 */
@Entity
@Table(name = "tran_category")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TranCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(unique = true)
    private TranCategoryRegex categoryRegex;

    @ManyToOne
    private TranCategory parent;

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

    public TranCategory name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public TranCategory description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TranCategoryRegex getCategoryRegex() {
        return categoryRegex;
    }

    public TranCategory categoryRegex(TranCategoryRegex tranCategoryRegex) {
        this.categoryRegex = tranCategoryRegex;
        return this;
    }

    public void setCategoryRegex(TranCategoryRegex tranCategoryRegex) {
        this.categoryRegex = tranCategoryRegex;
    }

    public TranCategory getParent() {
        return parent;
    }

    public TranCategory parent(TranCategory tranCategory) {
        this.parent = tranCategory;
        return this;
    }

    public void setParent(TranCategory tranCategory) {
        this.parent = tranCategory;
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
        TranCategory tranCategory = (TranCategory) o;
        if (tranCategory.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tranCategory.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TranCategory{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
