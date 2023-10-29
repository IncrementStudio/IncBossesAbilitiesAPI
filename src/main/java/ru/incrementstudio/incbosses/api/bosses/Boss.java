package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.Location;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import ru.incrementstudio.incbosses.api.AbilityExtension;
import ru.incrementstudio.incbosses.api.bosses.enums.BossDeathType;
import ru.incrementstudio.incbosses.api.bosses.enums.BossSpawnType;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;
import ru.incrementstudio.incbosses.api.internection.OneTimeHandler;
import ru.incrementstudio.incbosses.api.internection.Packet;

import java.io.*;
import java.util.*;

public class Boss {
    private int id;
    public Boss(int id) {
        this.id = id;
    }

    public BossData getData() {
        return new BossData();
    }
    public LivingEntity getEntity() {
        try {
            AbilityExtension.getInstance().getNetInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.GET_ENTITY,
                    new byte[0]
            );
            final LivingEntity[] result = new LivingEntity[1];
            new OneTimeHandler(AbilityExtension.getInstance().getNetInterface().getInterface().getClient().getInputStream()) {
                @Override
                public void dataHandler(byte[] data) {
                    ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
                    try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                        result[0] = (LivingEntity) objectStream.readObject();
                    } catch (ClassNotFoundException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            return result[0];
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void kill() {
        try {
            AbilityExtension.getInstance().getNetInterface().sendAPIPacket(
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

            AbilityExtension.getInstance().getNetInterface().sendAPIPacket(
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
            AbilityExtension.getInstance().getNetInterface().sendAPIPacket(
                    id,
                    0,
                    Packet.API.BOSS,
                    Packet.API.Boss.IS_KILLED,
                    new byte[0]
            );
            final boolean[] result = new boolean[1];
            new OneTimeHandler(AbilityExtension.getInstance().getNetInterface().getInterface().getClient().getInputStream()) {
                @Override
                public void dataHandler(byte[] data) {
                    try (DataInputStream dataIn = new DataInputStream(new ByteArrayInputStream(data))) {
                        result[0] = dataIn.readBoolean();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            return result[0];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Player getKiller() { return null; }
    public void setKiller(Player killer) { }
    public Phase getPhaseByName(String name) { return null; }
    public Phase getCurrentPhase() { return null; }
    public void changePhase(String name) { }
    public void applyPhaseData(Phase phase) { }
    public void bossActions(Map<String, List<String>> actions) { }
    public void playersActions(Map<String, List<String>> actions, List<Player> players) { }
    public BossBar getBossBar() { return null; }
    public void sendDeathMessage() { }
    public String applyPlaceholders(String string, String phaseName) { return null; }
    public HashMap<UUID, Double> getDamageMap() { return null; }
    public double getNormalizedHealth() { return 0; }
    public BossDeathType getBossDeathType() { return null; }
    public void setBossDeathType(BossDeathType bossDeathType) { }
    public BossSpawnType getBossSpawnType() { return null; }
    public void setBossSpawnType(BossSpawnType bossSpawnType) { }
}