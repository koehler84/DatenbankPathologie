package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by VaniR on 12.07.2017.
 */
public class PatientAttributAuswahl {
	
	private Patient patient;
	
	public PatientAttributAuswahl(String zellenWert, PatientModelAttribute attributName, Patient patient) {
		if (patient.getAdresse() == null) {
			patient.setAdresse(new Adresse());
		}
		switch (attributName) {
			case VORNAME:
				patient.setVorname(zellenWert);
				break;
			case NACHNAME:
				patient.setNachname(zellenWert);
				break;
			case ALTERNATIVNAME:
				patient.setAlternativName(zellenWert);
				break;
			case STRASSE:
				patient.getAdresse().setStrasse(zellenWert);
				break;
			case HAUSNUMMER:
				patient.getAdresse().setHausnummer(zellenWert);
				break;
			case PLZ:
				patient.getAdresse().setPlz(zellenWert);
				break;
			case ORT:
				patient.getAdresse().setOrt(zellenWert);
				break;
			case LAND:
				patient.getAdresse().setLand(zellenWert);
				break;
			case EXPARZT:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setArzt(zellenWert);
				break;
			case EXPAROMATASEHEMMER:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setAromataseHemmer(zellenWert);
				break;
			case EXPBEMERKUNG:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setBemerkung(zellenWert);
				break;
			case EXPCHEMO:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setChemo(zellenWert);
				break;
			case EXPNOTIZEN:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setNotizen(zellenWert);
				break;
			case EXPRADATIO:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setRadatio(zellenWert);
				break;
			case EXPSTATUS:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setStatus(zellenWert);
				break;
			case EXPTAMOXIFEN:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setTamoxifen(zellenWert);
				break;
			case EXPTODQUELLE:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setTodQuelle(zellenWert);
				break;
			case EE2011AH:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setaH(zellenWert);
				break;
			case EE2011CHEMO:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setChemo(zellenWert);
				break;
			case EE2011FRAUENARZT:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setFrauenarzt(zellenWert);
				break;
			case EE2011HAUSARZT:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setHausarzt(zellenWert);
				break;
			case EE2011NOTIZEN:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setNotizen(zellenWert);
				break;
			case EE2011RADIATIO:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setRadiatio(zellenWert);
				break;
			case EE2011STATUS:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setStatus(zellenWert);
				break;
			case EE2015ANMERKUNGEN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setAnmerkungen(zellenWert);
				break;
			case EE2015BESTRAHLUNG:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setBestrahlung(zellenWert);
				break;
			case EE2015BIOPHOSPHATEN_TEXT:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setBiophosphaten_text(zellenWert);
				break;
			case EE2015BIOPHOSPHONATEN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setBiophosphonaten(zellenWert);
				break;
			case EE2015CHEMO:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setChemo(zellenWert);
				break;
			case EE2015CHEMO_ZEITPUNKT:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				//chemo_zeitpunkt values: "vor der Operation" etc.
				patient.getPatientenZusatzdaten().getEe2015().setChemo_zeitpunkt(zellenWert);
				break;
			case EE2015FRAUENARZT:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setFrauenarzt(zellenWert);
				break;
			case EE2015HAUSARZT:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setHausarzt(zellenWert);
				break;
			case EE2015HERCEPTIN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setHerceptin(zellenWert);
				break;
			case EE2015INFORMATION:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setInformation(zellenWert);
				break;
			case EE2015MEDIKAMENTE:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMedikamente(zellenWert);
				break;
			case EE2015METASTASEN_ANDERE_TEXT:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_andere_text(zellenWert);
				break;
			case EE2015NOTIZEN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setNotizen(zellenWert);
				break;
			case EE2015PSEUDONYM2:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setPseudonym2(zellenWert);
				break;
			case EE2015RAWID:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setRawid(zellenWert);
				break;
			case EE2015SOURCE:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setSource(zellenWert);
				break;
			case EE2015STATUS:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setStatus(zellenWert);
				break;
			case EE2015TODQUELLE:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setTodQuelle(zellenWert);
				break;
			case EE2015WEITERE_ERKRANKUNG:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setWeitere_erkrankung(zellenWert);
				break;
			case EE2015WELLE:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setWelle(zellenWert);
				break;
			case EE2015ZEIT:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setZeit(zellenWert);
				break;
			case EE2015MED_ANITHORMON:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon(Boolean.valueOf(zellenWert));
				break;
			case EE2015MED_ANTIHORMON_ARIMIDEX:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon_arimidex(Boolean.valueOf(zellenWert));
				break;
			case EE2015MED_ANTIHORMON_AROMASIN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon_aromasin(Boolean.valueOf(zellenWert));
				break;
			case EE2015MED_ANTIHORMON_FE03A:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon_fe03a(Boolean.valueOf(zellenWert));
				break;
			case EE2015MED_ANTIHORMON_TAMOXIFEN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon_tamoxifen(Boolean.valueOf(zellenWert));
				break;
			case EE2015MED_ANTIHORMON_UNBEKANNT:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon_unbekannt(Boolean.valueOf(zellenWert));
				break;
			case EE2015METASTASEN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen(Boolean.valueOf(zellenWert));
				break;
			case EE2015METASTASEN_ANDERE:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_andere(Boolean.valueOf(zellenWert));
				break;
			case EE2015METASTASEN_ABRUST:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_abrust(Boolean.valueOf(zellenWert));
				break;
			case EE2015METASTASEN_GEHIRN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_gehirn(Boolean.valueOf(zellenWert));
				break;
			case EE2015METASTASEN_KNOCHEN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_knochen(Boolean.valueOf(zellenWert));
				break;
			case EE2015METASTASEN_LEBER:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_leber(Boolean.valueOf(zellenWert));
				break;
			case EE2015METASTASEN_LUNGE:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_lunge(Boolean.valueOf(zellenWert));
				break;
			case EE2015METASTASEN_LYMPHKNOTEN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_lymphknoten(Boolean.valueOf(zellenWert));
				break;
			case EE2015REZIDIV:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setRezidiv(Boolean.valueOf(zellenWert));
				break;
			default:
				throw new IllegalArgumentException(attributName + " sollte keine Zeichenkette sein");
			
		}
		this.patient = patient;
	}
	
