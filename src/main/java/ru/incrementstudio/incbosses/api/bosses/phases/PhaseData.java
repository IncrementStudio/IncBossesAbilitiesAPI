package ru.incrementstudio.incbosses.api.bosses.phases;

import org.bukkit.inventory.ItemStack;
import ru.incrementstudio.incbosses.api.AbilityExtension;
import ru.incrementstudio.incbosses.api.internection.Packet;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhaseData {
    private final Phase phase;
    public PhaseData(Phase phase) {
        this.phase = phase;
    }
    public String getName() {
        final String[] result = new String[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (String) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                phase.getBoss().getId(),
                phase.getId(),
                Packet.API.PHASE_DATA,
                Packet.API.PhaseData.GET_NAME
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public String getPhaseName() {
        final String[] result = new String[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (String) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                phase.getBoss().getId(),
                phase.getId(),
                Packet.API.PHASE_DATA,
                Packet.API.PhaseData.GET_PHASE_NAME
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Map<String, List<String>> getStartActions() {
        final Map<String, List<String>>[] result = new HashMap[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (Map<String, List<String>>) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                phase.getBoss().getId(),
                phase.getId(),
                Packet.API.PHASE_DATA,
                Packet.API.PhaseData.GET_START_ACTIONS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Map<String, List<String>> getAreaPlayersActions() {
        final Map<String, List<String>>[] result = new HashMap[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (Map<String, List<String>>) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                phase.getBoss().getId(),
                phase.getId(),
                Packet.API.PHASE_DATA,
                Packet.API.PhaseData.GET_AREA_PLAYERS_ACTIONS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Map<String, List<String>> getFightersActions() {
        final Map<String, List<String>>[] result = new HashMap[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (Map<String, List<String>>) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                phase.getBoss().getId(),
                phase.getId(),
                Packet.API.PHASE_DATA,
                Packet.API.PhaseData.GET_FIGHTERS_ACTIONS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public double getPlayersActionsAreaRange() {
        final double[] result = new double[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (double) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                phase.getBoss().getId(),
                phase.getId(),
                Packet.API.PHASE_DATA,
                Packet.API.PhaseData.GET_PLAYERS_ACTIONS_AREA_RANGE
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public boolean isFlagChatStartNotification() {
        final boolean[] result = new boolean[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (boolean) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                phase.getBoss().getId(),
                phase.getId(),
                Packet.API.PHASE_DATA,
                Packet.API.PhaseData.IS_FLAG_CHAT_START_NOTIFICATION
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public boolean isFlagClearEffectsOnEnd() {
        final boolean[] result = new boolean[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (boolean) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                phase.getBoss().getId(),
                phase.getId(),
                Packet.API.PHASE_DATA,
                Packet.API.PhaseData.IS_FLAG_CLEAR_EFFECTS_ON_END
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
}
