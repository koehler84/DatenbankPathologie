package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * Created by VaniR on 10.07.2017.
 */
@Embeddable
public class FallID implements Serializable, Comparable {

	@Embedded
	private ENummer eNummer;
	@Enumerated(EnumType.STRING)
	private BefundTyp befundTyp;

	public FallID() {
		this.eNummer = new ENummer();
		this.befundTyp = BefundTyp.UNBEKANNT;
	}

	public FallID(ENummer eNummer) {
		this.eNummer = eNummer;
	}

	public ENummer geteNummer() {
		return eNummer;
	}

	public void seteNummer(ENummer eNummer) {

		this.eNummer = eNummer;

	}

	public BefundTyp getBefundTyp() {
		return befundTyp;
	}

	public void setBefundTyp(BefundTyp befundTyp) {
		this.befundTyp = befundTyp;
	}

	public void setBefundTyp(String befundTyp) {
        String s = befundTyp.toLowerCase();
        if (s.contains("hauptbefund")) {
            this.befundTyp = BefundTyp.HAUPTBEFUND;

        } else if (s.contains("konsiliarbericht")) {
            this.befundTyp = BefundTyp.KONSILIARERICHT;

        } else if (s.contains("korrekturbefund 1")) {
            this.befundTyp = BefundTyp.KORREKTURBEFUND1;

        } else if (s.contains("korrekturbefund 2")) {
            this.befundTyp = BefundTyp.KORREKTURBEFUND2;

        } else if (s.contains("korrekturbefund 3")) {
            this.befundTyp = BefundTyp.KORREKTURBEFUND3;

        } else if (s.contains("korrekturbefund 4")) {
            this.befundTyp = BefundTyp.KORREKTURBEFUND4;

        } else if (s.contains("nachbericht 1")) {
            this.befundTyp = BefundTyp.NACHBERICHT1;

        } else if (s.contains("nachbericht 2")) {
            this.befundTyp = BefundTyp.NACHBERICHT2;

        } else {
            this.befundTyp = BefundTyp.UNBEKANNT;
        }


    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (!(o instanceof FallID)) return 1;

        FallID fallID = (FallID) o;

        if (geteNummer().getValue() != "" ? !geteNummer().getValue().equals(fallID.geteNummer().getValue()) : fallID.geteNummer().getValue() != "")
            return 1;
        if (getBefundTyp() == fallID.getBefundTyp()) {
            return 0;
        } else return 1;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof FallID)) return false;
//
//        FallID fallID = (FallID) o;
//
//        if (geteNummer().getValue() != "" ? !geteNummer().getValue().equals(fallID.geteNummer().getValue()) : fallID.geteNummer().getValue() != "")
//            return false;
//        return getBefundTyp() == fallID.getBefundTyp();
//    }
//
//    @Override
//    public int hashCode() {
//        int result = geteNummer().getValue() != "" ? geteNummer().getValue().hashCode() : 0;
//        result = 31 * result + (getBefundTyp() != null ? getBefundTyp().hashCode() : 0);
//        return result;
//    }
}
