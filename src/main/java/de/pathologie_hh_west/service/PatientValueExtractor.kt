package de.pathologie_hh_west.service

import de.pathologie_hh_west.model.*
import java.lang.reflect.Method

object PatientValueExtractor {
	
	fun extactValue(getter: Method, patient: Patient): Any {
		val declaringClass = getter.declaringClass
		val callingObject: Any
		
		when (declaringClass.simpleName) {
			Patient::class.java.simpleName -> callingObject = patient
			Adresse_::class.java.simpleName -> callingObject = patient.adresse
			PatientenZusatzdaten::class.java.simpleName -> callingObject = patient.patientenZusatzdaten
			EE2011::class.java.simpleName -> callingObject = patient.patientenZusatzdaten.ee2011
			EE2015::class.java.simpleName -> callingObject = patient.patientenZusatzdaten.ee2015
			Exprimage::class.java.simpleName -> callingObject = patient.patientenZusatzdaten.exprimage
			Fall::class.java.simpleName -> callingObject = getFallFromSetOrThrowException(getter, patient)
			FallID::class.java.simpleName -> callingObject = getFallFromSetOrThrowException(getter, patient).fallID
			ENummer::class.java.simpleName -> callingObject = getFallFromSetOrThrowException(getter, patient).fallID.geteNummer()
			BefundTyp::class.java.simpleName -> callingObject = getFallFromSetOrThrowException(getter, patient).fallID.befundTyp
			else -> throw TODO("")
		}
		return getter.invoke(callingObject)
	}
	
	private fun getFallFromSetOrThrowException(getter: Method, patient: Patient): Fall {
		if (patient.faelle.size == 1) return patient.faelle.stream().findFirst().get()
		else if (patient.faelle.isEmpty()) throw RuntimeException("${getter.name} could not be executed. Set<Fall> empty.")
		else throw RuntimeException("${getter.name} could not be executed. Set<Fall> has more than one item.")
	}
	
}