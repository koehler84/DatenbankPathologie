package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by VaniR on 11.07.2017.
 */
@Embeddable
public class EE2015 {

    private String ee2015Pseudonym2;
    private String ee2015Status;
    private LocalDate ee2015Datum;
    private String ee2015TodQuelle;
    private LocalDate ee2015TodDatum;
    private String ee2015Notizen;
    private String ee2015Welle;
    private String ee2015Rawid;
    private String ee2015Source;
    private String ee2015Zeit;
    private String ee2015Chemo;
    private String ee2015Chemo_zeitpunkt;
    private String ee2015Medikamente;
    private String ee2015Bestrahlung;
    private Integer ee2015Med_antihormon;
    private Integer ee2015Med_antihormon_unbekannt;
    private Integer ee2015Med_antihormon_tamoxifen;
    private Integer ee2015Med_antihormon_arimidex;
    private Integer ee2015Med_antihormon_aromasin;
    private Integer ee2015Med_antihormon_fe03a;
    private String ee2015Herceptin;
    private String ee2015Biophosphaten;
    private String ee2015Biophosphaten_text;
    private String ee2015Weitere_erkrankung;
    private Integer ee2015Rezidiv;
    private Integer ee2015Metastasen;
    private Integer ee2015Metastasen_abrust;
    private Integer ee2015Metastasen_lymphknoten;
    private Integer ee2015Metastasen_knochen;
    private Integer ee2015Metastasen_lunge;
    private Integer ee2015Metastasen_gehirn;
    private Integer ee2015Metastasen_leber;
    private Integer ee2015Metastasen_andere;
    private String ee2015Metastasen_andere_text;
    private LocalDate ee2015Rezidiv_zeitpunkt;
    private String ee2015Hausarzt;
    private String ee2015Frauenarzt;
    private String ee2015Anmerkungen;
    private String ee2015Information;


    public String getEe2015Pseudonym2() {
        return ee2015Pseudonym2;
    }

    public void setEe2015Pseudonym2(String ee2015Pseudonym2) {
        this.ee2015Pseudonym2 = ee2015Pseudonym2;
    }

    public String getEe2015Status() {
        return ee2015Status;
    }

    public void setEe2015Status(String ee2015Status) {
        this.ee2015Status = ee2015Status;
    }

    public LocalDate getEe2015Datum() {
        return ee2015Datum;
    }

    public void setEe2015Datum(LocalDate ee2015Datum) {
        this.ee2015Datum = ee2015Datum;
    }

    public String getEe2015TodQuelle() {
        return ee2015TodQuelle;
    }

    public void setEe2015TodQuelle(String ee2015TodQuelle) {
        this.ee2015TodQuelle = ee2015TodQuelle;
    }

    public LocalDate getEe2015TodDatum() {
        return ee2015TodDatum;
    }

    public void setEe2015TodDatum(LocalDate ee2015TodDatum) {
        this.ee2015TodDatum = ee2015TodDatum;
    }

    public String getEe2015Notizen() {
        return ee2015Notizen;
    }

    public void setEe2015Notizen(String ee2015Notizen) {
        this.ee2015Notizen = ee2015Notizen;
    }

    public String getEe2015Welle() {
        return ee2015Welle;
    }

    public void setEe2015Welle(String ee2015Welle) {
        this.ee2015Welle = ee2015Welle;
    }

    public String getEe2015Rawid() {
        return ee2015Rawid;
    }

    public void setEe2015Rawid(String ee2015Rawid) {
        this.ee2015Rawid = ee2015Rawid;
    }

    public String getEe2015Source() {
        return ee2015Source;
    }

    public void setEe2015Source(String ee2015Source) {
        this.ee2015Source = ee2015Source;
    }

    public String getEe2015Zeit() {
        return ee2015Zeit;
    }

    public void setEe2015Zeit(String ee2015Zeit) {
        this.ee2015Zeit = ee2015Zeit;
    }

    public String getEe2015Chemo() {
        return ee2015Chemo;
    }

    public void setEe2015Chemo(String ee2015Chemo) {
        this.ee2015Chemo = ee2015Chemo;
    }

    public String getEe2015Chemo_zeitpunkt() {
        return ee2015Chemo_zeitpunkt;
    }

    public void setEe2015Chemo_zeitpunkt(String ee2015Chemo_zeitpunkt) {
        this.ee2015Chemo_zeitpunkt = ee2015Chemo_zeitpunkt;
    }

    public String getEe2015Medikamente() {
        return ee2015Medikamente;
    }

    public void setEe2015Medikamente(String ee2015Medikamente) {
        this.ee2015Medikamente = ee2015Medikamente;
    }

    public String getEe2015Bestrahlung() {
        return ee2015Bestrahlung;
    }

    public void setEe2015Bestrahlung(String ee2015Bestrahlung) {
        this.ee2015Bestrahlung = ee2015Bestrahlung;
    }

    public Integer getEe2015Med_antihormon() {
        return ee2015Med_antihormon;
    }

