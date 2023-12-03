package ru.incrementstudio.incbosses.api.bosses.phases;

import ru.incrementstudio.incbosses.api.AbilityPlugin;
import ru.incrementstudio.incbosses.api.internection.Packet;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

public class PhaseData {
    private final Phase phase;
    public PhaseData(Phase phase) {
        this.phase = phase;
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
