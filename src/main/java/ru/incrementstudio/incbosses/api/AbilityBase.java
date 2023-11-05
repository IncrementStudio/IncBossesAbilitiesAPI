package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;

public class AbilityBase {
    protected int bossId, phaseId;
    protected ConfigurationSection config;
    public AbilityBase(int bossId, int phaseId, ConfigurationSection config) {
        this.bossId = bossId;
        this.phaseId = phaseId;
        this.config = config;
    }
    public void start() { }
    public void stop() { }
}
