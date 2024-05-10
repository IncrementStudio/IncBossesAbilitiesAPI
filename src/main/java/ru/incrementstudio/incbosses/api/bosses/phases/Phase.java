package ru.incrementstudio.incbosses.api.bosses.phases;

import ru.incrementstudio.incbosses.api.bosses.Boss;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Phase {
    private final Boss boss;
    private final Object phase;
    public Phase(Boss boss, Object phase) {
        this.boss = boss;
        this.phase = phase;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Phase)
            return boss.equals(((Phase) obj).boss) && ((Phase) obj).getId() == getId();
        return false;
    }

    private Object invoke(String method, Object... params) {
        try {
            return phase.getClass().getMethod(method, Arrays.stream(params)
                    .map(Object::getClass)
                    .toArray(Class[]::new)
            ).invoke(phase, params);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ignore) { }
        return null;
    }
    private <T> T notNullOrDefault(T obj, T defaultObj) {
        return obj == null ? defaultObj : obj;
    }

    public int getId() {
        return (int) notNullOrDefault(invoke("getId"), 0);
    }
    public PhaseData getData() {
        return new PhaseData(invoke("getData"));
    }
    public double getLifetime() {
        return (double) notNullOrDefault(invoke("getLifetime"), 0);
    }
}
