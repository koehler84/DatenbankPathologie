package de.pathologie_hh_west.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

/**
 * Created by VaniR on 11.07.2017.
 */
@Embeddable
public class EE2011 {
    @Column(name = "EE2011status")
    private String status;
    @Column(name = "EE2011datum")
    private LocalDate datum;
    @Column(name = "EE2011rezidiv_Metastase")
    private Integer rezidiv_Metastase;
    @Column(name = "EE2011r")
    private Integer r;
    @Column(name = "EE2011rDatum")
    private LocalDate rDatum;
    @Column(name = "EE2011rDatum2")
    private LocalDate rDatum2;
    @Column(name = "EE2011notizen")
    private String notizen;
    @Column(name = "EE2011chemo")
    private String chemo;
    @Column(name = "EE2011radiatio")
    private String radiatio;
    @Column(name = "EE2011aH")
    private String aH;
    @Column(name = "EE2011hausarzt")
    private String hausarzt;
    @Column(name = "EE2011frauenarzt")
    private String frauenarzt;

    public EE2011() {
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

    public Integer getRezidiv_Metastase() {
        return rezidiv_Metastase;
    }

    public void setRezidiv_Metastase(Integer rezidiv_Metastase) {
        this.rezidiv_Metastase = rezidiv_Metastase;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public LocalDate getrDatum() {
        return rDatum;
    }

    public void setrDatum(LocalDate rDatum) {
        this.rDatum = rDatum;
    }

    public LocalDate getrDatum2() {
        return rDatum2;
    }

    public void setrDatum2(LocalDate rDatum2) {
        this.rDatum2 = rDatum2;
    }

    public String getNotizen() {
        return notizen;
    }

    public void setNotizen(String notizen) {
        this.notizen = notizen;
    }

    public String getChemo() {
        return chemo;
    }

    public void setChemo(String chemo) {
        this.chemo = chemo;
    }

    public String getRadiatio() {
        return radiatio;
    }

    public void setRadiatio(String radiatio) {
        this.radiatio = radiatio;
    }

    public String getaH() {
        return aH;
    }

    public void setaH(String aH) {
        this.aH = aH;
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
}
