package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.Patient;
import org.springframework.stereotype.Service;

/**
 * Created by VaniR on 12.07.2017.
 */
@Service
public class PatientAttributAuswahl {

	//	@Autowired
	PatientAttributMethodenService patientAttributMethodenService = new PatientAttributMethodenService();

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

		}
		return patient;
	}


	public Patient setValueFromDbToExcelPatient(PatientModelAttribute patientAttribut, Patient patientAusDatenbank, Patient patient) {
		Object dbValue = new Object();
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
}
