package ru.incrementstudio.incbosses.api;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.logging.Logger;

public abstract class AbilityPlugin {
    private Logger logger;
    public Logger getLogger() { return logger; }

    public final void enable() {
        logger = Logger.getLogger(AbilityPlugin.class.getName());
        onEnable();
    }
    public final void disable() {
        onDisable();
    }
    public void onEnable() { }
    public void onDisable() { }

    protected final String name;
    public String getName() {
        return name;
    }

    protected final Boss boss;
    protected final Phase phase;
    protected final FileConfiguration bossConfig;
    protected final ConfigurationSection abilityConfig;
    public static Plugin IncBosses = Bukkit.getPluginManager().getPlugin("IncBosses");

    public AbilityPlugin(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        this.name = getClass().getClassLoader().getName();
        this.boss = boss;
        this.phase = phase;
        this.bossConfig = bossConfig;
        this.abilityConfig = abilityConfig;
    }

    public final void start(int reason) {
        start(StartReason.getByType(reason));
    }
    public final void stop(int reason) {
        stop(StopReason.getByType(reason));
    }
    public void start(StartReason reason) { }
    public void stop(StopReason reason) { }
}
