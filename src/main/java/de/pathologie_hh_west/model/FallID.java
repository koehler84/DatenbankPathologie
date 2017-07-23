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
public class FallID implements Serializable {

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
		switch (befundTyp.toLowerCase()) {
			case "hauptbefund":
				this.befundTyp = BefundTyp.HAUPTBEFUND;
				break;
			case "nebenbefund":
				this.befundTyp = BefundTyp.NEBENBEFUND;
				break;
			case "nachbefund":
				this.befundTyp = BefundTyp.NACHBEFUND;
				break;
			default:
				this.befundTyp = BefundTyp.UNBEKANNT;
		}
	}
}
