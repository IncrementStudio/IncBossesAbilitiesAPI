package ru.incrementstudio.incbosses.api.internection;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import ru.incrementstudio.incapi.quantum.Quantum;
import ru.incrementstudio.incbosses.api.AbilityPlugin;
import ru.incrementstudio.incbosses.api.StartReason;
import ru.incrementstudio.incbosses.api.StopReason;

import java.io.*;
import java.util.function.Consumer;

public final class QuantumInterface {
    public static final Consumer<Object[]> DEFAULT_LISTENER = data -> {
        int type = (int) data[0];
        if (type == 0) {
            int bossId = (int) data[1];
            int phaseId = (int) data[2];
            FileConfiguration bossConfig = (FileConfiguration) data[3];
            ConfigurationSection abilityConfig = (ConfigurationSection) data[4];
            int reason = (int) data[5];
            AbilityPlugin.getInstance().start(
                    bossId,
                    phaseId,
                    bossConfig,
                    abilityConfig,
                    StartReason.of(reason)
            );
        } else if (type == 1) {
            int bossId = (int) data[1];
            int reason = (int) data[2];
            AbilityPlugin.getInstance().stop(
                    bossId,
                    StopReason.of(reason)
            );
        }
    };
    private final Quantum quantum;
    public Quantum getQuantum() {
        return quantum;
    }

    public QuantumInterface() throws IOException {
        quantum = new Quantum();
        quantum.setListener(AbilityPlugin.getID(), DEFAULT_LISTENER);
    }

    public void setListener(Consumer<Object[]> listener) {
        quantum.setListener(AbilityPlugin.getID(), listener);
    }

    public void sendAPIPacket(int bossId, int phaseId, int object, int method, Object... data) {
        quantum.send(0, bossId, phaseId, object, method, data);
    }
}
