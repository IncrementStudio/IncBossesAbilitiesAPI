package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;
import ru.incrementstudio.incbosses.api.bosses.phases.PhaseData;

import java.util.List;

public interface BossData {
    /**
     * @return the service name of the boss
     */
    @NotNull
    String getName();

    /**
     * @return the name of the boss
     */
    @NotNull
    String getBossName();

    /**
     * @return the display name of the boss
     */
    @NotNull
    String getDisplayName();

    /**
     * @return the type of the boss entity
     */
    @NotNull
    EntityType getEntityType();

    /**
     * @return the initial health of the boss
     */
    double getHealth();

    /**
     * @return {@code true} if the boss is glowing
     */
    boolean isGlowing();

    /**
     * @return {@code true} if the boss is baby and entity is {@link Ageable}
     */
    boolean isBaby();

    /**
     * @return all phase data of this boss
     */
    @NotNull
    List<PhaseData> getPhaseDatas();

    /**
     * @return the boss's equipment
     */
    @NotNull
    Equipment getEquipment();

    /**
     * @return the boss configuration section
     */
    @NotNull
    ConfigurationSection getConfig();
}