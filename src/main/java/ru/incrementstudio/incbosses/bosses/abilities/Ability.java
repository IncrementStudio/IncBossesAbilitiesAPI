package ru.incrementstudio.incbosses.bosses.abilities;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.LivingEntity;
import ru.incrementstudio.incbosses.bosses.BossData;
import ru.incrementstudio.incbosses.bosses.phases.PhaseData;

public interface Ability {
    Object getAbilityExtension();
    BossData getBossData();
    PhaseData getPhaseData();
    ConfigurationSection getConfig();
    boolean isActive();
    void stop();
    void start();
}
