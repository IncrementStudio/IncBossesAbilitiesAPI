package ru.incrementstudio.incbosses.api.internection;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incapi.Config;
import ru.incrementstudio.incapi.quantum.Quantum;
import ru.incrementstudio.incbosses.api.AbilityExtension;

import java.io.*;
import java.net.Socket;
import java.util.function.Consumer;

public class QuantumInterface {
    public static final Consumer<Object[]> DEFAULT_LISTENER = data -> {
        int type = (int) data[0];
        if (type == 0) {
            int bossId = (int) data[1];
            int phaseId = (int) data[2];
            String configFile = (String) data[3];
            String configPath = (String) data[4];
            AbilityExtension.getInstance().start(
                    bossId,
                    phaseId,
                    new Config(AbilityExtension.getInstance(), configFile).get().getConfigurationSection(configPath)
            );
        } else if (type == 1) {
            int bossId = (int) data[1];
            AbilityExtension.getInstance().stop(
                    bossId
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
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        DataOutputStream dataOut = new DataOutputStream(byteOut);
        dataOut.writeInt(getModuleId());
        dataOut.writeUTF(AbilityExtension.getInstance().getAbilityName());
        dataOut.writeUTF(AbilityExtension.getInstance().getName());
        dataOut.flush();
        Socket registration = new Socket("localhost", getIncBossesPort());
        registration.getOutputStream().write(byteOut.toByteArray());
    }

    public void setListener(Consumer<Object[]> listener) {
        quantum.setListener(getModuleId(), listener);
    }

    public void sendAPIPacket(int bossId, int phaseId, int object, int method, Object... data) {
        quantum.send(getIncBossesId(), bossId, phaseId, object, method, data);
    }

    private int getModuleId() {
        ConfigurationSection internection = AbilityExtension.getConfigManager().getConfig("quantum").get();
        if (internection.contains("id")) {
            return internection.getInt("id");
        }
        throw new RuntimeException("В файле 'quantum.yml' не найдено значение 'id'");
    }

    private int getIncBossesId() {
        ConfigurationSection internection = AbilityExtension.getConfigManager().getConfig("quantum").get();
        if (internection.contains("incbosses")) {
            return internection.getInt("incbosses");
        }
        throw new RuntimeException("В файле 'quantum.yml' не найдено значение 'incbosses'");
    }

    private int getIncBossesPort() {
        ConfigurationSection internection = AbilityExtension.getConfigManager().getConfig("quantum").get();
        if (internection.contains("incbosses-port")) {
            return internection.getInt("incbosses-port");
        }
        throw new RuntimeException("В файле 'quantum.yml' не найдено значение 'incbosses-port'");
    }
}
