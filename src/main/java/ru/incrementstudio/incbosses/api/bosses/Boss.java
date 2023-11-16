package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.Location;
import org.bukkit.boss.BossBar;
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

public class Boss {
    private int id;
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
        try {
            final LivingEntity[] result = new LivingEntity[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (LivingEntity) AbilityExtension.getInstance().getServer().getEntity((UUID) objectStream.readObject());
                        } catch (ClassNotFoundException | IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_ENTITY,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return result[0];
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void kill() {
        try {
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.KILL,
                    new byte[0]
            );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void spawn(Location location) {
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bytes);
            out.writeObject(location);
            out.flush();

            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.SPAWN,
                    bytes.toByteArray()
            );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public boolean isKilled() {
        try {
            final Boolean[] result = new Boolean[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        try (DataInputStream dataIn = new DataInputStream(new ByteArrayInputStream(bytes))) {
                            result[0] = dataIn.readBoolean();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.IS_KILLED,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return result[0];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Player getKiller() {
        try {
            final Player[] result = new Player[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (Player) AbilityExtension.getInstance().getServer().getEntity((UUID) objectStream.readObject());
                        } catch (ClassNotFoundException | IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_KILLER,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return result[0];
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public Phase getCurrentPhase() {
        try {
            final Integer[] result = new Integer[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = objectStream.readInt();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_CURRENT_PHASE,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return new Phase(this, result[0]);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public List<Phase> getPhases() {
        try {
            final List<Map.Entry<Integer, Integer>>[] result = new ArrayList[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (List<Map.Entry<Integer, Integer>>) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_PHASES,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            List<Phase> trueResult = new ArrayList<>();
            result[0].forEach(x -> trueResult.add(new Phase(new Boss(x.getKey()), x.getValue())));
            return trueResult;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void changePhase(Phase phase) {
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bytes);
            out.writeInt(phase.getId());
            out.flush();

            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.CHANGE_PHASE,
                    bytes.toByteArray()
            );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void executeBossActions(Map<String, List<String>> actions) {
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bytes);
            out.writeObject(actions);
            out.flush();

            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.EXECUTE_BOSS_ACTIONS,
                    bytes.toByteArray()
            );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void executePlayersActions(Map<String, List<String>> actions, List<Player> players) {
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bytes);
            out.writeObject(actions);
            out.writeObject(players);
            out.flush();

            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.EXECUTE_PLAYERS_ACTIONS,
                    bytes.toByteArray()
            );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public BossBar getBossBar() {
        try {
            final BossBar[] result = new BossBar[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (BossBar) objectStream.readObject();
                        } catch (ClassNotFoundException | IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_BOSS_BAR,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return result[0];
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public Map<UUID, Double> getDamageMap() {
        try {
            final HashMap<UUID, Double>[] result = new HashMap[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (HashMap<UUID, Double>) objectStream.readObject();
                        } catch (ClassNotFoundException | IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_DAMAGE_MAP,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return result[0];
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public BossDeathType getDeathType() {
        try {
            final int[] result = new int[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = objectStream.readInt();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_DEATH_TYPE,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return BossDeathType.getByType(result[0]);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public BossSpawnType getSpawnType() {
        try {
            final int[] result = new int[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = objectStream.readInt();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_SPAWN_TYPE,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            return BossSpawnType.getByType(result[0]);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}