package com.ea544.blogproject.model.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Date;

//@Data
@ToString
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;
    private boolean isDeleted = false;

    public Integer getId() {
        return id;
    }

    public BaseEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public BaseEntity setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public BaseEntity setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
        return this;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public BaseEntity setDeleted(boolean deleted) {
        isDeleted = deleted;
        return this;
    }
}
