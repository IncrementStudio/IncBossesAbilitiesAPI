package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.Location;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import ru.incrementstudio.incbosses.api.AbilityExtension;
import ru.incrementstudio.incbosses.api.bosses.enums.BossDeathType;
import ru.incrementstudio.incbosses.api.bosses.enums.BossSpawnType;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;
import ru.incrementstudio.incbosses.api.internection.Packet;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boss {
    private final int id;
    public int getId() {
        return id;
    }
    public Boss(int id) {
        this.id = id;
    }
    public BossData getData() {
        return new BossData(this);
    }
    public LivingEntity getEntity() {
        final LivingEntity[] result = new LivingEntity[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (LivingEntity) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.GET_ENTITY
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public void kill() {
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.KILL
        );
    }
    public void spawn(Location location) {
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.SPAWN,
                location
        );
    }
    public boolean isKilled() {
        final boolean[] result = new boolean[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (boolean) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.IS_KILLED
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Player getKiller() {
        final Player[] result = new Player[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (Player) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.GET_KILLER
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Phase getCurrentPhase() {
        final int[] result = new int[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (int) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.GET_CURRENT_PHASE
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return new Phase(this, result[0]);
    }
    public List<Phase> getPhases() {
        final List<Integer>[] result = new ArrayList[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (List<Integer>) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.GET_PHASES
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0].stream()
                .map(x -> new Phase(this, x))
                .collect(Collectors.toList());
    }
    public void changePhase(Phase phase) {
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.CHANGE_PHASE,
                phase.getId()
        );
    }
    public void executeBossActions(Map<String, List<String>> actions) {
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.EXECUTE_BOSS_ACTIONS,
                actions
        );
    }
    public void executePlayersActions(Map<String, List<String>> actions, List<Player> players) {
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.EXECUTE_PLAYERS_ACTIONS,
                actions,
                players
        );
    }
    public BossBar getBossBar() {
        final BossBar[] result = new BossBar[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (BossBar) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.GET_BOSS_BAR
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Map<UUID, Double> getDamageMap() {
        final Map<UUID, Double>[] result = new Map[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (Map<UUID, Double>) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.GET_DAMAGE_MAP
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public BossDeathType getDeathType() {
            final BossDeathType[] result = new BossDeathType[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    data -> result[0] = BossDeathType.getByType((int) data[0])
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_DEATH_TYPE
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return result[0];
    }
    public BossSpawnType getSpawnType() {
            final BossSpawnType[] result = new BossSpawnType[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    data -> result[0] = BossSpawnType.getByType((int) data[0])
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_SPAWN_TYPE
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return result[0];
    }
}