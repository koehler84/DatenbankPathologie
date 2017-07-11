package de.pathologie_hh_west.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

/**
 * Created by VaniR on 11.07.2017.
 */
@Embeddable
public class Exprimage {
    @Column(name = "EXPnotizen")
    private String notizen;
    @Column(name = "EXPchemo")
    private String chemo;
    @Column(name = "EXPtamoxifen")
    private String tamoxifen;
    @Column(name = "EXParomataseHemmer")
    private String aromataseHemmer;
    @Column(name = "EXPradatio")
    private String radatio;
    @Column(name = "EXPtumorprogress1")
    private LocalDate tumorprogress1;
    @Column(name = "EXPtumorprogress2")
    private LocalDate tumorprogress2;
    @Column(name = "EXPstatus")
    private String status;
    @Column(name = "EXPdatum")
    private LocalDate datum;
    @Column(name = "EXPfollowUp")
    private LocalDate followUp;
    @Column(name = "EXPtodQuelle")
    private String todQuelle;
    @Column(name = "EXPtodDatum")
    private LocalDate todDatum;
    @Column(name = "EXPbemerkung")
    private String bemerkung;
    @Column(name = "EXParzt")
    private String arzt;

    public Exprimage() {
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

    public String getTamoxifen() {
        return tamoxifen;
    }

    public void setTamoxifen(String tamoxifen) {
        this.tamoxifen = tamoxifen;
    }

    public String getAromataseHemmer() {
        return aromataseHemmer;
    }

    public void setAromataseHemmer(String aromataseHemmer) {
        this.aromataseHemmer = aromataseHemmer;
    }

    public String getRadatio() {
        return radatio;
    }

    public void setRadatio(String radatio) {
        this.radatio = radatio;
    }

    public LocalDate getTumorprogress1() {
        return tumorprogress1;
    }

    public void setTumorprogress1(LocalDate tumorprogress1) {
        this.tumorprogress1 = tumorprogress1;
    }

    public LocalDate getTumorprogress2() {
        return tumorprogress2;
    }

    public void setTumorprogress2(LocalDate tumorprogress2) {
        this.tumorprogress2 = tumorprogress2;
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

    public LocalDate getFollowUp() {
        return followUp;
    }

    public void setFollowUp(LocalDate followUp) {
        this.followUp = followUp;
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

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public String getArzt() {
        return arzt;
    }

    public void setArzt(String arzt) {
        this.arzt = arzt;
    }
}
