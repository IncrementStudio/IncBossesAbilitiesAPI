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
    private final Boss boss;
    public Boss getBoss() {
        return boss;
    }
    private final int id;
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
        final double[] result = new double[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (double) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                boss.getId(),
                id,
                Packet.API.PHASE,
                Packet.API.Phase.GET_LIFETIME
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public void start() {
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                boss.getId(),
                id,
                Packet.API.PHASE,
                Packet.API.Phase.START
        );
    }
    public void stop() {
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                boss.getId(),
                id,
                Packet.API.PHASE,
                Packet.API.Phase.STOP
        );
    }
}
