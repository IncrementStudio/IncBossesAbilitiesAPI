package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.PluginClassLoader;

import java.util.logging.Logger;

// @formatter:off
public abstract class AbilityPlugin {
    private final Logger logger;
    public Logger getLogger() { return logger; }

    protected final String name;
    public String getName() {
        return name;
    }

    protected final Boss boss;
    protected final Phase phase;
    protected final FileConfiguration bossConfig;
    protected final ConfigurationSection abilityConfig;
    public static Plugin IncBossesPlugin = ((PluginClassLoader) AbilityPlugin.class.getClassLoader().getParent()).getPlugin();;

    public AbilityPlugin(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        logger = Logger.getLogger(AbilityPlugin.class.getName());
        this.name = getClass().getClassLoader().getName();
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