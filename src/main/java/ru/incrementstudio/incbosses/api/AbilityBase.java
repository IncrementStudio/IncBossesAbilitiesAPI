package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incbosses.api.bosses.Boss;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;

public abstract class AbilityBase {
    protected Boss boss;
    protected Phase phase;
    protected ConfigurationSection config;
    protected boolean active;

    public AbilityBase(Boss boss, Phase phase, ConfigurationSection config) {
        this.boss = boss;
        this.phase = phase;
        this.config = config;
    }

    public Boss getBoss() { return boss; }
    public Phase getPhase() { return phase; }
    public ConfigurationSection getConfig() { return config; }
    public boolean isActive() { return active; }
    public abstract void start();
    public abstract void stop();
}
