package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class AbilityBase {
    protected int bossId, phaseId;
    protected FileConfiguration bossConfig;
    protected ConfigurationSection phaseConfig;
    public AbilityBase(int bossId, int phaseId, FileConfiguration bossConfig, ConfigurationSection phaseConfig) {
        this.bossId = bossId;
        this.phaseId = phaseId;
        this.bossConfig = bossConfig;
        this.phaseConfig = phaseConfig;
    }
    public void start(int reason) { }
    public void stop(int reason) { }
}
