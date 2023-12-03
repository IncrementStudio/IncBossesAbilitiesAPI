package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import ru.incrementstudio.incbosses.api.bosses.Boss;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;

public class AbilityBase {
    protected Boss boss;
    protected Phase phase;
    protected FileConfiguration bossConfig;
    protected ConfigurationSection abilityConfig;
    public AbilityBase(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        this.boss = boss;
        this.phase = phase;
        this.bossConfig = bossConfig;
        this.abilityConfig = abilityConfig;
    }
    public void start(StartReason reason) { }
    public void stop(StopReason reason) { }
}
