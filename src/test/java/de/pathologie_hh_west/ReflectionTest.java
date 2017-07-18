package de.pathologie_hh_west;

import de.pathologie_hh_west.model.Patient;
import de.pathologie_hh_west.service.PatientAttributAuswahl;
import de.pathologie_hh_west.service.PatientModelAttribute;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;

/**
 * Created by Eike on 18.07.2017.
 */
public class ReflectionTest {
	
	@Test
	public void TestReflection() {
		Patient p1 = new Patient();
		Patient p2 = new Patient();
		
		String dieter = "Dieter";
		LocalDate date = LocalDate.now();
		p1.setVorname(dieter);
		p1.setGeburtsDatum(date);
		
		PatientModelAttribute modelAttribute = PatientModelAttribute.GEBURTSDATUM;
		
		Method getterMethod = getGetterMethod(modelAttribute);
		Method setterMethod = getSetterMethod(modelAttribute);
		
		try {
			Object patientAttr = getterMethod.invoke(p1);
			Object returnedAttr = setterMethod.invoke(p2, patientAttr);
			if (patientAttr.equals(returnedAttr)) {
				fail();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void EnumReflectionTest() throws Exception {
		Patient p = new Patient();
		PatientAttributAuswahl patientAttributAuswahl = new PatientAttributAuswahl("Dieter", PatientModelAttribute.VORNAME, p);
		boolean dieter = p.getVorname().equals("Dieter");
		
		System.out.println(PatientModelAttribute.EE2011AH.getWrappingClass().getSimpleName());
	}
	
	private Method getGetterMethod(PatientModelAttribute modelAttribute) {
		return Arrays.stream(Patient.class.getMethods())
				.filter(method -> method.getName().equalsIgnoreCase("get".concat(modelAttribute.toString())))
				.findFirst()
				.get();
	}
	
	private Method getSetterMethod(PatientModelAttribute modelAttribute) {
		return Arrays.stream(Patient.class.getMethods())
				.filter(method -> method.getName().equalsIgnoreCase("set".concat(modelAttribute.toString())))
				.findFirst()
				.get();
	}

}
