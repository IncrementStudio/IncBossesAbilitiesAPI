package ru.incrementstudio.incbosses.api.bosses.phases;

import ru.incrementstudio.incbosses.api.AbilityExtension;
import ru.incrementstudio.incbosses.api.bosses.Boss;
import ru.incrementstudio.incbosses.api.bosses.enums.BossDeathType;
import ru.incrementstudio.incbosses.api.internection.Packet;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Phase {
    private Boss boss;
    public Boss getBoss() {
        return boss;
    }
    private int id;
    public int getId() {
        return id;
    }
    public Phase(Boss boss, int id) {
        this.boss = boss;
        this.id = id;
    }
    public PhaseData getData() {
        return new PhaseData(this);
    }
    public double getLifetime() {
        try {
            final double[] result = new double[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = objectStream.readDouble();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    boss.getId(),
                    id,
                    Packet.API.PHASE,
                    Packet.API.Phase.GET_LIFETIME,
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
    public void start() {
        try {
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    boss.getId(),
                    id,
                    Packet.API.PHASE,
                    Packet.API.Phase.START,
                    new byte[0]
            );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void stop() {
        try {
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    boss.getId(),
                    id,
                    Packet.API.PHASE,
                    Packet.API.Phase.STOP,
                    new byte[0]
            );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
