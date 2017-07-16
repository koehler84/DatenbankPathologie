package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;
import java.time.LocalDate;

/**
 * Created by VaniR on 11.07.2017.
 */
@Embeddable
public class EE2015 {
    private String pseudonym2;
    private String status;
    private LocalDate datum;
    private String todQuelle;
    private LocalDate todDatum;
    private String notizen;
    private String welle;
    private String rawid;
    private String source;
    private String zeit;
    private String chemo;
    private String chemo_zeitpunkt;
    private String medikamente;
    private String bestrahlung;
    private Boolean med_anithormon;
    private Boolean med_antihormon_unbekannt;
    private Boolean med_antihormon_tamoxifen;
    private Boolean med_antihormon_arimidex;
    private Boolean med_antihormon_aromasin;
    private Boolean med_antihormon_fe03a;
    private String herceptin;
    private String biophosphonaten;
    private String biophosphaten_text;
    private String weitere_erkrankung;
    private Boolean rezidiv;
    private Boolean metastasen;
    private Boolean metastasen_abrust;
    private Boolean metastasen_lymphknoten;
    private Boolean metastasen_knochen;
    private Boolean metastasen_lunge;
    private Boolean metastasen_gehirn;
    private Boolean metastasen_leber;
    private Boolean metastasen_andere;
    private String metastasen_andere_text;
    private LocalDate rezidiv_zeitpunkt;
    private String hausarzt;
    private String frauenarzt;
    private String anmerkungen;
    private String information;

    public EE2015() {
    }

    public String getPseudonym2() {
        return pseudonym2;
    }

