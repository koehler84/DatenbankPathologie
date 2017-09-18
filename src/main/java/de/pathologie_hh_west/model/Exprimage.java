package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by VaniR on 11.07.2017.
 */
@Embeddable
public class Exprimage implements Serializable {
    private String expNotizen;
    private String expChemo;
    private String expTamoxifen;
    private String expAromataseHemmer;
    private String expRadatio;
    private LocalDate expTumorprogress1;
    private LocalDate expTumorprogress2;
    private String expStatus;
    private LocalDate expDatum;
    private LocalDate expFollowUp;
    private String expTodQuelle;
    private LocalDate expTodDatum;
    private String expBemerkung;
    private String expArzt;

    public Exprimage() {
    }

    public String getExpNotizen() {
        return expNotizen;
    }

    public void setExpNotizen(String expNotizen) {
        this.expNotizen = expNotizen;
    }

    public String getExpChemo() {
        return expChemo;
    }

    public void setExpChemo(String expChemo) {
        this.expChemo = expChemo;
    }

    public String getExpTamoxifen() {
        return expTamoxifen;
    }

    public void setExpTamoxifen(String expTamoxifen) {
        this.expTamoxifen = expTamoxifen;
    }

    public String getExpAromataseHemmer() {
        return expAromataseHemmer;
    }

    public void setExpAromataseHemmer(String expAromataseHemmer) {
        this.expAromataseHemmer = expAromataseHemmer;
    }

    public String getExpRadatio() {
        return expRadatio;
    }

    public void setExpRadatio(String expRadatio) {
        this.expRadatio = expRadatio;
    }

    public LocalDate getExpTumorprogress1() {
        return expTumorprogress1;
    }

    public void setExpTumorprogress1(LocalDate expTumorprogress1) {
        this.expTumorprogress1 = expTumorprogress1;
    }

    public LocalDate getExpTumorprogress2() {
        return expTumorprogress2;
    }

    public void setExpTumorprogress2(LocalDate expTumorprogress2) {
        this.expTumorprogress2 = expTumorprogress2;
    }

    public String getExpStatus() {
        return expStatus;
    }

    public void setExpStatus(String expStatus) {
        this.expStatus = expStatus;
    }

    public LocalDate getExpDatum() {
        return expDatum;
    }

    public void setExpDatum(LocalDate expDatum) {
        this.expDatum = expDatum;
    }

    public LocalDate getExpFollowUp() {
        return expFollowUp;
    }

    public void setExpFollowUp(LocalDate expFollowUp) {
        this.expFollowUp = expFollowUp;
    }

    public String getExpTodQuelle() {
        return expTodQuelle;
    }

    public void setExpTodQuelle(String expTodQuelle) {
        this.expTodQuelle = expTodQuelle;
    }

    public LocalDate getExpTodDatum() {
        return expTodDatum;
    }

    public void setExpTodDatum(LocalDate expTodDatum) {
        this.expTodDatum = expTodDatum;
    }

    public String getExpBemerkung() {
        return expBemerkung;
    }

    public void setExpBemerkung(String expBemerkung) {
        this.expBemerkung = expBemerkung;
    }

    public String getExpArzt() {
        return expArzt;
    }

    public void setExpArzt(String expArzt) {
        this.expArzt = expArzt;
    }
}
