package ru.incrementstudio.incbosses.bosses.abilities;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incbosses.bosses.Boss;
import ru.incrementstudio.incbosses.bosses.phases.Phase;

public class Ability {
    public Ability(Boss boss, Phase phase, ConfigurationSection config) { }
    public Object getAbilityExtension() { return null; }
    public Boss getBoss() { return null; }
    public Phase getPhase() { return null; }
    public ConfigurationSection getConfig() { return null; }
    public boolean isActive() { return false; }
    public void stop() { }
    public void start() { }
}
