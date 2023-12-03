package ru.incrementstudio.incbosses.api;

public enum StartReason {
    SPAWN, PHASE_CHANGING;

    public static StartReason of(int value) {
        if (value == 0) return StartReason.SPAWN;
        if (value == 1) return StartReason.PHASE_CHANGING;
        return null;
    }
}
