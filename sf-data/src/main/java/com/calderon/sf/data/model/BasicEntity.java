package com.calderon.sf.data.model;

import java.sql.Timestamp;

public interface BasicEntity {
    Timestamp getCreated();
    void setCreated(Timestamp created);
    Timestamp getModified();
    void setModified(Timestamp modified);
}
