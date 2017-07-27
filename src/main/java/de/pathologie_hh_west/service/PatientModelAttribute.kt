package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.*;
import org.apache.poi.xssf.usermodel.XSSFCell

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by VaniR on 13.07.2017.
 */
enum class PatientModelAttribute {
	
	VORNAME, NACHNAME, GEBURTSDATUM, ALTERNATIVNAME, STRASSE, HAUSNUMMER, PLZ, ORT, LAND, EE2011STATUS, EE2011DATUM,
	EE2011REZIDIV_METASTASE, EE2011R, EE2011RDATUM, EE2011RDATUM2, EE2011NOTIZEN, EE2011CHEMO, EE2011RADIATIO,
	EE2011AH, EE2011HAUSARZT, EE2011FRAUENARZT, EE2015PSEUDONYM2, EE2015STATUS, EE2015DATUM, EE2015TODQUELLE, EE2015TODDATUM,
	EE2015NOTIZEN, EE2015WELLE, EE2015RAWID, EE2015SOURCE, EE2015ZEIT, EE2015CHEMO, EE2015CHEMO_ZEITPUNKT,
	EE2015MEDIKAMENTE, EE2015BESTRAHLUNG, EE2015MED_ANITHORMON, EE2015MED_ANTIHORMON_UNBEKANNT,
	EE2015MED_ANTIHORMON_TAMOXIFEN, EE2015MED_ANTIHORMON_ARIMIDEX, EE2015MED_ANTIHORMON_AROMASIN,
	EE2015MED_ANTIHORMON_FE03A, EE2015HERCEPTIN, EE2015BIOPHOSPHONATEN, EE2015BIOPHOSPHATEN_TEXT,
	EE2015WEITERE_ERKRANKUNG, EE2015REZIDIV, EE2015METASTASEN, EE2015METASTASEN_ABRUST, EE2015METASTASEN_LYMPHKNOTEN,
	EE2015METASTASEN_KNOCHEN, EE2015METASTASEN_LUNGE, EE2015METASTASEN_GEHIRN, EE2015METASTASEN_LEBER,
	EE2015METASTASEN_ANDERE, EE2015METASTASEN_ANDERE_TEXT, EE2015REZIDIV_ZEITPUNKT, EE2015HAUSARZT, EE2015FRAUENARZT,
	EE2015ANMERKUNGEN, EE2015INFORMATION, EXPNOTIZEN, EXPCHEMO, EXPTAMOXIFEN, EXPAROMATASEHEMMER, EXPRADATIO,
	EXPTUMORPROGRESS1, EXPTUMORPROGRESS2, EXPSTATUS, EXPDATUM, EXPFOLLOWUP, EXPTODQUELLE, EXPTODDATUM, EXPBEMERKUNG,
	EXPARZT, G, T, N, M, L, V, R, NGESAMT, NMETA, ER, ERIRS, PR, PRIRS, HER2NEU, HER2NEUSCORE,
	KI67, INVASION, DUKTAL, LIPIDREICH, SEKRETORISCH, ADENOIDZYSTISCH, GLYKOGENREICH, KRIBRIFORM,
	MIKROPAPILLAER, LOBULAER, MUZINOES, PAPILLAER, PLEOMORPH, TUBULAER, MEDULLAER, METAPLASTISCH,
	INTRAZYSTISCH, INTRADUKTALESPAPILLAERESKARZINOMMITINVASION, BEFUNDTEXT, FALLID, VALUE, ENUMMER, INDEX, BEFUNDTYP;
	
	fun getWrappingClass(): Class<*> {
		val classes = arrayOf(Patient::class.java, Adresse::class.java, Exprimage::class.java, EE2015::class.java, EE2011::class.java,
				Fall::class.java, FallID::class.java, ENummer::class.java, Klassifikation::class.java, TumorArt::class.java)
		
		val wrappingClassCandidates = classes.flatMap { it.declaredFields.asIterable() }
				.filter { it.name.equals(this.name, true) }
				.map(Field::getDeclaringClass)
		
		if (wrappingClassCandidates.size == 1) return wrappingClassCandidates[0]
		else if (wrappingClassCandidates.isEmpty()) throw RuntimeException("Getter for field $name not found.")
		else throw RuntimeException("Multiple wrapper classes found for field $name. Expected one.")
	}
	
	fun getGetter(): Method {
		val wrappingClass = getWrappingClass()
		val getters = wrappingClass.methods.asIterable()
				.filter { it.name.startsWith("get") }
				.filter { it.name.equals("get$name", true) }
		
		if (getters.size == 1) return getters[0]
		else if (getters.isEmpty()) throw RuntimeException("Getter for field $name not found.");
		else throw RuntimeException("Multiple getters found for field $name. Expected one.")
	}
}
