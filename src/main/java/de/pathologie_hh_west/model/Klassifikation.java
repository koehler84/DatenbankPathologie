package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

/**
 * Created by VaniR on 10.07.2017.
 */
@Embeddable
public class Klassifikation implements Serializable {
    private String g;
    private String t;
    private String n;
    private String m;
    private String l;
    private String v;
    private String r;
    private String nGesamt;
    private String nMeta;
    private String er;
    private String erIrs;
    private String pr;
    private String prIrs;
    private String her2neu;
    private String her2neuScore;
    private String ki67;
    @Embedded
    private TumorArt tumorArt;

    private String van_Nuys;
    private String who;
    private String who_Grad_DCIS;
    private String ki67_Prozent;
    private String degree_Of_Tubule_Formation;
    private String nuclear_Pleomorphism;
    private String mitosis;
    private String ausschluss;

    public Klassifikation() {
        this.tumorArt = new TumorArt();
    }

    public String getWho_Grad_DCIS() {
        return who_Grad_DCIS;
    }

    public void setWho_Grad_DCIS(String who_Grad_DCIS) {
        this.who_Grad_DCIS = who_Grad_DCIS;
    }

    public String getVan_Nuys() {
        return van_Nuys;
    }

    public void setVan_Nuys(String van_Nuys) {
        this.van_Nuys = van_Nuys;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getKi67_Prozent() {
        return ki67_Prozent;
    }

    public void setKi67_Prozent(String ki67_Prozent) {
        this.ki67_Prozent = ki67_Prozent;
    }

    public String getDegree_Of_Tubule_Formation() {
        return degree_Of_Tubule_Formation;
    }

    public void setDegree_Of_Tubule_Formation(String degree_Of_Tubule_Formation) {
        this.degree_Of_Tubule_Formation = degree_Of_Tubule_Formation;
    }

    public String getNuclear_Pleomorphism() {
        return nuclear_Pleomorphism;
    }

    public void setNuclear_Pleomorphism(String nuclear_Pleomorphism) {
        this.nuclear_Pleomorphism = nuclear_Pleomorphism;
    }

    public String getMitosis() {
        return mitosis;
    }

    public void setMitosis(String mitosis) {
        this.mitosis = mitosis;
    }

    public String getAusschluss() {
        return ausschluss;
    }

    public void setAusschluss(String ausschluss) {
        this.ausschluss = ausschluss;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getnGesamt() {
        return nGesamt;
    }

    public void setnGesamt(String nGesamt) {
        this.nGesamt = nGesamt;
    }

    public String getnMeta() {
        return nMeta;
    }

    public void setnMeta(String nMeta) {
        this.nMeta = nMeta;
    }

    public String getEr() {
        return er;
    }

    public void setEr(String er) {
        this.er = er;
    }

    public String getErIrs() {
        return erIrs;
    }

    public void setErIrs(String erIrs) {
        this.erIrs = erIrs;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getPrIrs() {
        return prIrs;
    }

    public void setPrIrs(String prIrs) {
        this.prIrs = prIrs;
    }

    public String getHer2neu() {
        return her2neu;
    }

    public void setHer2neu(String her2neu) {
        this.her2neu = her2neu;
    }

    public String getHer2neuScore() {
        return her2neuScore;
    }

    public void setHer2neuScore(String her2neuScore) {
        this.her2neuScore = her2neuScore;
    }

    public String getKi67() {
        return ki67;
    }

    public void setKi67(String ki67) {
        this.ki67 = ki67;
    }

    public TumorArt getTumorArt() {
        return tumorArt;
    }

    public void setTumorArt(TumorArt tumorArt) {
        this.tumorArt = tumorArt;
    }
}
