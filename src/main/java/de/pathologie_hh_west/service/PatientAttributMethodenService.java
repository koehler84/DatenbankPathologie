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

    public Object methodGetterAdresse(PatientModelAttribute modelAttribute, Patient patient) {
        Method getterMethod = getGetterMethod(modelAttribute);
        try {
            return getterMethod.invoke(patient.getAdresse());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
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

    public Object methodGetterEE2015(PatientModelAttribute modelAttribute, Patient patient) {
        Method getterMethod = getGetterMethod(modelAttribute);
        try {
            return getterMethod.invoke(patient.getPatientenZusatzdaten().getEe2015());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
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

    public Object methodGetterFall(PatientModelAttribute patientAttribut, Patient patientAusDatenbank, Patient patient) {
        Method getterMethod = getGetterMethod(patientAttribut);
        try {

            return getterMethod.invoke(patientAusDatenbank.getFaelle().stream().
                    filter(s -> {
                        BefundTyp befundTyp = patientAusDatenbank.getFaelle().stream().findAny().get().getFallID().getBefundTyp();
                        return s.getFallID().getBefundTyp().equals(befundTyp);
                    }).
                    filter(s -> {
                        String eNummer = patientAusDatenbank.getFaelle().stream().findAny().get().getFallID().geteNummer().getValue();
                        return s.getFallID().geteNummer().getValue().equals(eNummer);
                    }).findFirst().get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object methodGetterTumorart(PatientModelAttribute patientAttribut, Patient patientAusDatenbank, Patient patient) {
        Method getterMethod = getGetterMethod(patientAttribut);
        try {

            return getterMethod.invoke(patientAusDatenbank.getFaelle().stream().
                    filter(s -> {
                        BefundTyp befundTyp = patientAusDatenbank.getFaelle().stream().findAny().get().getFallID().getBefundTyp();
                        return s.getFallID().getBefundTyp().equals(befundTyp);
                    }).
                    filter(s -> {
                        String eNummer = patientAusDatenbank.getFaelle().stream().findAny().get().getFallID().geteNummer().getValue();
                        return s.getFallID().geteNummer().getValue().equals(eNummer);
                    }).findFirst().get().getKlassifikation().getTumorArt());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object methodGetterKlassifikation(PatientModelAttribute patientAttribut, Patient patientAusDatenbank, Patient patient) {
        Method getterMethod = getGetterMethod(patientAttribut);
        try {

            return getterMethod.invoke(patientAusDatenbank.getFaelle().stream().
                    filter(s -> {
                        BefundTyp befundTyp = patientAusDatenbank.getFaelle().stream().findAny().get().getFallID().getBefundTyp();
                        return s.getFallID().getBefundTyp().equals(befundTyp);
                    }).
                    filter(s -> {
                        String eNummer = patientAusDatenbank.getFaelle().stream().findAny().get().getFallID().geteNummer().getValue();
                        return s.getFallID().geteNummer().getValue().equals(eNummer);
                    }).findFirst().get().getKlassifikation());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void methodSetterPatient(PatientModelAttribute modelAttribute, Object dbValue, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (dbValue == null || setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                    setterMethod.invoke(patient, new Object[]{dbValue});
                } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient, temp.intValue());
                } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient, temp.intValue() + "");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterAdresse(PatientModelAttribute modelAttribute, Object dbValue, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (dbValue == null || setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                    setterMethod.invoke(patient.getAdresse(), new Object[]{dbValue});
                } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getAdresse(), temp.intValue());
                } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getAdresse(), temp.intValue() + "");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterEE2011(PatientModelAttribute modelAttribute, Object dbValue, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (dbValue == null || setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2011(), new Object[]{dbValue});
                } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2011(), temp.intValue());
                } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2011(), temp.intValue() + "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterEE2015(PatientModelAttribute modelAttribute, Object dbValue, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (dbValue == null || setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2015(), new Object[]{dbValue});
                } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2015(), temp.intValue());
                } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2015(), temp.intValue() + "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterExprimage(PatientModelAttribute modelAttribute, Object dbValue, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (dbValue == null || setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getExprimage(), new Object[]{dbValue});
                } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getExprimage(), temp.intValue());
                } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getExprimage(), temp.intValue() + "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterFall(PatientModelAttribute attributName, Object dbValue, Patient patient) {
        Method[] setterMethods = getSetterMethod(attributName);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (dbValue == null || setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get(), new Object[]{dbValue});
                } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get(), temp.intValue());
                } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;

                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get(), temp.intValue() + "");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterFallBekannt(PatientModelAttribute patientAttribut, Object dbValue, Patient patientAusDatenbank, Patient patientAusExcel) {
        Method[] setterMethods = getSetterMethod(patientAttribut);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (patientAusDatenbank.getFaelle().stream().findFirst().get().getFallID().geteNummer() == null) {
                    if (setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                        setterMethod.invoke(patientAusDatenbank.getFaelle().stream().filter(f -> f.getFallID().geteNummer().getValue().equals(patientAusExcel.getFaelle().stream().findFirst().get().getFallID().geteNummer().getValue()))
                                .filter(g -> g.getFallID().getBefundTyp().equals(patientAusExcel.getFaelle().stream()
                                        .findFirst().get().getFallID().getBefundTyp())).findFirst().get(), new Object[]{dbValue});
                    } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                        BigDecimal temp = (BigDecimal) dbValue;
                        setterMethod.invoke(patientAusDatenbank.getFaelle().stream().filter(f -> f.getFallID().geteNummer().getValue().equals(patientAusExcel.getFaelle().stream().findFirst().get().getFallID().geteNummer().getValue()))
                                .filter(g -> g.getFallID().getBefundTyp().equals(patientAusExcel.getFaelle().stream()
                                        .findFirst().get().getFallID().getBefundTyp())).findFirst().get(), temp.intValue());
                    } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                        BigDecimal temp = (BigDecimal) dbValue;
                        setterMethod.invoke(patientAusDatenbank.getFaelle()
                                .stream()
                                .filter(f -> f.getFallID().geteNummer().getValue().equals(patientAusExcel.getFaelle().stream().findFirst().get().getFallID().geteNummer().getValue()))
                                .filter(g -> g.getFallID().getBefundTyp().equals(patientAusExcel.getFaelle().stream()
                                        .findFirst().get().getFallID().getBefundTyp()))
                                .findFirst().get(), temp.intValue() + "");
                    }
                } else {
                    methodSetterFall(patientAttribut, dbValue, patientAusExcel);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterFallID(PatientModelAttribute attributName, Object dbValue, Patient patient) {
        Method[] setterMethods = getSetterMethod(attributName);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (attributName == PatientModelAttribute.ENUMMER && dbValue != "") {
                    patient.getFaelle().stream().findFirst().get().getFallID().geteNummer().setValue(dbValue.toString());
                } else if (dbValue == null || setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getFallID(), new Object[]{dbValue});
                } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getFallID(), temp.intValue());
                } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getFallID(), temp.intValue() + "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterTumorart(PatientModelAttribute attributName, Object dbValue, Patient patient) {
        Method[] setterMethods = getSetterMethod(attributName);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (dbValue == null || setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation().getTumorArt(), new Object[]{dbValue});
                } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation().getTumorArt(), temp.intValue());
                } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation().getTumorArt(), temp.intValue() + "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterTumorartFallBekannt(PatientModelAttribute patientAttribut, Object dbValue, Patient patientAusDatenbank, Patient patientAusExcel) {
        Method[] setterMethods = getSetterMethod(patientAttribut);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (patientAusDatenbank.getFaelle().stream().findFirst().get().getFallID().geteNummer() == null) {
                    if (dbValue == null || setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                        setterMethod.invoke(patientAusDatenbank.getFaelle().stream().filter(f -> f.getFallID().geteNummer().getValue().equals(patientAusExcel.getFaelle().stream().findFirst().get().getFallID().geteNummer().getValue()))
                                .filter(g -> g.getFallID().getBefundTyp().equals(patientAusExcel.getFaelle().stream()
                                        .findFirst().get().getFallID().getBefundTyp())).findFirst().get().getKlassifikation().getTumorArt(), new Object[]{dbValue});
                    } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                        BigDecimal temp = (BigDecimal) dbValue;
                        setterMethod.invoke(patientAusDatenbank.getFaelle().stream().filter(f -> f.getFallID().geteNummer().getValue().equals(patientAusExcel.getFaelle().stream().findFirst().get().getFallID().geteNummer().getValue()))
                                .filter(g -> g.getFallID().getBefundTyp().equals(patientAusExcel.getFaelle().stream()
                                        .findFirst().get().getFallID().getBefundTyp())).findFirst().get().getKlassifikation().getTumorArt(), temp.intValue());
                    } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                        BigDecimal temp = (BigDecimal) dbValue;
                        setterMethod.invoke(patientAusDatenbank.getFaelle().stream().filter(f -> f.getFallID().geteNummer().getValue().equals(patientAusExcel.getFaelle().stream().findFirst().get().getFallID().geteNummer().getValue()))
                                .filter(g -> g.getFallID().getBefundTyp().equals(patientAusExcel.getFaelle().stream()
                                        .findFirst().get().getFallID().getBefundTyp())).findFirst().get().getKlassifikation().getTumorArt(), temp.intValue() + "");
                    }
                } else {
                    methodSetterTumorart(patientAttribut, dbValue, patientAusExcel);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterKlassifikation(PatientModelAttribute attributName, Object dbValue, Patient patient) {
        Method[] setterMethods = getSetterMethod(attributName);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (dbValue == null || setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation(), new Object[]{dbValue});
                } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation(), temp.intValue());
                } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                    BigDecimal temp = (BigDecimal) dbValue;
                    setterMethod.invoke(patient.getFaelle().stream().findFirst().get().getKlassifikation(), temp.intValue() + "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterKlassifikationFallBekannt(PatientModelAttribute patientAttribut, Object dbValue, Patient patientAusDatenbank, Patient patientAusExcel) {
        Method[] setterMethods = getSetterMethod(patientAttribut);
        if (dbValue == "") dbValue = null;
        for (Method setterMethod : setterMethods) {
            try {
                if (patientAusDatenbank.getFaelle().stream().findFirst().get().getFallID().geteNummer() == null) {
                    //setter darf nur einen parameter haben
                    if (dbValue == null || setterMethod.getParameterTypes()[0].equals(dbValue.getClass())) {
                        setterMethod.invoke(patientAusDatenbank.getFaelle().stream().filter(f -> f.getFallID().geteNummer().getValue().equals(patientAusExcel.getFaelle().stream().findFirst().get().getFallID().geteNummer().getValue()))
                                .filter(g -> g.getFallID().getBefundTyp().equals(patientAusExcel.getFaelle().stream()
                                        .findFirst().get().getFallID().getBefundTyp())).findFirst().get().getKlassifikation(), new Object[]{dbValue});
                    } else if (setterMethod.getParameterTypes()[0].equals(Integer.class) && dbValue.getClass().equals(BigDecimal.class)) {
                        BigDecimal temp = (BigDecimal) dbValue;
                        setterMethod.invoke(patientAusDatenbank.getFaelle().stream().filter(f -> f.getFallID().geteNummer().getValue().equals(patientAusExcel.getFaelle().stream().findFirst().get().getFallID().geteNummer().getValue()))
                                .filter(g -> g.getFallID().getBefundTyp().equals(patientAusExcel.getFaelle().stream()
                                        .findFirst().get().getFallID().getBefundTyp())).findFirst().get().getKlassifikation(), temp.intValue());
                    } else if (setterMethod.getParameterTypes()[0].equals(String.class) && dbValue.getClass().equals(BigDecimal.class)) {
                        BigDecimal temp = (BigDecimal) dbValue;
                        setterMethod.invoke(patientAusDatenbank.getFaelle()
                                .stream()
                                .filter(f -> f.getFallID().geteNummer().getValue().equals(patientAusExcel.getFaelle().stream().findFirst().get().getFallID().geteNummer().getValue()))
                                .filter(g -> g.getFallID().getBefundTyp().equals(patientAusExcel.getFaelle().stream()
                                        .findFirst().get().getFallID().getBefundTyp()))
                                .findFirst().get().getKlassifikation(), temp.intValue() + "");
                    }
                } else {
                    methodSetterKlassifikation(patientAttribut, dbValue, patientAusDatenbank);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterFallIDBekannt(PatientModelAttribute patientAttribut, Patient patientAusExcel, Patient patientAusDatenbank) {
        Method[] setterMethods = getSetterMethod(patientAttribut);
        for (Method setterMethod : setterMethods) {
            try {
                if (patientAttribut == PatientModelAttribute.ENUMMER) {
                    patientAusDatenbank.getFaelle().stream().findFirst().get().getFallID().geteNummer().setValue(
                            patientAusExcel.getFaelle().stream().findFirst().get().getFallID().geteNummer().getValue()
                    );
                }
                if (patientAttribut == PatientModelAttribute.BEFUNDTYP) {
                    patientAusDatenbank.getFaelle().stream().findFirst().get().getFallID().setBefundTyp(
                            patientAusExcel.getFaelle().stream().findFirst().get().getFallID().getBefundTyp()
                    );
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
