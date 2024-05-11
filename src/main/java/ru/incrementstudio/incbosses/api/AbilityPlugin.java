package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.logging.Logger;

// @formatter:off
public abstract class AbilityPlugin {
    public static Plugin getIncBosses() { return null; }
    public final Logger getLogger() { return null; }
    public final String getName() { return null; }

    public AbilityPlugin(String name, Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) { }

    public void onLoad() { }
    public void start(StartReason reason) { }
    public void stop(StopReason reason) { }

    public final Boss getBoss() { return null; }
    public final Phase getPhase() { return null; }
    public final FileConfiguration getBossConfig() { return null; }
    public final ConfigurationSection getAbilityConfig() { return null; }
}