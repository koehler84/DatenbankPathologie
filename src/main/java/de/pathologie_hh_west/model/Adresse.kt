package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * Created by VaniR on 10.07.2017.
 */
@Embeddable
class Adresse {

	lateinit var strasse: String
	lateinit var hausnummer: String
	lateinit var plz: String
	lateinit var ort: String
	lateinit var land: String

	fun setHausnummer(hausnummer: BigDecimal) {
		this.hausnummer = hausnummer.intValueExact().toString()
	}
	fun setPLZ(plz: BigDecimal) {
		this.plz = plz.intValueExact().toString()
	}

}
