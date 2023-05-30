package ru.incrementstudio.incbossesabilitiesapi;

import org.bukkit.entity.LivingEntity;

public abstract class AbilityBase {
    protected String abilityName, boss, phase, configName;
    public String getCapabilityName() { return abilityName; }
    public String getBoss() { return boss; }
    public String getPhase() { return phase; }
    public String getConfigName() { return configName; }

    protected boolean active;
    public boolean isActive() { return active; }

    public AbilityBase(String boss, String phase, String configName) {
        this.abilityName = AbilityExtension.getInstance().getName().replace("IncBossesAbility_", "");
        this.boss = boss;
        this.phase = phase;
        this.configName = configName;
    }

    public abstract void start(LivingEntity bossEntity);

    public abstract void stop();
}
