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
    private boolean mikropapillaer;
    private boolean lobulaer;
    private boolean muzinoes;
    private boolean papillaer;
    private boolean pleomorph;
    private boolean tubulaer;
    private boolean medullaer;
    private boolean metaplastisch;
    private boolean intrazystisch;
    private boolean intraduktalesPapillaeresKarzinomMitInvasion;

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
        if (mikropapillaer) {
            tumorArt = tumorArt + "mikropapillaer, ";
        }
        if (lobulaer) {
            tumorArt = tumorArt + "lobulaer, ";
        }
        if (muzinoes) {
            tumorArt = tumorArt + "muzinoes, ";
        }
        if (papillaer) {
            tumorArt = tumorArt + "papillaer, ";
        }
        if (pleomorph) {
            tumorArt = tumorArt + "pleomorph, ";
        }
        if (tubulaer) {
            tumorArt = tumorArt + "tubulaer, ";
        }
        if (medullaer) {
            tumorArt = tumorArt + "medullaer, ";
        }
        if (metaplastisch) {
            tumorArt = tumorArt + "metaplastisch, ";
        }
        if (intrazystisch) {
            tumorArt = tumorArt + "intrazystisch, ";
        }
        if (intraduktalesPapillaeresKarzinomMitInvasion) {
            tumorArt = tumorArt + "intraduktales papillaeres Karzinom mit Invasion, ";
        }
        return tumorArt;
    }

    //TODO Setter fuer alle Tumorarten auf einmal (binaere Zahl? String Array? String und patternMatch?
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

    public boolean isMikropapillaer() {
        return mikropapillaer;
    }

    public void setMikropapillaer(boolean mikropapillaer) {
        this.mikropapillaer = mikropapillaer;
    }

    public boolean isLobulaer() {
        return lobulaer;
    }

    public void setLobulaer(boolean lobulaer) {
        this.lobulaer = lobulaer;
    }

    public boolean isMuzinoes() {
        return muzinoes;
    }

    public void setMuzinoes(boolean muzinoes) {
        this.muzinoes = muzinoes;
    }

    public boolean isPapillaer() {
        return papillaer;
    }

    public void setPapillaer(boolean papillaer) {
        this.papillaer = papillaer;
    }

    public boolean isPleomorph() {
        return pleomorph;
    }

    public void setPleomorph(boolean pleomorph) {
        this.pleomorph = pleomorph;
    }

    public boolean isTubulaer() {
        return tubulaer;
    }

    public void setTubulaer(boolean tubulaer) {
        this.tubulaer = tubulaer;
    }

    public boolean isMedullaer() {
        return medullaer;
    }

    public void setMedullaer(boolean medullaer) {
        this.medullaer = medullaer;
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

    public boolean isIntraduktalesPapillaeresKarzinomMitInvasion() {
        return intraduktalesPapillaeresKarzinomMitInvasion;
    }

    public void setIntraduktalesPapillaeresKarzinomMitInvasion(boolean intraduktalesPapillaeresKarzinomMitInvasion) {
        this.intraduktalesPapillaeresKarzinomMitInvasion = intraduktalesPapillaeresKarzinomMitInvasion;
    }
}
