package ru.incrementstudio.incbosses.api.enums;

public enum BossDeathType {
    PLAYER(0),
    COMMAND(1),
    TIME(2),
    OTHER(3);
    public final int type;
    BossDeathType(int type) {
        this.type = type;
    }
    public static BossDeathType getByType(int type) {
        for (BossDeathType bossDeathType : values())
            if (bossDeathType.type == type)
                return bossDeathType;
        return null;
    }
}
