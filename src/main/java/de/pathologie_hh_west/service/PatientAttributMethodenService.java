package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.Patient;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    public void methodSetterPatient(PatientModelAttribute modelAttribute, Object object, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (object == null || setterMethod.getParameterTypes()[0].equals(object.getClass())) {
                    setterMethod.invoke(patient, object);
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

    public void methodSetterAdresse(PatientModelAttribute modelAttribute, Object object, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (object == null || setterMethod.getParameterTypes()[0].equals(object.getClass())) {
                    setterMethod.invoke(patient.getAdresse(), object);
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

    public void methodSetterEE2011(PatientModelAttribute modelAttribute, Object object, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (object == null || setterMethod.getParameterTypes()[0].equals(object.getClass())) {
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2011(), object);
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

    public void methodSetterEE2015(PatientModelAttribute modelAttribute, Object object, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (object == null || setterMethod.getParameterTypes()[0].equals(object.getClass())) {
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getEe2015(), object);
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

    public void methodSetterExprimage(PatientModelAttribute modelAttribute, Object object, Patient patient) {
        Method[] setterMethods = getSetterMethod(modelAttribute);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (object == null || setterMethod.getParameterTypes()[0].equals(object.getClass())) {
                    setterMethod.invoke(patient.getPatientenZusatzdaten().getExprimage(), object);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodSetterTumorart(PatientModelAttribute attributName, Object zellenWert, Patient patient) {
    }

    public void methodSetterKlassifikation(PatientModelAttribute attributName, Object zellenWert, Patient patient) {
    }

    public void methodSetterFallID(PatientModelAttribute attributName, Object zellenWert, Patient patient) {
        Method[] setterMethods = getSetterMethod(attributName);
        for (Method setterMethod : setterMethods) {
            try {
                //setter darf nur einen parameter haben
                if (zellenWert == null || setterMethod.getParameterTypes()[0].equals(zellenWert.getClass())) {
                    setterMethod.invoke(patient.getFaelle(), zellenWert);
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
                    //TODO mäh funktioniert nur bei setBefundtext, kann nicht benutzt werden um FallID Klassifikation etc zu setzen
                    setterMethod.invoke(patient.getFaelle().toArray()[0], zellenWert);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
