package de.pathologie_hh_west;

import de.pathologie_hh_west.model.Patient;
import de.pathologie_hh_west.service.PatientAttributAuswahl;
import de.pathologie_hh_west.service.PatientModelAttribute;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.fail;

/**
 * Created by Eike on 18.07.2017.
 */
public class ReflectionTest {

	private void test(String string) {
		System.out.println(string);
	}
	@Test
	public void TestReflection() {
		BigDecimal a = new BigDecimal(100);
		Integer b = new Integer(100);
		int c = 100;

		String testString = "test";
		Object testObject = (Object) testString;

		Object d = (Object) a;
//		test(testObject);



		Patient p1 = new Patient();
		Patient p2 = new Patient();
		
		String dieter = "Dieter";
		LocalDate date = LocalDate.now();
		p1.setVorname(dieter);
		p1.setGeburtsDatum(date);
		p1.getPatientenZusatzdaten().getExprimage().setExpArzt("test");

		PatientModelAttribute modelAttribute = PatientModelAttribute.EXPARZT;

		Method[] getterMethods = getGetterMethod(modelAttribute);
		Method setterMethod = getSetterMethodMk2(modelAttribute);

		for (Method getterMethod : getterMethods) {

			try {
				Object patientAttr = getterMethod.invoke(p1.getPatientenZusatzdaten().getExprimage());
				Object returnedAttr = setterMethod.invoke(p2, patientAttr);
				if (patientAttr.equals(returnedAttr)) {
					fail();
				}
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void EnumReflectionTest() throws Exception {

		Method testMethod = ;
		Patient p = new Patient();
		PatientAttributAuswahl patientAttributAuswahl = new PatientAttributAuswahl();
		p = patientAttributAuswahl.mapExcelValueToPatient("Dieter", PatientModelAttribute.VORNAME, p);
		boolean dieter = p.getVorname().equals("Dieter");

		System.out.println(PatientModelAttribute.VORNAME.getWrappingClass().equals(Patient.class));

		System.out.println(PatientModelAttribute.EXPARZT.getWrappingClass().getSimpleName());
	}

	private void print(String string) {
		System.out.println(string);
	}

	private Method[] getGetterMethod(PatientModelAttribute modelAttribute) {
		return Arrays.stream(modelAttribute.getWrappingClass().getMethods())
				.filter(method -> method.getName().equalsIgnoreCase("get".concat(modelAttribute.toString())))
				.toArray(size -> new Method[size]);
	}

	private Method getGetterMethodMk2(PatientModelAttribute modelAttribute) {
		return Arrays.stream(modelAttribute.getWrappingClass().getMethods())
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

	private Method getSetterMethodMk2(PatientModelAttribute modelAttribute) {
		return Arrays.stream(modelAttribute.getWrappingClass().getMethods())
				.filter(method -> method.getName().equalsIgnoreCase("set".concat(modelAttribute.toString())))
				.findFirst()
				.get();
	}

}
