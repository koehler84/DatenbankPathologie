package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.Patient;

interface DataModifier {

//	Patient modify(Patient patient);
	fun modify(patient: Patient): Patient
}
