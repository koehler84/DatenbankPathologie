package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.EE2011;
import de.pathologie_hh_west.model.EE2015;
import de.pathologie_hh_west.model.Exprimage;
import de.pathologie_hh_west.model.PatientenZusatzdaten;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by VaniR on 14.07.2017.
 */
public class PatientZusatzdatenAttributAuswahl {

    public PatientZusatzdatenAttributAuswahl(String zellenWert, PatientZusatzdatenModelAttribute attributName, PatientenZusatzdaten patientenZusatzdaten) {
        switch (attributName) {
            case EXPARZT:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setArzt(zellenWert);
                break;
            case EXPAROMATASEHEMMER:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setAromataseHemmer(zellenWert);
                break;
            case EXPBEMERKUNG:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setBemerkung(zellenWert);
                break;
            case EXPCHEMO:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setChemo(zellenWert);
                break;
            case EXPNOTIZEN:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setNotizen(zellenWert);
                break;
            case EXPRADATIO:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setRadatio(zellenWert);
                break;
            case EXPSTATUS:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setStatus(zellenWert);
                break;
            case EXPTAMOXIFEN:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setTamoxifen(zellenWert);
                break;
            case EXPTODQUELLE:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setTodQuelle(zellenWert);
                break;
            case EE2011AH:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setaH(zellenWert);
                break;
            case EE2011CHEMO:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setChemo(zellenWert);
                break;
            case EE2011FRAUENARZT:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setFrauenarzt(zellenWert);
                break;
            case EE2011HAUSARZT:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setHausarzt(zellenWert);
                break;
            case EE2011NOTIZEN:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setNotizen(zellenWert);
                break;
            case EE2011RADIATIO:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setRadiatio(zellenWert);
                break;
            case EE2011STATUS:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setStatus(zellenWert);
                break;
            case EE2015ANMERKUNGEN:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setAnmerkungen(zellenWert);
                break;
            case EE2015BESTRAHLUNG:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setBestrahlung(zellenWert);
                break;
            case EE2015BIOPHOSPHATEN_TEXT:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setBiophosphaten_text(zellenWert);
                break;
            case EE2015BIOPHOSPHONATEN:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setBiophosphonaten(zellenWert);
                break;
            case EE2015CHEMO:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setChemo(zellenWert);
                break;
            case EE2015CHEMO_ZEITPUNKT:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                //chemo_zeitpunkt values: "vor der Operation" etc.
                patientenZusatzdaten.getEe2015().setChemo_zeitpunkt(zellenWert);
                break;
            case EE2015FRAUENARZT:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setFrauenarzt(zellenWert);
                break;
            case EE2015HAUSARZT:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setHausarzt(zellenWert);
                break;
            case EE2015HERCEPTIN:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setHerceptin(zellenWert);
                break;
            case EE2015INFORMATION:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setInformation(zellenWert);
                break;
            case EE2015MEDIKAMENTE:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMedikamente(zellenWert);
                break;
            case EE2015METASTASEN_ANDERE_TEXT:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMetastasen_andere_text(zellenWert);
                break;
            case EE2015NOTIZEN:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setNotizen(zellenWert);
                break;
            case EE2015PSEUDONYM2:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setPseudonym2(zellenWert);
                break;
            case EE2015RAWID:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setRawid(zellenWert);
                break;
            case EE2015SOURCE:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setSource(zellenWert);
                break;
            case EE2015STATUS:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setStatus(zellenWert);
                break;
            case EE2015TODQUELLE:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setTodQuelle(zellenWert);
                break;
            case EE2015WEITERE_ERKRANKUNG:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setWeitere_erkrankung(zellenWert);
                break;
            case EE2015WELLE:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setWelle(zellenWert);
                break;
            case EE2015ZEIT:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setZeit(zellenWert);
                break;
        }
    }

