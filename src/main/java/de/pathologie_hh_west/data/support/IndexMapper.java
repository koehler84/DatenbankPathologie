package de.pathologie_hh_west.data.support;

import de.pathologie_hh_west.service.PatientModelAttribute;

/**
 * Created by VaniR on 17.07.2017.
 * Project: path_db
 */
public class IndexMapper {
    private Integer excelIndex;
    private PatientModelAttribute patientAttribut;
    private Boolean overwriteDbValue;

    public IndexMapper(Integer excelIndex, PatientModelAttribute patientAttribut, Boolean overwriteDbValue) {
        this.excelIndex = excelIndex;
        this.patientAttribut = patientAttribut;
        this.overwriteDbValue = overwriteDbValue;
    }

    public void setIndexMapper(Integer excelIndex, PatientModelAttribute patientAttribut, Boolean overwriteDbValue) {
        this.excelIndex = excelIndex;
        this.patientAttribut = patientAttribut;
        this.overwriteDbValue = overwriteDbValue;
    }

    public Integer getExcelIndex() {
        return excelIndex;
    }

    public void setExcelIndex(Integer excelIndex) {
        this.excelIndex = excelIndex;
    }

    public PatientModelAttribute getPatientAttribut() {
        return patientAttribut;
    }

    public void setPatientAttribut(PatientModelAttribute patientAttribut) {
        this.patientAttribut = patientAttribut;
    }

    public Boolean getOverwriteDbValue() {
        return overwriteDbValue;
    }

    public void setOverwriteDbValue(Boolean overwriteDbValue) {
        this.overwriteDbValue = overwriteDbValue;
    }
}
