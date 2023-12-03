package ru.incrementstudio.incbosses.api;

public enum StopReason {
    DEATH, PHASE_CHANGING;

    public static StopReason of(int value) {
        if (value == 0) return StopReason.DEATH;
        if (value == 1) return StopReason.PHASE_CHANGING;
        return null;
    }
}
