package ru.incrementstudio.incbosses.bosses.phases;

import ru.incrementstudio.incbosses.bosses.Boss;
import ru.incrementstudio.incbosses.bosses.abilities.Ability;

import java.util.List;

public interface Phase {
    PhaseData getData();
    Boss getBoss();
    double getLifetime();
    List<Ability> getAbilities();
    void start();
    void stop();
}
