package de.pathologie_hh_west.service;

import de.pathologie_hh_west.service.PatientModelAttribute;

/**
 * Created by VaniR on 17.07.2017.
 * Project: path_db
 */
public class IndexMapper {
	
	private Integer excelIndex;
	private PatientModelAttribute patientAttribut;
	private Boolean overwriteExcelValue;
	
	public IndexMapper(Integer excelIndex, PatientModelAttribute patientAttribut, Boolean overwriteExcelValue) {
		this.excelIndex = excelIndex;
		this.patientAttribut = patientAttribut;
		this.overwriteExcelValue = overwriteExcelValue;
	}
	
	public void setIndexMapper(Integer excelIndex, PatientModelAttribute patientAttribut, Boolean overwriteExcelValue) {
		this.excelIndex = excelIndex;
		this.patientAttribut = patientAttribut;
		this.overwriteExcelValue = overwriteExcelValue;
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
	
	public Boolean getOverwriteExcelValue() {
		return overwriteExcelValue;
	}
	
	public void setOverwriteExcelValue(Boolean overwriteExcelValue) {
		this.overwriteExcelValue = overwriteExcelValue;
	}
}
