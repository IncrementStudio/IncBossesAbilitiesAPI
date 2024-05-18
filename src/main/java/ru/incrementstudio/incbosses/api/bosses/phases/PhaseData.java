package ru.incrementstudio.incbosses.api.bosses.phases;

import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import ru.incrementstudio.incbosses.api.bosses.BossData;

public interface PhaseData {
    /**
     * @return the data of the boss to whom this phase belongs
     */
    @NotNull
    BossData getBossData();

    /**
     * @return the service name of the phase
     */
    @NotNull
    String getName();

    /**
     * @return the name of the phase
     */
    @NotNull
    String getPhaseName();

    /**
     * @return the phase configuration section
     */
    @NotNull
    ConfigurationSection getConfig();
}