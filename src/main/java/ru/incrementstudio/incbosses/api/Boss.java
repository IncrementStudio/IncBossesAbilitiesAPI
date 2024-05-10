package ru.incrementstudio.incbosses.api;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import ru.incrementstudio.incbosses.api.enums.BossDeathType;
import ru.incrementstudio.incbosses.api.enums.BossSpawnType;

import java.util.List;
import java.util.Map;

// @formatter:off
public interface Boss {
    int getId();
    BossData getData();
    LivingEntity getEntity();
    void kill();
    boolean isKilled();
    Player getKiller();
    Phase getCurrentPhase();
    List<Phase> getPhases();
    void changePhase(String name);
    Map<String, Double> getDamageMap();
    BossDeathType getDeathType();
    BossSpawnType getSpawnType();
}