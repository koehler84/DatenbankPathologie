package de.pathologie_hh_west.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by VaniR on 11.07.2017.
 */
@Entity
public class PatientenZusatzdaten {
    @Id
    private String pseudonym;
    @Embedded
    private Exprimage exprimage;
    @Embedded
    private EE2015 ee2015;
    @Embedded
    private EE2011 ee2011;

    private PatientenZusatzdaten(PatientZusatzdatenBuilder builder) {
        this.pseudonym = builder.pseudonym;
        this.ee2011 = builder.ee2011;
        this.ee2015 = builder.ee2015;
        this.exprimage = builder.exprimage;
    }

    public PatientenZusatzdaten() {
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public static class PatientZusatzdatenBuilder {
        private String pseudonym;
        private EE2011 ee2011;
        private EE2015 ee2015;
        private Exprimage exprimage;

        public PatientZusatzdatenBuilder(String pseudonym) {
            this.pseudonym = pseudonym;
        }

        public PatientZusatzdatenBuilder EE2011(EE2011 ee2011) {
            this.ee2011 = ee2011;
            return this;
        }

        public PatientZusatzdatenBuilder EE2015(EE2015 ee2015) {
            this.ee2015 = ee2015;
            return this;
        }

        public PatientZusatzdatenBuilder Exprimage(Exprimage exprimage) {
            this.exprimage = exprimage;
            return this;
        }

        public PatientenZusatzdaten build() {
            return new PatientenZusatzdaten(this);
        }

    }
}
