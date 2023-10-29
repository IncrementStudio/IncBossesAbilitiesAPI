package ru.incrementstudio.incbosses.api.bosses.phases;

import ru.incrementstudio.incbosses.api.bosses.Boss;

import java.util.List;

public class Phase {
    public Phase(Boss boss, PhaseData phaseData) { }
    public PhaseData getData() { return null; }
    public Boss getBoss() { return null; }
    public double getLifetime() { return 0; }
    public void start() { }
    public void stop() { }
}
