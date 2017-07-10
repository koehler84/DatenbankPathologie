package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;

/**
 * Created by VaniR on 10.07.2017.
 */
@Embeddable
public class TumorArt {
    private String invasion;
    private boolean duktal;
    private boolean lipidreich;
    private boolean sekretorisch;
    private boolean adenoidZystisch;
    private boolean glykogenreich;
    private boolean kribriform;
    private boolean mikropapillär;
    private boolean lobulär;
    private boolean muzinös;
    private boolean papillär;
    private boolean pleomorph;
    private boolean tubulär;
    private boolean medullär;
    private boolean metaplastisch;
    private boolean intrazystisch;
    private boolean intraduktalesPapilläresKarzinomMitInvasion;

    public TumorArt() {
    }

    public String getInvasion() {
        return invasion;
    }

    public void setInvasion(String invasion) {
        this.invasion = invasion;
    }

    public String getTumorArt() {
        String tumorArt = "";
        if (duktal) {
            tumorArt = tumorArt + "duktal, ";
        }
        if (lipidreich) {
            tumorArt = tumorArt + "lipidreich, ";
        }
        if (sekretorisch) {
            tumorArt = tumorArt + "sekretorisch, ";
        }
        if (adenoidZystisch) {
            tumorArt = tumorArt + "adenoidZystisch, ";
        }
        if (glykogenreich) {
            tumorArt = tumorArt + "glykogenreich, ";
        }
        if (kribriform) {
            tumorArt = tumorArt + "kribriform, ";
        }
        if (mikropapillär) {
            tumorArt = tumorArt + "mikropapillär, ";
        }
        if (lobulär) {
            tumorArt = tumorArt + "lobulär, ";
        }
        if (muzinös) {
            tumorArt = tumorArt + "muzinös, ";
        }
        if (papillär) {
            tumorArt = tumorArt + "papillär, ";
        }
        if (pleomorph) {
            tumorArt = tumorArt + "pleomorph, ";
        }
        if (tubulär) {
            tumorArt = tumorArt + "tubulär, ";
        }
        if (medullär) {
            tumorArt = tumorArt + "medullär, ";
        }
        if (metaplastisch) {
            tumorArt = tumorArt + "metaplastisch, ";
        }
        if (intrazystisch) {
            tumorArt = tumorArt + "intrazystisch, ";
        }
        if (intraduktalesPapilläresKarzinomMitInvasion) {
            tumorArt = tumorArt + "intraduktales papilläres Karzinom mit Invasion, ";
        }
        return tumorArt;
    }

    //TODO Setter für alle Tumorarten auf einmal (binäre Zahl? String Array? String und patternMatch?
    public void setTumorArt() {

    }

    public boolean isDuktal() {
        return duktal;
    }

    public void setDuktal(boolean duktal) {
        this.duktal = duktal;
    }

    public boolean isLipidreich() {
        return lipidreich;
    }

    public void setLipidreich(boolean lipidreich) {
        this.lipidreich = lipidreich;
    }

    public boolean isSekretorisch() {
        return sekretorisch;
    }

    public void setSekretorisch(boolean sekretorisch) {
        this.sekretorisch = sekretorisch;
    }

    public boolean isAdenoidZystisch() {
        return adenoidZystisch;
    }

    public void setAdenoidZystisch(boolean adenoidZystisch) {
        this.adenoidZystisch = adenoidZystisch;
    }

    public boolean isGlykogenreich() {
        return glykogenreich;
    }

    public void setGlykogenreich(boolean glykogenreich) {
        this.glykogenreich = glykogenreich;
    }

    public boolean isKribriform() {
        return kribriform;
    }

    public void setKribriform(boolean kribriform) {
        this.kribriform = kribriform;
    }

    public boolean isMikropapillär() {
        return mikropapillär;
    }

    public void setMikropapillär(boolean mikropapillär) {
        this.mikropapillär = mikropapillär;
    }

    public boolean isLobulär() {
        return lobulär;
    }

    public void setLobulär(boolean lobulär) {
        this.lobulär = lobulär;
    }

    public boolean isMuzinös() {
        return muzinös;
    }

    public void setMuzinös(boolean muzinös) {
        this.muzinös = muzinös;
    }

    public boolean isPapillär() {
        return papillär;
    }

    public void setPapillär(boolean papillär) {
        this.papillär = papillär;
    }

    public boolean isPleomorph() {
        return pleomorph;
    }

    public void setPleomorph(boolean pleomorph) {
        this.pleomorph = pleomorph;
    }

    public boolean isTubulär() {
        return tubulär;
    }

    public void setTubulär(boolean tubulär) {
        this.tubulär = tubulär;
    }

    public boolean isMedullär() {
        return medullär;
    }

    public void setMedullär(boolean medullär) {
        this.medullär = medullär;
    }

    public boolean isMetaplastisch() {
        return metaplastisch;
    }

    public void setMetaplastisch(boolean metaplastisch) {
        this.metaplastisch = metaplastisch;
    }

    public boolean isIntrazystisch() {
        return intrazystisch;
    }

    public void setIntrazystisch(boolean intrazystisch) {
        this.intrazystisch = intrazystisch;
    }

    public boolean isIntraduktalesPapilläresKarzinomMitInvasion() {
        return intraduktalesPapilläresKarzinomMitInvasion;
    }

    public void setIntraduktalesPapilläresKarzinomMitInvasion(boolean intraduktalesPapilläresKarzinomMitInvasion) {
        this.intraduktalesPapilläresKarzinomMitInvasion = intraduktalesPapilläresKarzinomMitInvasion;
    }
}
