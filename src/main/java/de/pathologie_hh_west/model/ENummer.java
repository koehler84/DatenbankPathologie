package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;

/**
 * Created by VaniR on 10.07.2017.
 */
@Embeddable
public class ENummer {
    private String value;

    public ENummer() {
    }

    public ENummer(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
