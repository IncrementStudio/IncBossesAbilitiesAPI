package ru.incrementstudio.incbosses.api.bosses.phases;

import ru.incrementstudio.incbosses.api.AbilityPlugin;
import ru.incrementstudio.incbosses.api.bosses.Boss;
import ru.incrementstudio.incbosses.api.internection.Packet;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

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
    public Phase(int bossId, int id) {
        this.boss = new Boss(bossId);
        this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Phase)
            return boss.equals(((Phase) obj).boss) && ((Phase) obj).getId() == id;
        return false;
    }
    public PhaseData getData() {
        return new PhaseData(this);
    }
    public double getLifetime() {
        final double[] result = new double[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (double) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                boss.getId(),
                id,
                Packet.API.PHASE,
                Packet.API.Phase.GET_LIFETIME
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public void start() {
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                boss.getId(),
                id,
                Packet.API.PHASE,
                Packet.API.Phase.START
        );
    }
    public void stop() {
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                boss.getId(),
                id,
                Packet.API.PHASE,
                Packet.API.Phase.STOP
        );
    }
}
