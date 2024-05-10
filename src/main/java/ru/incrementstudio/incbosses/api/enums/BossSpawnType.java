package ru.incrementstudio.incbosses.api.enums;

public enum BossSpawnType {
    AUTO(0),
    COMMAND(1);
    public final int type;
    BossSpawnType(int type) {
        this.type = type;
    }
    public static BossSpawnType getByType(int type) {
        for (BossSpawnType bossSpawnType : values())
            if (bossSpawnType.type == type)
                return bossSpawnType;
        return null;
    }
}
