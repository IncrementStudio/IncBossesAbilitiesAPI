package ru.incrementstudio.incbosses;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incbosses.bosses.Boss;
import ru.incrementstudio.incbosses.bosses.phases.Phase;

public interface AbilityExtension {
    AbilityBase getAbility(Boss boss, Phase phase, ConfigurationSection config);
}
