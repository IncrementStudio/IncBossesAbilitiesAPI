package ru.incrementstudio.incbosses.api.abilities;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import ru.incrementstudio.incbosses.api.bosses.Boss;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;
import ru.incrementstudio.incbosses.api.bosses.phases.StartReason;
import ru.incrementstudio.incbosses.api.bosses.phases.StopReason;

import java.util.logging.Logger;

// @formatter:off
public abstract class AbilityPlugin {
    private final Logger logger;
    public Logger getLogger() { return logger; }

    private String name;
    public String getName() { return name; }

    private Boss boss;
    private Phase phase;
    private FileConfiguration bossConfig;
    private ConfigurationSection abilityConfig;

    public AbilityPlugin() {
        logger = Logger.getLogger(AbilityPlugin.class.getName());
    }

    public void onLoad() { }
    public void start(StartReason reason) { }
    public void stop(StopReason reason) { }

    public Boss getBoss() { return boss; }
    public Phase getPhase() { return phase; }
    public FileConfiguration getBossConfig() { return bossConfig; }
    public ConfigurationSection getAbilityConfig() { return abilityConfig; }

    public void setName(String name) { this.name = name; }
    public void setBoss(Boss boss) { this.boss = boss; }
    public void setPhase(Phase phase) { this.phase = phase; }
    public void setBossConfig(FileConfiguration bossConfig) { this.bossConfig = bossConfig; }
    public void setAbilityConfig(ConfigurationSection abilityConfig) { this.abilityConfig = abilityConfig; }
}
