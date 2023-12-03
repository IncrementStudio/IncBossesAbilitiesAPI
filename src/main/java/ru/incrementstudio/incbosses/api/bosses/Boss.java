package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.Location;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import ru.incrementstudio.incbosses.api.AbilityPlugin;
import ru.incrementstudio.incbosses.api.bosses.enums.BossDeathType;
import ru.incrementstudio.incbosses.api.bosses.enums.BossSpawnType;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;
import ru.incrementstudio.incbosses.api.internection.Packet;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Boss)
            return ((Boss) obj).getId() == id;
        return false;
    }

    public BossData getData() {
        return new BossData(this);
    }
    public LivingEntity getEntity() {
        final LivingEntity[] result = new LivingEntity[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (LivingEntity) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.GET_ENTITY
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public void kill() {
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.KILL
        );
    }
    public boolean isKilled() {
        final boolean[] result = new boolean[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (boolean) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.IS_KILLED
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Player getKiller() {
        final Player[] result = new Player[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (Player) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.GET_KILLER
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Phase getCurrentPhase() {
        final int[] result = new int[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (int) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.GET_CURRENT_PHASE
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return new Phase(this, result[0]);
    }
    public List<Phase> getPhases() {
        final List<Integer>[] result = new ArrayList[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (List<Integer>) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.GET_PHASES
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0].stream()
                .map(x -> new Phase(this, x))
                .collect(Collectors.toList());
    }
    public void changePhase(Phase phase) {
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.CHANGE_PHASE,
                phase.getId()
        );
    }
    public Map<UUID, Double> getDamageMap() {
        final Map<UUID, Double>[] result = new Map[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (Map<UUID, Double>) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                id,
                0,
                Packet.API.BOSS,
                Packet.API.Boss.GET_DAMAGE_MAP
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public BossDeathType getDeathType() {
            final BossDeathType[] result = new BossDeathType[1];
            AbilityPlugin.getInstance().getQuantumInterface().setListener(
                    data -> result[0] = BossDeathType.getByType((int) data[0])
            );
            AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_DEATH_TYPE
            );
            AbilityPlugin.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return result[0];
    }
    public BossSpawnType getSpawnType() {
            final BossSpawnType[] result = new BossSpawnType[1];
            AbilityPlugin.getInstance().getQuantumInterface().setListener(
                    data -> result[0] = BossSpawnType.getByType((int) data[0])
            );
            AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_SPAWN_TYPE
            );
            AbilityPlugin.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return result[0];
    }
}