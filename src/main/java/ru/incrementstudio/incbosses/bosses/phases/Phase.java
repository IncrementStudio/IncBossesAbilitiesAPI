package ru.incrementstudio.incbosses.bosses.phases;

import ru.incrementstudio.incbosses.bosses.Boss;
import ru.incrementstudio.incbosses.bosses.abilities.Ability;

import java.util.List;

public class Phase {
    public Phase(Boss boss, PhaseData phaseData) { }
    public PhaseData getData() { return null; }
    public Boss getBoss() { return null; }
    public double getLifetime() { return 0; }
    public List<Ability> getAbilities() { return null; }
    public void start() { }
    public void stop() { }
}
