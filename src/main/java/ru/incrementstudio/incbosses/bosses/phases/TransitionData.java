package ru.incrementstudio.incbosses.bosses.phases;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incbosses.bosses.enums.TransitionType;

public class TransitionData {
    public TransitionData(ConfigurationSection config) { }
    public boolean checkTransition(Phase phase) { return false; }
    public TransitionType getType() { return null; }
    public ConfigurationSection getConfig() { return null; }
}
