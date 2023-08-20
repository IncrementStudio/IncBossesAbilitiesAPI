package ru.incrementstudio.incbosses.bosses.abilities;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incbosses.bosses.Boss;
import ru.incrementstudio.incbosses.bosses.phases.Phase;

public interface Ability {
    Object getAbilityExtension();
    Boss getBoss();
    Phase getPhase();
    ConfigurationSection getConfig();
    boolean isActive();
    void stop();
    void start();
}
