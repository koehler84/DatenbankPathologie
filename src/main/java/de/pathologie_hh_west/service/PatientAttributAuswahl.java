package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by VaniR on 12.07.2017.
 */
@Component
public class PatientAttributAuswahl {

	@Autowired
	private PatientAttributMethodenService patientAttributMethodenService;

	public Patient mapExcelValueToPatient(Object zellenWert, PatientModelAttribute attributName, Patient patient) {
		switch (attributName.getWrappingClass().getSimpleName().toUpperCase()) {
			case "PATIENT":
				patientAttributMethodenService.methodSetterPatient(attributName, zellenWert, patient);
				break;
			case "ADRESSE":
				patientAttributMethodenService.methodSetterAdresse(attributName, zellenWert, patient);
				break;
			case "EE2011":
				patientAttributMethodenService.methodSetterEE2011(attributName, zellenWert, patient);
				break;
			case "EE2015":
				patientAttributMethodenService.methodSetterEE2015(attributName, zellenWert, patient);
				break;
			case "EXPRIMAGE":
				patientAttributMethodenService.methodSetterExprimage(attributName, zellenWert, patient);
				break;
            case "FALL":
                patientAttributMethodenService.methodSetterFall(attributName, zellenWert, patient);
                break;
            case "FALLID":
                patientAttributMethodenService.methodSetterFallID(attributName, zellenWert, patient);
                break;
            case "KLASSIFIKATION":
                patientAttributMethodenService.methodSetterKlassifikation(attributName, zellenWert, patient);
                break;
            case "TUMORART":
                patientAttributMethodenService.methodSetterTumorart(attributName, zellenWert, patient);
                break;
        }
		return patient;
	}


	public Patient setValueFromExcelToDbPatient(PatientModelAttribute patientAttribut, Patient patientAusExcel, Patient patientAusDatenbank) {
		Object dbValue;
		switch (patientAttribut.getWrappingClass().getSimpleName().toUpperCase()) {
			case "PATIENT":
				dbValue = patientAttributMethodenService.methodGetterPatient(patientAttribut, patientAusExcel);
				patientAttributMethodenService.methodSetterPatient(patientAttribut, dbValue, patientAusDatenbank);
				break;
			case "ADRESSE":
				dbValue = patientAttributMethodenService.methodGetterAdresse(patientAttribut, patientAusExcel);
				patientAttributMethodenService.methodSetterAdresse(patientAttribut, dbValue, patientAusDatenbank);
				break;
			case "EE2011":
				dbValue = patientAttributMethodenService.methodGetterEE2011(patientAttribut, patientAusExcel);
				patientAttributMethodenService.methodSetterEE2011(patientAttribut, dbValue, patientAusDatenbank);
				break;
			case "EE2015":
				dbValue = patientAttributMethodenService.methodGetterEE2015(patientAttribut, patientAusExcel);
				patientAttributMethodenService.methodSetterEE2015(patientAttribut, dbValue, patientAusDatenbank);
				break;
			case "EXPRIMAGE":
				dbValue = patientAttributMethodenService.methodGetterExprimage(patientAttribut, patientAusExcel);
				patientAttributMethodenService.methodSetterExprimage(patientAttribut, dbValue, patientAusDatenbank);
				break;
			case "FALL":
				dbValue = patientAttributMethodenService.methodGetterFall(patientAttribut, patientAusExcel, patientAusDatenbank);
				patientAttributMethodenService.methodSetterFall(patientAttribut, dbValue, patientAusDatenbank);
				break;
			case "KLASSIFIKATION":
				dbValue = patientAttributMethodenService.methodGetterKlassifikation(patientAttribut, patientAusExcel, patientAusDatenbank);
				patientAttributMethodenService.methodSetterKlassifikationFallBekannt(patientAttribut, dbValue, patientAusDatenbank, patientAusExcel);

				break;
			case "TUMORART":
				dbValue = patientAttributMethodenService.methodGetterTumorart(patientAttribut, patientAusExcel, patientAusDatenbank);
				patientAttributMethodenService.methodSetterTumorartFallBekannt(patientAttribut, dbValue, patientAusDatenbank, patientAusExcel);

				break;
		}
		return patientAusDatenbank;

	}

    public boolean isDbValueNull(PatientModelAttribute patientAttribut, Patient patientAusDatenbank) {
        switch (patientAttribut.getWrappingClass().getSimpleName().toUpperCase()) {
            case "PATIENT":
                if (patientAttributMethodenService.methodGetterPatient(patientAttribut, patientAusDatenbank) == null) {
                    return true;
                }
                break;
            case "ADRESSE":
                if (patientAusDatenbank.getAdresse() == null ||
                        patientAttributMethodenService.methodGetterAdresse(patientAttribut, patientAusDatenbank) == null) {
                    return true;
                }
                break;
            case "EE2011":
                if (patientAusDatenbank.getPatientenZusatzdaten() == null ||
                        patientAusDatenbank.getPatientenZusatzdaten().getEe2011() == null ||
                        patientAttributMethodenService.methodGetterEE2011(patientAttribut, patientAusDatenbank) == null) {
                    return true;
                }
                break;
            case "EE2015":
                if (patientAusDatenbank.getPatientenZusatzdaten() == null ||
                        patientAusDatenbank.getPatientenZusatzdaten().getEe2015() == null ||
                        patientAttributMethodenService.methodGetterEE2015(patientAttribut, patientAusDatenbank) == null) {
                    return true;
                }
                break;
            case "EXPRIMAGE":
                if (patientAusDatenbank.getPatientenZusatzdaten() == null ||
                        patientAusDatenbank.getPatientenZusatzdaten().getExprimage() == null ||
                        patientAttributMethodenService.methodGetterExprimage(patientAttribut, patientAusDatenbank) == null) {
                    return true;
                }
                break;

        }
        return false;
    }
}
