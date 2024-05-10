package ru.incrementstudio.incbosses.api;

public enum StopReason {
    DEATH(0),
    PHASE_CHANGING(1);
    public final int type;

    StopReason(int type) {
        this.type = type;
    }

    public static StopReason getByType(int type) {
        for (StopReason reason : values())
            if (reason.type == type)
                return reason;
        return null;
    }
}
