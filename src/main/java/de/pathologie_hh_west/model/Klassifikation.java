package de.pathologie_hh_west.model;

import javax.persistence.Embedded;

/**
 * Created by VaniR on 10.07.2017.
 */
public class Klassifikation {
    private Integer g;
    private Integer t;
    private Integer n;
    private Integer m;
    private Integer l;
    private Integer v;
    private Integer r;
    private Integer nGesamt;
    private Integer nMeta;
    private Integer er;
    private Integer erIrs;
    private Integer pr;
    private Integer prIrs;
    private Integer her2neu;
    private Integer her2neuScore;
    private Integer ki67;
    @Embedded
    private TumorArt tumorArt;

    public Klassifikation() {
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Integer getM() {
        return m;
    }

    public void setM(Integer m) {
        this.m = m;
    }

    public Integer getL() {
        return l;
    }

    public void setL(Integer l) {
        this.l = l;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getnGesamt() {
        return nGesamt;
    }

    public void setnGesamt(Integer nGesamt) {
        this.nGesamt = nGesamt;
    }

    public Integer getnMeta() {
        return nMeta;
    }

    public void setnMeta(Integer nMeta) {
        this.nMeta = nMeta;
    }

    public Integer getEr() {
        return er;
    }

    public void setEr(Integer er) {
        this.er = er;
    }

    public Integer getErIrs() {
        return erIrs;
    }

    public void setErIrs(Integer erIrs) {
        this.erIrs = erIrs;
    }

    public Integer getPr() {
        return pr;
    }

    public void setPr(Integer pr) {
        this.pr = pr;
    }

    public Integer getPrIrs() {
        return prIrs;
    }

    public void setPrIrs(Integer prIrs) {
        this.prIrs = prIrs;
    }

    public Integer getHer2neu() {
        return her2neu;
    }

    public void setHer2neu(Integer her2neu) {
        this.her2neu = her2neu;
    }

    public Integer getHer2neuScore() {
        return her2neuScore;
    }

    public void setHer2neuScore(Integer her2neuScore) {
        this.her2neuScore = her2neuScore;
    }

    public Integer getKi67() {
        return ki67;
    }

    public void setKi67(Integer ki67) {
        this.ki67 = ki67;
    }

    public TumorArt getTumorArt() {
        return tumorArt;
    }

    public void setTumorArt(TumorArt tumorArt) {
        this.tumorArt = tumorArt;
    }
}
