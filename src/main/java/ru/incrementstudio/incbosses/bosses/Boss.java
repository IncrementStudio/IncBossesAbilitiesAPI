package ru.incrementstudio.incbosses.bosses;

import org.bukkit.Location;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import ru.incrementstudio.incbosses.bosses.enums.BossDeathType;
import ru.incrementstudio.incbosses.bosses.enums.BossSpawnType;
import ru.incrementstudio.incbosses.bosses.phases.Phase;

import java.util.*;

public class Boss {
    public void bossActions(Map<String, List<String>> actions) { }
    public void playersActions(Map<String, List<String>> actions, List<Player> players) { }
    public String applyPlaceholders(String string, String phaseName) { return null; }
    public void setPhases() { }
    public Phase getPhaseByName(String name) { return null; }
    public void changePhase(String name) { }
    public void applyPhaseData(Phase phase) { }
    public void spawn(Location location) { }
    public void sendDeathMessage() { }
    public void kill() { }

    public BossData getData() { return null; }
    public LivingEntity getEntity() { return null; }
    public double getNormalizedHealth() { return 0; }
    public HashMap<UUID, Double> getDamageMap() { return null; }
    public boolean isKilled() { return false; }
    public Player getKiller() { return null; }
    public BossDeathType getBossDeathType() { return null; }
    public BossSpawnType getBossSpawnType() { return null; }
    public BossBar getBossBar() { return null; }
    public Phase getCurrentPhase() { return null; }

    public void setBossDeathType(BossDeathType bossDeathType) { }
    public void setBossSpawnType(BossSpawnType bossSpawnType) { }
    public void setKiller(Player killer) { }
}