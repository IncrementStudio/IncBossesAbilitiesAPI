package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.logging.Logger;

// @formatter:off
public abstract class AbilityPlugin {
    public static Plugin getIncBosses() { return null; }
    public Logger getLogger() { return null; }
    public String getName() { return null; }

    protected final Boss boss;
    protected final Phase phase;
    protected final FileConfiguration bossConfig;
    protected final ConfigurationSection abilityConfig;

    public AbilityPlugin(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        this.boss = boss;
        this.phase = phase;
        this.bossConfig = bossConfig;
        this.abilityConfig = abilityConfig;
    }

    public void start(StartReason reason) { }
    public void stop(StopReason reason) { }

    public Boss getBoss() { return boss; }
    public Phase getPhase() { return phase; }
    public FileConfiguration getBossConfig() { return bossConfig; }
    public ConfigurationSection getAbilityConfig() { return abilityConfig; }
}