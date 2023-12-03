package ru.incrementstudio.incbosses.api.bosses.phases;

import ru.incrementstudio.incbosses.api.AbilityPlugin;
import ru.incrementstudio.incbosses.api.bosses.Boss;
import ru.incrementstudio.incbosses.api.internection.Packet;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

public final class PhaseData {
    private final Phase phase;
    public PhaseData(Phase phase) {
        this.phase = phase;
    }
    public PhaseData(Boss boss, int phaseId) {
        this.phase = new Phase(boss, phaseId);
    }
    public PhaseData(int bossId, int phaseId) {
        this.phase = new Phase(new Boss(bossId), phaseId);
    }
    public String getName() {
        final String[] result = new String[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (String) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                phase.getBoss().getId(),
                phase.getId(),
                Packet.API.PHASE_DATA,
                Packet.API.PhaseData.GET_NAME
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public String getPhaseName() {
        final String[] result = new String[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (String) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                phase.getBoss().getId(),
                phase.getId(),
                Packet.API.PHASE_DATA,
                Packet.API.PhaseData.GET_PHASE_NAME
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
}
