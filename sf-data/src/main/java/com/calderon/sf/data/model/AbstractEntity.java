package com.calderon.sf.data.model;

import java.sql.Timestamp;

/**
 * Created by Nathaniel on 6/17/2017.
 */
public abstract class AbstractEntity {
    private Timestamp created;
    private Timestamp modified;

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
}