    public void setPseudonym2(String pseudonym2) {
        this.pseudonym2 = pseudonym2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getTodQuelle() {
        return todQuelle;
    }

    public void setTodQuelle(String todQuelle) {
        this.todQuelle = todQuelle;
    }

    public LocalDate getTodDatum() {
        return todDatum;
    }

    public void setTodDatum(LocalDate todDatum) {
        this.todDatum = todDatum;
    }

    public String getNotizen() {
        return notizen;
    }

    public void setNotizen(String notizen) {
        this.notizen = notizen;
    }

    public String getWelle() {
        return welle;
    }

    public void setWelle(String welle) {
        this.welle = welle;
    }

    public String getRawid() {
        return rawid;
    }

    public void setRawid(String rawid) {
        this.rawid = rawid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getZeit() {
        return zeit;
    }

    public void setZeit(String zeit) {
        this.zeit = zeit;
    }

    public String getChemo() {
        return chemo;
    }

    public void setChemo(String chemo) {
        this.chemo = chemo;
    }

    public String getChemo_zeitpunkt() {
        return chemo_zeitpunkt;
    }

    public void setChemo_zeitpunkt(String chemo_zeitpunkt) {
        this.chemo_zeitpunkt = chemo_zeitpunkt;
    }

    public String getMedikamente() {
        return medikamente;
    }

    public void setMedikamente(String medikamente) {
        this.medikamente = medikamente;
    }

    public String getBestrahlung() {
        return bestrahlung;
    }

    public void setBestrahlung(String bestrahlung) {
        this.bestrahlung = bestrahlung;
    }

    public Boolean getMed_anithormon() {
        return med_anithormon;
    }

    public void setMed_antihormon(Boolean med_anithormon) {
        this.med_anithormon = med_anithormon;
    }

    public Boolean getMed_antihormon_unbekannt() {
        return med_antihormon_unbekannt;
    }

    public void setMed_antihormon_unbekannt(Boolean med_antihormon_unbekannt) {
        this.med_antihormon_unbekannt = med_antihormon_unbekannt;
    }

    public Boolean getMed_antihormon_tamoxifen() {
        return med_antihormon_tamoxifen;
    }

    public void setMed_antihormon_tamoxifen(Boolean med_antihormon_tamoxifen) {
        this.med_antihormon_tamoxifen = med_antihormon_tamoxifen;
    }

    public Boolean getMed_antihormon_arimidex() {
        return med_antihormon_arimidex;
    }

    public void setMed_antihormon_arimidex(Boolean med_antihormon_arimidex) {
        this.med_antihormon_arimidex = med_antihormon_arimidex;
    }

    public Boolean getMed_antihormon_aromasin() {
        return med_antihormon_aromasin;
    }

    public void setMed_antihormon_aromasin(Boolean med_antihormon_aromasin) {
        this.med_antihormon_aromasin = med_antihormon_aromasin;
    }

    public Boolean getMed_antihormon_fe03a() {
        return med_antihormon_fe03a;
    }

    public void setMed_antihormon_fe03a(Boolean med_antihormon_fe03a) {
        this.med_antihormon_fe03a = med_antihormon_fe03a;
    }

    public String getHerceptin() {
        return herceptin;
    }

    public void setHerceptin(String herceptin) {
        this.herceptin = herceptin;
    }

    public String getBiophosphonaten() {
        return biophosphonaten;
    }

    public void setBiophosphonaten(String biophosphonaten) {
        this.biophosphonaten = biophosphonaten;
    }

    public String getBiophosphaten_text() {
        return biophosphaten_text;
    }

    public void setBiophosphaten_text(String biophosphaten_text) {
        this.biophosphaten_text = biophosphaten_text;
    }

    public String getWeitere_erkrankung() {
        return weitere_erkrankung;
    }

    public void setWeitere_erkrankung(String weitere_erkrankung) {
        this.weitere_erkrankung = weitere_erkrankung;
    }

    public Boolean getRezidiv() {
        return rezidiv;
    }

    public void setRezidiv(Boolean rezidiv) {
        this.rezidiv = rezidiv;
    }

    public Boolean getMetastasen() {
        return metastasen;
    }

    public void setMetastasen(Boolean metastasen) {
        this.metastasen = metastasen;
    }

    public Boolean getMetastasen_abrust() {
        return metastasen_abrust;
    }

    public void setMetastasen_abrust(Boolean metastasen_abrust) {
        this.metastasen_abrust = metastasen_abrust;
    }

    public Boolean getMetastasen_lymphknoten() {
        return metastasen_lymphknoten;
    }

    public void setMetastasen_lymphknoten(Boolean metastasen_lymphknoten) {
        this.metastasen_lymphknoten = metastasen_lymphknoten;
    }

    public Boolean getMetastasen_knochen() {
        return metastasen_knochen;
    }

    public void setMetastasen_knochen(Boolean metastasen_knochen) {
        this.metastasen_knochen = metastasen_knochen;
    }

    public Boolean getMetastasen_lunge() {
        return metastasen_lunge;
    }

    public void setMetastasen_lunge(Boolean metastasen_lunge) {
        this.metastasen_lunge = metastasen_lunge;
    }

    public Boolean getMetastasen_gehirn() {
        return metastasen_gehirn;
    }

    public void setMetastasen_gehirn(Boolean metastasen_gehirn) {
        this.metastasen_gehirn = metastasen_gehirn;
    }

    public Boolean getMetastasen_leber() {
        return metastasen_leber;
    }

    public void setMetastasen_leber(Boolean metastasen_leber) {
        this.metastasen_leber = metastasen_leber;
    }

    public Boolean getMetastasen_andere() {
        return metastasen_andere;
    }

    public void setMetastasen_andere(Boolean metastasen_andere) {
        this.metastasen_andere = metastasen_andere;
    }

    public String getMetastasen_andere_text() {
        return metastasen_andere_text;
    }

    public void setMetastasen_andere_text(String metastasen_andere_text) {
        this.metastasen_andere_text = metastasen_andere_text;
    }

    public LocalDate getRezidiv_zeitpunkt() {
        return rezidiv_zeitpunkt;
    }

    public void setRezidiv_zeitpunkt(LocalDate rezidiv_zeitpunkt) {
        this.rezidiv_zeitpunkt = rezidiv_zeitpunkt;
    }

    public String getHausarzt() {
        return hausarzt;
    }

    public void setHausarzt(String hausarzt) {
        this.hausarzt = hausarzt;
    }

    public String getFrauenarzt() {
        return frauenarzt;
    }

    public void setFrauenarzt(String frauenarzt) {
        this.frauenarzt = frauenarzt;
    }

    public String getAnmerkungen() {
        return anmerkungen;
    }

    public void setAnmerkungen(String anmerkungen) {
        this.anmerkungen = anmerkungen;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
