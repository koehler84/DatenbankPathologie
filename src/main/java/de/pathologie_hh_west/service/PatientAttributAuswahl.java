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


	public Patient setValueFromDbToExcelPatient(PatientModelAttribute patientAttribut, Patient patientAusDatenbank, Patient patient) {
		Object dbValue;
		switch (patientAttribut.getWrappingClass().getSimpleName().toUpperCase()) {
			case "PATIENT":
				dbValue = patientAttributMethodenService.methodGetterPatient(patientAttribut, patientAusDatenbank);
				patientAttributMethodenService.methodSetterPatient(patientAttribut, dbValue, patient);
				break;
			case "ADRESSE":
				dbValue = patientAttributMethodenService.methodGetterAdresse(patientAttribut, patientAusDatenbank);
				patientAttributMethodenService.methodSetterAdresse(patientAttribut, dbValue, patient);
				break;
			case "EE2011":
				dbValue = patientAttributMethodenService.methodGetterEE2011(patientAttribut, patientAusDatenbank);
				patientAttributMethodenService.methodSetterEE2011(patientAttribut, dbValue, patient);
				break;
			case "EE2015":
				dbValue = patientAttributMethodenService.methodGetterEE2015(patientAttribut, patientAusDatenbank);
				patientAttributMethodenService.methodSetterEE2015(patientAttribut, dbValue, patient);
				break;
			case "EXPRIMAGE":
				dbValue = patientAttributMethodenService.methodGetterExprimage(patientAttribut, patientAusDatenbank);
				patientAttributMethodenService.methodSetterExprimage(patientAttribut, dbValue, patient);
				break;

		}
		return patient;

	}

    public boolean isDbValueNull(PatientModelAttribute patientAttribut, Patient patientAusDatenbank) {
        switch (patientAttribut.getWrappingClass().getSimpleName().toUpperCase()) {
            case "PATIENT":
                if (patientAttributMethodenService.methodGetterPatient(patientAttribut, patientAusDatenbank) == null) {
                    return true;
                }
                break;
            case "ADRESSE":
                if (patientAttributMethodenService.methodGetterAdresse(patientAttribut, patientAusDatenbank) == null) {
                    return true;
                }
                break;
            case "EE2011":
                if (patientAttributMethodenService.methodGetterEE2011(patientAttribut, patientAusDatenbank) == null) {
                    return true;
                }
                break;
            case "EE2015":
                if (patientAttributMethodenService.methodGetterEE2015(patientAttribut, patientAusDatenbank) == null) {
                    return true;
                }
                break;
            case "EXPRIMAGE":
                if (patientAttributMethodenService.methodGetterExprimage(patientAttribut, patientAusDatenbank) == null) {
                    return true;
                }
                break;

        }
        return false;
    }
}
