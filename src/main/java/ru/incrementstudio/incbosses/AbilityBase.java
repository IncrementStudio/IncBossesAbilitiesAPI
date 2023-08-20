package ru.incrementstudio.incbosses;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incbosses.bosses.Boss;
import ru.incrementstudio.incbosses.bosses.phases.Phase;

public interface AbilityBase {
    Boss getBoss();
    Phase getPhase();
    ConfigurationSection getConfig();
    boolean isActive();
    void start();
    void stop();
}
