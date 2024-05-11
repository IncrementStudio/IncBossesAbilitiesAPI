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

    public AbilityPlugin(String name, Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {}

    public void start(StartReason reason) { }
    public void stop(StopReason reason) { }

    public Boss getBoss() { return null; }
    public Phase getPhase() { return null; }
    public FileConfiguration getBossConfig() { return null; }
    public ConfigurationSection getAbilityConfig() { return null; }
}