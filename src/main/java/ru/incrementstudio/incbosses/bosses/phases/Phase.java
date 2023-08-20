package ru.incrementstudio.incbosses.bosses.phases;

import org.bukkit.entity.LivingEntity;
import ru.incrementstudio.incbosses.bosses.Boss;

public interface Phase {
    PhaseData getData();
    Boss getBoss();
    double getLifetime();
    void start(LivingEntity entity);
    void stop();
}
