package ru.incrementstudio.incbossesabilitiesapi;

import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public abstract class AbilityBase {
    protected String abilityName, boss, phase, configName;
    @NotNull
    public String getCapabilityName() { return abilityName; }
    @NotNull
    public String getBoss() { return boss; }
    @NotNull
    public String getPhase() { return phase; }
    @NotNull
    public String getConfigName() { return configName; }

    protected boolean active;
    @NotNull
    public boolean isActive() { return active; }

    public AbilityBase(@NotNull String boss, @NotNull String phase, @NotNull String configName) {
        this.abilityName = AbilityExtension.getInstance().getName().replace("IncBossesAbility_", "");
        this.boss = boss;
        this.phase = phase;
        this.configName = configName;
    }

    public abstract void start(@NotNull LivingEntity bossEntity);

    public abstract void stop();
}
