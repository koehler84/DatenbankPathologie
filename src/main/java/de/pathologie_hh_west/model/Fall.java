package de.pathologie_hh_west.model;

import javax.persistence.*;

/**
 *
 * Created by VaniR on 10.07.2017.
 */
@Entity
public class Fall {
    @EmbeddedId
    private FallID fallID;

    public Fall() {
    }

    public FallID getFallID() {
        return fallID;
    }

    public void setFallID(FallID fallID) {
        this.fallID = fallID;
    }
}
