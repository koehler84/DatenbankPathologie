package de.pathologie_hh_west;

import de.pathologie_hh_west.model.*;
import de.pathologie_hh_west.service.PatientModelAttribute;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

public class PathDbApplicationTests {
	private Patient patient = new Patient();

	@Before
	public void executedBeforeEach() {
		LocalDate date = LocalDate.of(2017, 7, 16);
		Fall fall = new Fall();
		Fall fall1 = new Fall();

		FallID e4321 = new FallID(new ENummer("001/00146"));
		e4321.setBefundTyp(BefundTyp.KORREKTURBEFUND4);
		fall1.setFallID(e4321);
		FallID e1234 = new FallID(new ENummer("A/1996/200591"));
		e1234.setBefundTyp(BefundTyp.HAUPTBEFUND);
		fall.setFallID(e1234);
		patient.getAdresse().setHausnummer("12");
		patient.getAdresse().setLand("Deutschland");
		patient.getAdresse().setOrt("Hamburg");
		patient.getAdresse().setPlz("12345");
		patient.setVorname("Klaus");
		patient.setNachname("Kleber");
		patient.setGeburtsDatum(date);
		HashSet<Fall> objects = new HashSet<>(Arrays.asList(fall, fall1));
		objects.forEach(patient.getFaelle()::add);
	}

	private Fall getFallByID(ENummer eNummer, BefundTyp befundTyp, Integer index) {
		for (Fall fall : patient.getFaelle()) {
			if (fall.getFallID().geteNummer().getValue().equals(eNummer.getValue()) && fall.getFallID().getBefundTyp().equals(befundTyp)) {
				return fall;
			}
		}

		return null;
	}

	private String getTest(BefundTyp befundTyp) {
		return befundTyp.toString();
	}

	private String getTest(PatientModelAttribute patientModelAttribute) {
		return patientModelAttribute.toString();
	}

	@Test
	public void contextLoads() {
		Object test1 = BefundTyp.HAUPTBEFUND;
		Object test2 = PatientModelAttribute.EE2011R;

		System.out.println(getTest((BefundTyp) test2));




	}

}
