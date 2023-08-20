package ru.incrementstudio.incbosses.bosses.phases;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incbosses.bosses.enums.TransitionType;

public interface TransitionData {
    TransitionType getType();
    ConfigurationSection getConfig();
    boolean checkTransition(Phase phase);
}
