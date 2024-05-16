package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import ru.incrementstudio.incbosses.api.bosses.phases.PhaseData;

import java.util.List;

// @formatter:off
public interface BossData {
    String getName();
    String getBossName();
    String getDisplayName();
    EntityType getEntityType();
    double getHealth();
    boolean isGlowing();
    boolean isBaby();
    List<PhaseData> getPhaseDatas();
    Equipment getEquipment();
    ConfigurationSection getConfig();
}