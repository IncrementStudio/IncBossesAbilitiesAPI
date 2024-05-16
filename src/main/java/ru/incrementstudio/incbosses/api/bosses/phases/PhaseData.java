package ru.incrementstudio.incbosses.api.bosses.phases;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incbosses.api.bosses.BossData;

// @formatter:off
public interface PhaseData {
    BossData getBossData();
    String getName();
    String getPhaseName();
    ConfigurationSection getConfig();
}