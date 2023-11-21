package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class AbilityBase {
    protected int bossId, phaseId;
    protected FileConfiguration bossConfig;
    protected ConfigurationSection abilityConfig;
    public AbilityBase(int bossId, int phaseId, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        this.bossId = bossId;
        this.phaseId = phaseId;
        this.bossConfig = bossConfig;
        this.abilityConfig = abilityConfig;
    }
    public void start(int reason) { }
    public void stop(int reason) { }
}
