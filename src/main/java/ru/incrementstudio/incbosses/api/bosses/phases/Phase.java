package ru.incrementstudio.incbosses.api.bosses.phases;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.incrementstudio.incbosses.api.bosses.Boss;

public interface Phase {
    /**
     * @return the unique ID of this phase
     */
    int getId();

    /**
     * @return the data of this phase
     */
    @NotNull
    PhaseData getData();

    /**
     * @return the boss to which this phase belongs
     */
    @NotNull
    Boss getBoss();

    /**
     * @return the reason for starting the phase or {@code null} if the phase is not active
     */
    @Nullable
    StartReason getStartReason();

    /**
     * @return {@code true} if the phase is active
     */
    boolean isActive();

    /**
     * @return the duration of this phase, starting from when it began
     */
    long getDuration();
}