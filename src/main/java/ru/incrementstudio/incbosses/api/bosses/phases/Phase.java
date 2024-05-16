package ru.incrementstudio.incbosses.api.bosses.phases;

import ru.incrementstudio.incbosses.api.bosses.Boss;
public interface Phase {
    int getId();
    PhaseData getData();
    Boss getBoss();
    StartReason getStartReason();
    boolean isActive();
    long getDuration();
}
