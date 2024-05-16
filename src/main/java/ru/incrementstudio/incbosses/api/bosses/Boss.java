package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import ru.incrementstudio.incbosses.api.bosses.enums.BossDeathType;
import ru.incrementstudio.incbosses.api.bosses.enums.BossSpawnType;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;

import java.util.List;
import java.util.Map;

// @formatter:off
public interface Boss {
    int getId();
    BossData getData();
    LivingEntity getEntity();
    void kill();
    boolean isAlive();
    Player getKiller();
    Player getLastDamager();
    double getHealth();
    double getNormalizedHealth();
    Phase getCurrentPhase();
    List<Phase> getPhases();
    void changePhase(String name);
    Map<String, Double> getDamageMap();
    BossDeathType getDeathType();
    BossSpawnType getSpawnType();
}