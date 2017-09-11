package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;

/**
 * Created by VaniR on 10.07.2017.
 */
@Embeddable
public class ENummer {
    private String value;

    //TODO Utilityfunktionen wie das speichern ob alte oder neue nummer war, jahr der erstellung extrahieren etc.
    //Alt: 962/00591
    //Neu: A/1996/200591
    public ENummer() {
    }

    public ENummer(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {

        if (Pattern.matches("\\d{3}/\\d{5}", value)) {
            int jahr = Integer.parseInt(value.substring(0, 2));
            String laufendeNummer = value.substring(2, 3) + value.substring(4);
            if (jahr < 80) {
                value = "A/20" + String.format("%02d", jahr);
            } else {
                value = "A/19" + String.format("%02d", jahr);
            }
            this.value = value + "/" + laufendeNummer;
        } else if (Pattern.matches("\\p{Alpha}/\\d{4}/\\d{6}", value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Ungueltige ENummer");
        }
    }

}
