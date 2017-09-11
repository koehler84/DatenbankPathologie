package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by VaniR on 11.07.2017.
 */
@Embeddable
public class EE2011 {
    private String ee2011Status;
    private LocalDate ee2011Datum;
    private Integer ee2011Rezidiv_Metastase;
    private Integer ee2011R;
    private LocalDate ee2011RDatum;
    private LocalDate ee2011RDatum2;
    private String ee2011Notizen;
    private String ee2011Chemo;
    private String ee2011Radiatio;
    private String ee2011AH;
    private String ee2011Hausarzt;
    private String ee2011Frauenarzt;

    public EE2011() {
    }

    public String getEe2011Status() {
        return ee2011Status;
    }

    public void setEe2011Status(String ee2011Status) {
        this.ee2011Status = ee2011Status;
    }

    public LocalDate getEe2011Datum() {
        return ee2011Datum;
    }

    public void setEe2011Datum(LocalDate ee2011Datum) {
        this.ee2011Datum = ee2011Datum;
    }

    public Integer getEe2011Rezidiv_Metastase() {
        return ee2011Rezidiv_Metastase;
    }

    public void setEe2011Rezidiv_Metastase(BigDecimal ee2011Rezidiv_Metastase) {
        this.ee2011Rezidiv_Metastase = ee2011Rezidiv_Metastase.intValue();
    }

    public void setEe2011Rezidiv_Metastase(Integer ee2011Rezidiv_Metastase) {
        this.ee2011Rezidiv_Metastase = ee2011Rezidiv_Metastase;
    }

    public Integer getEe2011R() {
        return ee2011R;
    }

    public void setEe2011R(BigDecimal ee2011R) {
        this.ee2011R = ee2011R.intValue();
    }

    public void setEe2011R(Integer ee2011R) {
        this.ee2011R = ee2011R;
    }

    public LocalDate getEe2011RDatum() {
        return ee2011RDatum;
    }

    public void setEe2011RDatum(LocalDate ee2011RDatum) {
        this.ee2011RDatum = ee2011RDatum;
    }

    public LocalDate getEe2011RDatum2() {
        return ee2011RDatum2;
    }

    public void setEe2011RDatum2(LocalDate ee2011RDatum2) {
        this.ee2011RDatum2 = ee2011RDatum2;
    }

    public String getEe2011Notizen() {
        return ee2011Notizen;
    }

    public void setEe2011Notizen(String ee2011Notizen) {
        this.ee2011Notizen = ee2011Notizen;
    }

    public String getEe2011Chemo() {
        return ee2011Chemo;
    }

    public void setEe2011Chemo(String ee2011Chemo) {
        this.ee2011Chemo = ee2011Chemo;
    }

    public String getEe2011Radiatio() {
        return ee2011Radiatio;
    }

    public void setEe2011Radiatio(String ee2011Radiatio) {
        this.ee2011Radiatio = ee2011Radiatio;
    }

    public String getEe2011AH() {
        return ee2011AH;
    }

    public void setEe2011AH(String ee2011AH) {
        this.ee2011AH = ee2011AH;
    }

    public String getEe2011Hausarzt() {
        return ee2011Hausarzt;
    }

    public void setEe2011Hausarzt(String ee2011Hausarzt) {
        this.ee2011Hausarzt = ee2011Hausarzt;
    }

    public String getEe2011Frauenarzt() {
        return ee2011Frauenarzt;
    }

    public void setEe2011Frauenarzt(String ee2011Frauenarzt) {
        this.ee2011Frauenarzt = ee2011Frauenarzt;
    }
}
