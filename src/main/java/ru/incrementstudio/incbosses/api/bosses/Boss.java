package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import ru.incrementstudio.incbosses.api.bosses.enums.BossDeathType;
import ru.incrementstudio.incbosses.api.bosses.enums.BossSpawnType;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;

import java.util.List;
import java.util.Map;

public interface Boss {
    /**
     * @return the unique ID of this boss
     */
    int getId();

    /**
     * @return the data of this boss
     */
    @NotNull
    BossData getData();

    /**
     * @return the entity of this boss
     */
    @NotNull
    LivingEntity getEntity();

    /**
     * Kill the boss
     */
    void kill();

    /**
     * @return {@code true} if the boss is alive
     */
    boolean isAlive();

    /**
     * @return the boss killer or {@code null} if the boss is not killed
     */
    @Nullable
    Player getKiller();

    /**
     * @return the last player to do damage, or {@code null} if no player has hit the boss yet
     *
     * @see #getKiller()
     */
    @Nullable
    Player getLastDamager();

    /**
     * @return the current health of this boss
     *
     * @see #getNormalizedHealth()
     */
    double getHealth();

    /**
     * @return the normalized current health of this boss (from 0 to 1 inclusive)
     */
    double getNormalizedHealth();

    /**
     * @return the current phase of this boss
     *
     * @see #getKiller()
     */
    @NotNull
    Phase getCurrentPhase();

    /**
     * @return all phases of this boss
     */
    @NotNull
    List<Phase> getPhases();

    /**
     * Change the current phase to another phase
     *
     * @param name phase name
     * @throws IllegalArgumentException if a phase with this name is not found
     */
    void changePhase(@NotNull String name) throws IllegalArgumentException;

    /**
     * Change the current phase to another phase
     *
     * @param id phase ID
     * @throws IllegalArgumentException if a phase with this ID is not found
     */
    void changePhase(int id) throws IllegalArgumentException;

    /**
     * @return the damage map of this boss
     */
    @NotNull
    Map<String, Double> getDamageMap();

    /**
     * @return the spawn type of this boss
     */
    @NotNull
    BossSpawnType getSpawnType();
}