    public void setEe2015Med_antihormon(BigDecimal ee2015Med_antihormon) {
        this.ee2015Med_antihormon = ee2015Med_antihormon.intValue();
    }

    public void setEe2015Med_antihormon(Integer ee2015Med_antihormon) {
        this.ee2015Med_antihormon = ee2015Med_antihormon;
    }

    public Integer getEe2015Med_antihormon_unbekannt() {
        return ee2015Med_antihormon_unbekannt;
    }

    public void setEe2015Med_antihormon_unbekannt(BigDecimal ee2015Med_antihormon_unbekannt) {
        this.ee2015Med_antihormon_unbekannt = ee2015Med_antihormon_unbekannt.intValue();
    }

    public void setEe2015Med_antihormon_unbekannt(Integer ee2015Med_antihormon_unbekannt) {
        this.ee2015Med_antihormon_unbekannt = ee2015Med_antihormon_unbekannt;
    }

    public Integer getEe2015Med_antihormon_tamoxifen() {
        return ee2015Med_antihormon_tamoxifen;
    }

    public void setEe2015Med_antihormon_tamoxifen(BigDecimal ee2015Med_antihormon_tamoxifen) {
        this.ee2015Med_antihormon_tamoxifen = ee2015Med_antihormon_tamoxifen.intValue();
    }

    public void setEe2015Med_antihormon_tamoxifen(Integer ee2015Med_antihormon_tamoxifen) {
        this.ee2015Med_antihormon_tamoxifen = ee2015Med_antihormon_tamoxifen;
    }

    public Integer getEe2015Med_antihormon_arimidex() {
        return ee2015Med_antihormon_arimidex;
    }

    public void setEe2015Med_antihormon_arimidex(BigDecimal ee2015Med_antihormon_arimidex) {
        this.ee2015Med_antihormon_arimidex = ee2015Med_antihormon_arimidex.intValue();
    }

    public void setEe2015Med_antihormon_arimidex(Integer ee2015Med_antihormon_arimidex) {
        this.ee2015Med_antihormon_arimidex = ee2015Med_antihormon_arimidex;
    }

    public Integer getEe2015Med_antihormon_aromasin() {
        return ee2015Med_antihormon_aromasin;
    }

    public void setEe2015Med_antihormon_aromasin(BigDecimal ee2015Med_antihormon_aromasin) {
        this.ee2015Med_antihormon_aromasin = ee2015Med_antihormon_aromasin.intValue();
    }

    public void setEe2015Med_antihormon_aromasin(Integer ee2015Med_antihormon_aromasin) {
        this.ee2015Med_antihormon_aromasin = ee2015Med_antihormon_aromasin;
    }

    public Integer getEe2015Med_antihormon_fe03a() {
        return ee2015Med_antihormon_fe03a;
    }

    public void setEe2015Med_antihormon_fe03a(BigDecimal ee2015Med_antihormon_fe03a) {
        this.ee2015Med_antihormon_fe03a = ee2015Med_antihormon_fe03a.intValue();
    }

    public void setEe2015Med_antihormon_fe03a(Integer ee2015Med_antihormon_fe03a) {
        this.ee2015Med_antihormon_fe03a = ee2015Med_antihormon_fe03a;
    }

    public String getEe2015Herceptin() {
        return ee2015Herceptin;
    }

    public void setEe2015Herceptin(String ee2015Herceptin) {
        this.ee2015Herceptin = ee2015Herceptin;
    }

    public String getEe2015Biophosphaten() {
        return ee2015Biophosphaten;
    }

    public void setEe2015Biophosphaten(String ee2015Biophosphaten) {
        this.ee2015Biophosphaten = ee2015Biophosphaten;
    }

    public String getEe2015Biophosphaten_text() {
        return ee2015Biophosphaten_text;
    }

    public void setEe2015Biophosphaten_text(String ee2015Biophosphaten_text) {
        this.ee2015Biophosphaten_text = ee2015Biophosphaten_text;
    }

    public String getEe2015Weitere_erkrankung() {
        return ee2015Weitere_erkrankung;
    }

    public void setEe2015Weitere_erkrankung(String ee2015Weitere_erkrankung) {
        this.ee2015Weitere_erkrankung = ee2015Weitere_erkrankung;
    }

    public Integer getEe2015Rezidiv() {
        return ee2015Rezidiv;
    }

    public void setEe2015Rezidiv(BigDecimal ee2015Rezidiv) {
        this.ee2015Rezidiv = ee2015Rezidiv.intValue();
    }

    public void setEe2015Rezidiv(Integer ee2015Rezidiv) {
        this.ee2015Rezidiv = ee2015Rezidiv;
    }

    public Integer getEe2015Metastasen() {
        return ee2015Metastasen;
    }

    public void setEe2015Metastasen(BigDecimal ee2015Metastasen) {
        this.ee2015Metastasen = ee2015Metastasen.intValue();
    }

    public void setEe2015Metastasen(Integer ee2015Metastasen) {
        this.ee2015Metastasen = ee2015Metastasen;
    }

