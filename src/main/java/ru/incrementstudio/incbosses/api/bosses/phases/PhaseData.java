package ru.incrementstudio.incbosses.api.bosses.phases;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class PhaseData {
    private final Object phaseData;
    public PhaseData(Object phaseData) {
        this.phaseData = phaseData;
    }

    private Object invoke(String method, Object... params) {
        try {
            return phaseData.getClass().getMethod(method, Arrays.stream(params)
                    .map(Object::getClass)
                    .toArray(Class[]::new)
            ).invoke(phaseData, params);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ignore) { }
        return null;
    }
    private <T> T notNullOrDefault(T obj, T defaultObj) {
        return obj == null ? defaultObj : obj;
    }

    public String getName() {
        return (String) invoke("getName");
    }
    public String getPhaseName() {
        return (String) invoke("getPhaseName");
    }
}
