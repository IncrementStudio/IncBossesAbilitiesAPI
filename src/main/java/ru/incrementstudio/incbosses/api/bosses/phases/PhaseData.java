package ru.incrementstudio.incbosses.api.bosses.phases;

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
    private Phase phase;
    public PhaseData(Phase phase) {
        this.phase = phase;
    }
    public String getName() {
        try {
            final String[] result = new String[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = objectStream.readUTF();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    phase.getBoss().getId(),
                    phase.getId(),
                    Packet.API.PHASE_DATA,
                    Packet.API.PhaseData.GET_NAME,
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
    public String getPhaseName() {
        try {
            final String[] result = new String[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = objectStream.readUTF();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    phase.getBoss().getId(),
                    phase.getId(),
                    Packet.API.PHASE_DATA,
                    Packet.API.PhaseData.GET_PHASE_NAME,
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
    public Map<String, List<String>> getStartActions() {
        try {
            final Map<String, List<String>>[] result = new HashMap[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (Map<String, List<String>>) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    phase.getBoss().getId(),
                    phase.getId(),
                    Packet.API.PHASE_DATA,
                    Packet.API.PhaseData.GET_START_ACTIONS,
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
    public Map<String, List<String>> getAreaPlayersActions() {
        try {
            final Map<String, List<String>>[] result = new HashMap[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (Map<String, List<String>>) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    phase.getBoss().getId(),
                    phase.getId(),
                    Packet.API.PHASE_DATA,
                    Packet.API.PhaseData.GET_AREA_PLAYERS_ACTIONS,
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
    public Map<String, List<String>> getFightersActions() {
        try {
            final Map<String, List<String>>[] result = new HashMap[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (Map<String, List<String>>) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    phase.getBoss().getId(),
                    phase.getId(),
                    Packet.API.PHASE_DATA,
                    Packet.API.PhaseData.GET_FIGHTERS_ACTIONS,
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
    public double getPlayersActionsAreaRange() {
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
                    phase.getBoss().getId(),
                    phase.getId(),
                    Packet.API.PHASE_DATA,
                    Packet.API.PhaseData.GET_PLAYERS_ACTIONS_AREA_RANGE,
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
    public boolean isFlagChatStartNotification() {
        try {
            final boolean[] result = new boolean[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = objectStream.readBoolean();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    phase.getBoss().getId(),
                    phase.getId(),
                    Packet.API.PHASE_DATA,
                    Packet.API.PhaseData.IS_FLAG_CHAT_START_NOTIFICATION,
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
    public boolean isFlagClearEffectsOnEnd() {
        try {
            final boolean[] result = new boolean[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = objectStream.readBoolean();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    phase.getBoss().getId(),
                    phase.getId(),
                    Packet.API.PHASE_DATA,
                    Packet.API.PhaseData.IS_FLAG_CLEAR_EFFECTS_ON_END,
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
}
