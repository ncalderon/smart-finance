package com.calderon.sf.persistence.interceptor;

import com.calderon.sf.persistence.dto.AbstractEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by Nathaniel on 6/17/2017.
 */
public class AbstractEntityListener {
    @PrePersist
    public void beforeCreate (AbstractEntity abstractEntity) {
        abstractEntity.setModified(Timestamp.from(Instant.now()));
        abstractEntity.setCreated(Timestamp.from(Instant.now()));
    }
    @PreUpdate
    public void beforeUpdate (AbstractEntity abstractEntity) {
        abstractEntity.setModified(Timestamp.from(Instant.now()));
    }
}
