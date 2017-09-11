package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.BefundTyp;
import de.pathologie_hh_west.model.Patient;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by VaniR on 18.07.2017.
 * Project: path_db
 */
@Component
public class PatientAttributMethodenService {

    private Method getGetterMethod(PatientModelAttribute modelAttribute) {
        return Arrays.stream(modelAttribute.getWrappingClass().getMethods())
                .filter(method -> method.getName().equalsIgnoreCase("get".concat(modelAttribute.toString())))
                .findFirst()
                .get();
    }

    private Method[] getSetterMethod(PatientModelAttribute modelAttribute) {
        return Arrays.stream(modelAttribute.getWrappingClass().getMethods())
                .filter(method -> method.getName().equalsIgnoreCase("set".concat(modelAttribute.toString())))
                .toArray(size -> new Method[size]);
    }

    public Object methodGetterPatient(PatientModelAttribute modelAttribute, Patient patient) {
        Method getterMethod = getGetterMethod(modelAttribute);
        try {
            return getterMethod.invoke(patient);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void methodSetterPatient(PatientModelAttribute modelAttribute, Object zellenWert, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (zellenWert == null || setterMethod.getParameterTypes()[0].equals(zellenWert.getClass())) {
                    setterMethod.invoke(patient, zellenWert);
                }
                if (setterMethod.getParameterTypes()[0].equals(Integer.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient, temp.intValue());
                }
                if (setterMethod.getParameterTypes()[0].equals(String.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient, temp.intValue() + "");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public Object methodGetterAdresse(PatientModelAttribute modelAttribute, Patient patient) {
        Method getterMethod = getGetterMethod(modelAttribute);
        try {
            return getterMethod.invoke(patient.getAdresse());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void methodSetterAdresse(PatientModelAttribute modelAttribute, Object zellenWert, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (zellenWert == null || setterMethod.getParameterTypes()[0].equals(zellenWert.getClass())) {
                    setterMethod.invoke(patient.getAdresse(), zellenWert);
                }
                if (setterMethod.getParameterTypes()[0].equals(Integer.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getAdresse(), temp.intValue());
                }
                if (setterMethod.getParameterTypes()[0].equals(String.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getAdresse(), temp.intValue() + "");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public Object methodGetterEE2011(PatientModelAttribute modelAttribute, Patient patient) {
        Method getterMethod = getGetterMethod(modelAttribute);
        try {
            return getterMethod.invoke(patient.getPatientenZusatzdaten().getEe2011());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void methodSetterEE2011(PatientModelAttribute modelAttribute, Object zellenWert, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (zellenWert == null || setterMethod.getParameterTypes()[0].equals(zellenWert.getClass())) {
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2011(), zellenWert);
                }
                if (setterMethod.getParameterTypes()[0].equals(Integer.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2011(), temp.intValue());
                }
                if (setterMethod.getParameterTypes()[0].equals(String.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2011(), temp.intValue() + "");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public Object methodGetterEE2015(PatientModelAttribute modelAttribute, Patient patient) {
        Method getterMethod = getGetterMethod(modelAttribute);
        try {
            return getterMethod.invoke(patient.getPatientenZusatzdaten().getEe2015());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void methodSetterEE2015(PatientModelAttribute modelAttribute, Object zellenWert, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (zellenWert == null || setterMethod.getParameterTypes()[0].equals(zellenWert.getClass())) {
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2015(), zellenWert);
                }
                if (setterMethod.getParameterTypes()[0].equals(Integer.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2015(), temp.intValue());
                }
                if (setterMethod.getParameterTypes()[0].equals(String.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2015(), temp.intValue() + "");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public Object methodGetterExprimage(PatientModelAttribute modelAttribute, Patient patient) {
        Method getterMethod = getGetterMethod(modelAttribute);
        try {
            return getterMethod.invoke(patient.getPatientenZusatzdaten().getExprimage());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void methodSetterExprimage(PatientModelAttribute modelAttribute, Object zellenWert, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (zellenWert == null || setterMethod.getParameterTypes()[0].equals(zellenWert.getClass())) {
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getExprimage(), zellenWert);
                }
                if (setterMethod.getParameterTypes()[0].equals(Integer.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getExprimage(), temp.intValue());
                }
                if (setterMethod.getParameterTypes()[0].equals(String.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getExprimage(), temp.intValue() + "");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterTumorart(PatientModelAttribute attributName, Object zellenWert, Patient patient) {
        Method[] setterMethods = getSetterMethod(attributName);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (zellenWert == null || setterMethod.getParameterTypes()[0].equals(zellenWert.getClass())) {
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation().getTumorArt(), zellenWert);
                }
                if (setterMethod.getParameterTypes()[0].equals(Integer.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation().getTumorArt(), temp.intValue());
                }
                if (setterMethod.getParameterTypes()[0].equals(String.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation().getTumorArt(), temp.intValue() + "");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterKlassifikation(PatientModelAttribute attributName, Object zellenWert, Patient patient) {
        Method[] setterMethods = getSetterMethod(attributName);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (zellenWert == null || setterMethod.getParameterTypes()[0].equals(zellenWert.getClass())) {
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation(), zellenWert);
                }
                if (setterMethod.getParameterTypes()[0].equals(Integer.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation(), temp.intValue());
                }
                if (setterMethod.getParameterTypes()[0].equals(String.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation(), temp.intValue() + "");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterFallID(PatientModelAttribute attributName, Object zellenWert, Patient patient) {
        Method[] setterMethods = getSetterMethod(attributName);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (attributName == PatientModelAttribute.ENUMMER && zellenWert != "") {
                    patient.getFaelle().stream().findFirst().get().getFallID().geteNummer().setValue(zellenWert.toString());
                }
                if (zellenWert == null || setterMethod.getParameterTypes()[0].equals(zellenWert.getClass())) {
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getFallID(), zellenWert);
                }
                if (setterMethod.getParameterTypes()[0].equals(Integer.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getFallID(), temp.intValue());
                }
                if (setterMethod.getParameterTypes()[0].equals(String.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getFallID(), temp.intValue() + "");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterFall(PatientModelAttribute attributName, Object zellenWert, Patient patient) {
        Method[] setterMethods = getSetterMethod(attributName);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (zellenWert == null || setterMethod.getParameterTypes()[0].equals(zellenWert.getClass())) {
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get(), zellenWert);
                }
                if (setterMethod.getParameterTypes()[0].equals(Integer.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get(), temp.intValue());
                }
                if (setterMethod.getParameterTypes()[0].equals(String.class) && zellenWert.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) zellenWert;

                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get(), temp.intValue() + "");
                }

            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public Object methodGetterFall(PatientModelAttribute patientAttribut, Patient patientAusDatenbank, Patient patient) {
        Method getterMethod = getGetterMethod(patientAttribut);
        try {

            return getterMethod.invoke(patient.getFaelle().stream().
                    filter(s -> {
                        BefundTyp befundTyp = patient.getFaelle().stream().findAny().get().getFallID().getBefundTyp();
                        return s.getFallID().getBefundTyp().equals(befundTyp);
                    }).
                    filter(s -> {
                        String eNummer = patient.getFaelle().stream().findAny().get().getFallID().geteNummer().getValue();
                        return s.getFallID().geteNummer().getValue().equals(eNummer);
                    }).findFirst().get());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object methodGetterTumorart(PatientModelAttribute patientAttribut, Patient patientAusDatenbank, Patient patient) {
        Method getterMethod = getGetterMethod(patientAttribut);
        try {

            return getterMethod.invoke(patient.getFaelle().stream().
                    filter(s -> {
                        BefundTyp befundTyp = patient.getFaelle().stream().findAny().get().getFallID().getBefundTyp();
                        return s.getFallID().getBefundTyp().equals(befundTyp);
                    }).
                    filter(s -> {
                        String eNummer = patient.getFaelle().stream().findAny().get().getFallID().geteNummer().getValue();
                        return s.getFallID().geteNummer().getValue().equals(eNummer);
                    }).findFirst().get().getKlassifikation().getTumorArt());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object methodGetterKlassifikation(PatientModelAttribute patientAttribut, Patient patientAusDatenbank, Patient patient) {
        Method getterMethod = getGetterMethod(patientAttribut);
        try {

            return getterMethod.invoke(patient.getFaelle().stream().
                    filter(s -> {
                        BefundTyp befundTyp = patient.getFaelle().stream().findAny().get().getFallID().getBefundTyp();
                        return s.getFallID().getBefundTyp().equals(befundTyp);
                    }).
                    filter(s -> {
                        String eNummer = patient.getFaelle().stream().findAny().get().getFallID().geteNummer().getValue();
                        return s.getFallID().geteNummer().getValue().equals(eNummer);
                    }).findFirst().get().getKlassifikation());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
