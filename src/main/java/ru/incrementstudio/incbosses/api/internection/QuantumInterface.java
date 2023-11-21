package ru.incrementstudio.incbosses.api.internection;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import ru.incrementstudio.incapi.Config;
import ru.incrementstudio.incapi.quantum.Quantum;
import ru.incrementstudio.incbosses.api.AbilityExtension;

import java.io.*;
import java.util.function.Consumer;

public class QuantumInterface {
    public static final Consumer<Object[]> DEFAULT_LISTENER = data -> {
        int type = (int) data[0];
        if (type == 0) {
            int bossId = (int) data[1];
            int phaseId = (int) data[2];
            FileConfiguration bossConfig = (FileConfiguration) data[3];
            ConfigurationSection phaseConfig = (ConfigurationSection) data[4];
            int reason = (int) data[5];
            AbilityExtension.getInstance().start(
                    bossId,
                    phaseId,
                    bossConfig,
                    phaseConfig,
                    reason
            );
        } else if (type == 1) {
            int bossId = (int) data[1];
            int reason = (int) data[2];
            AbilityExtension.getInstance().stop(
                    bossId,
                    reason
            );
        }
    };
    private final Quantum quantum;
    public Quantum getQuantum() {
        return quantum;
    }

    public QuantumInterface() throws IOException {
        quantum = new Quantum();
        quantum.setListener(getModuleId(), DEFAULT_LISTENER);
    }

    public void setListener(Consumer<Object[]> listener) {
        quantum.setListener(getModuleId(), listener);
    }

    public void sendAPIPacket(int bossId, int phaseId, int object, int method, Object... data) {
        quantum.send(0, bossId, phaseId, object, method, data);
    }

    public static int getModuleId() {
        Config quantumConfig = AbilityExtension.getConfigManager().getConfig("config");
        if (quantumConfig != null) {
            ConfigurationSection quantum = quantumConfig.get();
            if (quantum.contains("id")) {
                return quantum.getInt("id");
            }
            throw new RuntimeException("В файле 'config.yml' не найдено значение 'id'");
        }
        throw new RuntimeException("Файл 'config.yml' не найден!");
    }
}
