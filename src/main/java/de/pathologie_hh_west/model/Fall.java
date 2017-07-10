package de.pathologie_hh_west.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * Created by VaniR on 10.07.2017.
 */
@Entity
public class Fall {
    @EmbeddedId
    private FallID fallID;
    private String befundtext;

    public Fall() {
    }

    public FallID getFallID() {
        return fallID;
    }

    public void setFallID(FallID fallID) {
        this.fallID = fallID;
    }

    public String getBefundtext() {
        return befundtext;
    }

    public void setBefundtext(String befundtext) {
        this.befundtext = befundtext;
    }
}