    public PatientZusatzdatenAttributAuswahl(LocalDate zellenWert, PatientZusatzdatenModelAttribute attributName, PatientenZusatzdaten patientenZusatzdaten) {
        switch (attributName) {
            case EXPDATUM:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setDatum(zellenWert);
                break;
            case EXPFOLLOWUP:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setFollowUp(zellenWert);
                break;
            case EXPTODDATUM:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setTodDatum(zellenWert);
                break;
            case EXPTUMORPROGRESS1:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setTumorprogress1(zellenWert);
                break;
            case EXPTUMORPROGRESS2:
                if (patientenZusatzdaten.getExprimage() == null) {
                    patientenZusatzdaten.setExprimage(new Exprimage());
                }
                patientenZusatzdaten.getExprimage().setTumorprogress2(zellenWert);
                break;
            case EE2011DATUM:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setDatum(zellenWert);
                break;
            case EE2011RDATUM:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setrDatum(zellenWert);
                break;
            case EE2011RDATUM2:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setrDatum2(zellenWert);
                break;
            case EE2015DATUM:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setDatum(zellenWert);
                break;
            case EE2015REZIDIV_ZEITPUNKT:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setRezidiv_zeitpunkt(zellenWert);
                break;
            case EE2015TODDATUM:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setTodDatum(zellenWert);
                break;
        }
    }

    public PatientZusatzdatenAttributAuswahl(BigDecimal zellenWert, PatientZusatzdatenModelAttribute attributName, PatientenZusatzdaten patientenZusatzdaten) {
        switch (attributName) {
            case EE2011R:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setR(zellenWert.intValueExact());
                break;
            case EE2011REZIDIV_METASTASE:
                if (patientenZusatzdaten.getEe2011() == null) {
                    patientenZusatzdaten.setEe2011(new EE2011());
                }
                patientenZusatzdaten.getEe2011().setRezidiv_Metastase(zellenWert.intValueExact());
                break;
        }
    }

    public PatientZusatzdatenAttributAuswahl(Boolean zellenWert, PatientZusatzdatenModelAttribute attributName, PatientenZusatzdaten patientenZusatzdaten) {
        switch (attributName) {
            case EE2015MED_ANITHORMON:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMed_antihormon(zellenWert);
                break;
            case EE2015MED_ANTIHORMON_ARIMIDEX:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMed_antihormon_arimidex(zellenWert);
                break;
            case EE2015MED_ANTIHORMON_AROMASIN:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMed_antihormon_aromasin(zellenWert);
                break;
            case EE2015MED_ANTIHORMON_FE03A:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMed_antihormon_fe03a(zellenWert);
                break;
            case EE2015MED_ANTIHORMON_TAMOXIFEN:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMed_antihormon_tamoxifen(zellenWert);
                break;
            case EE2015MED_ANTIHORMON_UNBEKANNT:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMed_antihormon_unbekannt(zellenWert);
                break;
            case EE2015METASTASEN:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMetastasen(zellenWert);
                break;
            case EE2015METASTASEN_ANDERE:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMetastasen_andere(zellenWert);
                break;
            case EE2015METASTASEN_ABRUST:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMetastasen_abrust(zellenWert);
                break;
            case EE2015METASTASEN_GEHIRN:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMetastasen_gehirn(zellenWert);
                break;
            case EE2015METASTASEN_KNOCHEN:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMetastasen_knochen(zellenWert);
                break;
            case EE2015METASTASEN_LEBER:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMetastasen_leber(zellenWert);
                break;
            case EE2015METASTASEN_LUNGE:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMetastasen_lunge(zellenWert);
                break;
            case EE2015METASTASEN_LYMPHKNOTEN:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setMetastasen_lymphknoten(zellenWert);
                break;
            case EE2015REZIDIV:
                if (patientenZusatzdaten.getEe2015() == null) {
                    patientenZusatzdaten.setEe2015(new EE2015());
                }
                patientenZusatzdaten.getEe2015().setRezidiv(zellenWert);
                break;
        }
    }
}
