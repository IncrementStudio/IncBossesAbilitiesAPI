package ru.incrementstudio.incbosses.bosses;

import org.bukkit.Location;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import ru.incrementstudio.incbosses.bosses.enums.BossDeathType;
import ru.incrementstudio.incbosses.bosses.enums.BossSpawnType;
import ru.incrementstudio.incbosses.bosses.phases.Phase;

import java.util.*;

public interface Boss {
    void bossActions(Map<String, List<String>> actions);
    void playersActions(Map<String, List<String>> actions, List<Player> players);
    String applyPlaceholders(String string, String phaseName);
    void setPhases();
    Phase getPhaseByName(String name);
    void changePhase(String name);
    void applyPhaseData(Phase phase);
    void spawn(Location location);
    void sendDeathMessage();
    void kill();

    BossData getData();
    LivingEntity getEntity();
    double getNormalizedHealth();
    HashMap<UUID, Double> getDamageMap();
    boolean isKilled();
    Player getKiller();
    BossDeathType getBossDeathType();
    BossSpawnType getBossSpawnType();
    BossBar getBossBar();
    Phase getCurrentPhase();

    void setBossDeathType(BossDeathType bossDeathType);
    void setBossSpawnType(BossSpawnType bossSpawnType);
    void setKiller(Player killer);
}