	public PatientAttributAuswahl(BigDecimal zellenWert, PatientModelAttribute attributName, Patient patient) {
		switch (attributName) {
			case PLZ:
				patient.getAdresse().setPlz(zellenWert.intValueExact() + "");
				break;
			case HAUSNUMMER:
				patient.getAdresse().setHausnummer(zellenWert.intValueExact() + "");
				break;
			case EE2011R:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setR(zellenWert.intValueExact());
				break;
			case EE2011REZIDIV_METASTASE:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setRezidiv_Metastase(zellenWert.intValueExact());
				break;
			default:
				throw new IllegalArgumentException(attributName + " sollte keine Zahl sein");
		}
		this.patient = patient;
	}
	
	public PatientAttributAuswahl(LocalDate zellenWert, PatientModelAttribute attributName, Patient patient) {
		switch (attributName) {
			case GEBURTSDATUM:
				patient.setGeburtsDatum(zellenWert);
				break;
			case EXPDATUM:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setDatum(zellenWert);
				break;
			case EXPFOLLOWUP:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setFollowUp(zellenWert);
				break;
			case EXPTODDATUM:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setTodDatum(zellenWert);
				break;
			case EXPTUMORPROGRESS1:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setTumorprogress1(zellenWert);
				break;
			case EXPTUMORPROGRESS2:
				if (patient.getPatientenZusatzdaten().getExprimage() == null) {
					patient.getPatientenZusatzdaten().setExprimage(new Exprimage());
				}
				patient.getPatientenZusatzdaten().getExprimage().setTumorprogress2(zellenWert);
				break;
			case EE2011DATUM:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setDatum(zellenWert);
				break;
			case EE2011RDATUM:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setrDatum(zellenWert);
				break;
			case EE2011RDATUM2:
				if (patient.getPatientenZusatzdaten().getEe2011() == null) {
					patient.getPatientenZusatzdaten().setEe2011(new EE2011());
				}
				patient.getPatientenZusatzdaten().getEe2011().setrDatum2(zellenWert);
				break;
			case EE2015DATUM:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setDatum(zellenWert);
				break;
			case EE2015REZIDIV_ZEITPUNKT:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setRezidiv_zeitpunkt(zellenWert);
				break;
			case EE2015TODDATUM:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setTodDatum(zellenWert);
				break;
			default:
				throw new IllegalArgumentException(attributName + " sollte kein Datum sein");
		}
		this.patient = patient;
	}
	
	public PatientAttributAuswahl(boolean zellenWert, PatientModelAttribute attributName, Patient patient) {
		switch (attributName) {
			case EE2015MED_ANITHORMON:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon(zellenWert);
				break;
			case EE2015MED_ANTIHORMON_ARIMIDEX:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon_arimidex(zellenWert);
				break;
			case EE2015MED_ANTIHORMON_AROMASIN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon_aromasin(zellenWert);
				break;
			case EE2015MED_ANTIHORMON_FE03A:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon_fe03a(zellenWert);
				break;
			case EE2015MED_ANTIHORMON_TAMOXIFEN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon_tamoxifen(zellenWert);
				break;
			case EE2015MED_ANTIHORMON_UNBEKANNT:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMed_antihormon_unbekannt(zellenWert);
				break;
			case EE2015METASTASEN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen(zellenWert);
				break;
			case EE2015METASTASEN_ANDERE:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_andere(zellenWert);
				break;
			case EE2015METASTASEN_ABRUST:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_abrust(zellenWert);
				break;
			case EE2015METASTASEN_GEHIRN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_gehirn(zellenWert);
				break;
			case EE2015METASTASEN_KNOCHEN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_knochen(zellenWert);
				break;
			case EE2015METASTASEN_LEBER:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_leber(zellenWert);
				break;
			case EE2015METASTASEN_LUNGE:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_lunge(zellenWert);
				break;
			case EE2015METASTASEN_LYMPHKNOTEN:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setMetastasen_lymphknoten(zellenWert);
				break;
			case EE2015REZIDIV:
				if (patient.getPatientenZusatzdaten().getEe2015() == null) {
					patient.getPatientenZusatzdaten().setEe2015(new EE2015());
				}
				patient.getPatientenZusatzdaten().getEe2015().setRezidiv(zellenWert);
				break;
			default:
				throw new IllegalArgumentException(attributName + " sollte kein Boolean sein");
			
			
		}
	}
	
	public Patient getPatient() {
		return patient;
	}
}
