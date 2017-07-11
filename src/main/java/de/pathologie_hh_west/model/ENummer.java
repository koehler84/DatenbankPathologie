package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * Created by VaniR on 10.07.2017.
 */
@Embeddable
public class ENummer {
    private String value;

    //Alt: 001/00146
    //Neu: A/1996/200591
    public ENummer() {
    }

    public ENummer(String value) {
        if (Pattern.matches("\\d{3}/\\d{5}", value)) {

            int jahr = Integer.parseInt(value.substring(0, 2));

            DecimalFormat df = new DecimalFormat("00");

            String laufendeNummer = value.substring(2, 3) + value.substring(4);
            if (jahr < 80) {
                value = "A/20" + df.format(jahr);
            } else {
                value = "A/19" + df.format(jahr);
            }
            this.value = value + "/" + laufendeNummer;
        } else if (Pattern.matches("\\p{Alpha}/\\d{4}/\\d{6}", value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Ungueltige ENummer");
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {

        if (Pattern.matches("\\d{3}/\\d{5}", value)) {
            int jahr = Integer.parseInt(value.substring(0, 2));
            String laufendeNummer = value.substring(2, 3) + value.substring(4);
            if (jahr < 80) {
                value = "A/20" + jahr;
            } else {
                value = "A/19" + jahr;
            }
            this.value = value + "/" + laufendeNummer;
        } else if (Pattern.matches("\\p{Alpha}/\\d{4}/\\d{6}", value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Ungueltige ENummer");
        }
    }
}
