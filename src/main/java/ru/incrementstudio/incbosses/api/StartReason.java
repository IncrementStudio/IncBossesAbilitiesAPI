package ru.incrementstudio.incbosses.api;

public enum StartReason {
    SPAWN(0),
    PHASE_CHANGING(1);
    public final int type;

    StartReason(int type) {
        this.type = type;
    }

    public static StartReason getByType(int type) {
        for (StartReason reason : values())
            if (reason.type == type)
                return reason;
        return null;
    }
}
