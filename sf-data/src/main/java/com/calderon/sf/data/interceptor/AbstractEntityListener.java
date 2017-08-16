package com.calderon.sf.data.interceptor;

import com.calderon.sf.data.model.BasicEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by Nathaniel on 6/17/2017.
 */
public class AbstractEntityListener {
    @PrePersist
    public void beforeCreate (BasicEntity entity) {
        entity.setModified(Timestamp.from(Instant.now()));
        entity.setCreated(Timestamp.from(Instant.now()));
    }
    @PreUpdate
    public void beforeUpdate (BasicEntity entity) {
        entity.setModified(Timestamp.from(Instant.now()));
    }
}