    public Integer getEe2015Metastasen_abrust() {
        return ee2015Metastasen_abrust;
    }

    public void setEe2015Metastasen_abrust(BigDecimal ee2015Metastasen_abrust) {
        this.ee2015Metastasen_abrust = ee2015Metastasen_abrust.intValue();
    }

    public void setEe2015Metastasen_abrust(Integer ee2015Metastasen_abrust) {
        this.ee2015Metastasen_abrust = ee2015Metastasen_abrust;
    }

    public Integer getEe2015Metastasen_lymphknoten() {
        return ee2015Metastasen_lymphknoten;
    }

    public void setEe2015Metastasen_lymphknoten(BigDecimal ee2015Metastasen_lymphknoten) {
        this.ee2015Metastasen_lymphknoten = ee2015Metastasen_lymphknoten.intValue();
    }

    public void setEe2015Metastasen_lymphknoten(Integer ee2015Metastasen_lymphknoten) {
        this.ee2015Metastasen_lymphknoten = ee2015Metastasen_lymphknoten;
    }

    public Integer getEe2015Metastasen_knochen() {
        return ee2015Metastasen_knochen;
    }

    public void setEe2015Metastasen_knochen(BigDecimal ee2015Metastasen_knochen) {
        this.ee2015Metastasen_knochen = ee2015Metastasen_knochen.intValue();
    }

    public void setEe2015Metastasen_knochen(Integer ee2015Metastasen_knochen) {
        this.ee2015Metastasen_knochen = ee2015Metastasen_knochen;
    }

    public Integer getEe2015Metastasen_lunge() {
        return ee2015Metastasen_lunge;
    }

    public void setEe2015Metastasen_lunge(BigDecimal ee2015Metastasen_lunge) {
        this.ee2015Metastasen_lunge = ee2015Metastasen_lunge.intValue();
    }

    public void setEe2015Metastasen_lunge(Integer ee2015Metastasen_lunge) {
        this.ee2015Metastasen_lunge = ee2015Metastasen_lunge;
    }

    public Integer getEe2015Metastasen_gehirn() {
        return ee2015Metastasen_gehirn;
    }

    public void setEe2015Metastasen_gehirn(BigDecimal ee2015Metastasen_gehirn) {
        this.ee2015Metastasen_gehirn = ee2015Metastasen_gehirn.intValue();
    }

    public void setEe2015Metastasen_gehirn(Integer ee2015Metastasen_gehirn) {
        this.ee2015Metastasen_gehirn = ee2015Metastasen_gehirn;
    }

    public Integer getEe2015Metastasen_leber() {
        return ee2015Metastasen_leber;
    }

    public void setEe2015Metastasen_leber(BigDecimal ee2015Metastasen_leber) {
        this.ee2015Metastasen_leber = ee2015Metastasen_leber.intValue();
    }

    public void setEe2015Metastasen_leber(Integer ee2015Metastasen_leber) {
        this.ee2015Metastasen_leber = ee2015Metastasen_leber;
    }

    public Integer getEe2015Metastasen_andere() {
        return ee2015Metastasen_andere;
    }

    public void setEe2015Metastasen_andere(BigDecimal ee2015Metastasen_andere) {
        this.ee2015Metastasen_andere = ee2015Metastasen_andere.intValue();
    }

    public void setEe2015Metastasen_andere(Integer ee2015Metastasen_andere) {
        this.ee2015Metastasen_andere = ee2015Metastasen_andere;
    }

    public String getEe2015Metastasen_andere_text() {
        return ee2015Metastasen_andere_text;
    }

    public void setEe2015Metastasen_andere_text(String ee2015Metastasen_andere_text) {
        this.ee2015Metastasen_andere_text = ee2015Metastasen_andere_text;
    }

    public LocalDate getEe2015Rezidiv_zeitpunkt() {
        return ee2015Rezidiv_zeitpunkt;
    }

    public void setEe2015Rezidiv_zeitpunkt(LocalDate ee2015Rezidiv_zeitpunkt) {
        this.ee2015Rezidiv_zeitpunkt = ee2015Rezidiv_zeitpunkt;
    }

    public String getEe2015Hausarzt() {
        return ee2015Hausarzt;
    }

    public void setEe2015Hausarzt(String ee2015Hausarzt) {
        this.ee2015Hausarzt = ee2015Hausarzt;
    }

    public String getEe2015Frauenarzt() {
        return ee2015Frauenarzt;
    }

    public void setEe2015Frauenarzt(String ee2015Frauenarzt) {
        this.ee2015Frauenarzt = ee2015Frauenarzt;
    }

    public String getEe2015Anmerkungen() {
        return ee2015Anmerkungen;
    }

    public void setEe2015Anmerkungen(String ee2015Anmerkungen) {
        this.ee2015Anmerkungen = ee2015Anmerkungen;
    }

    public String getEe2015Information() {
        return ee2015Information;
    }

    public void setEe2015Information(String ee2015Information) {
        this.ee2015Information = ee2015Information;
    }


}
