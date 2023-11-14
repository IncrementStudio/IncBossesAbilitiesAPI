package ru.incrementstudio.incbosses.api.internection;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incapi.Config;
import ru.incrementstudio.incapi.quantum.Quantum;
import ru.incrementstudio.incbosses.api.AbilityExtension;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.function.Predicate;

public class QuantumInterface {
    public static final Predicate<byte[]> DEFAULT_LISTENER = bytes -> {
        try {
            ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
            DataInputStream dataIn = new DataInputStream(byteIn);
            int type = dataIn.readInt();
            if (type == 0) {
                int bossId = dataIn.readInt();
                int phaseId = dataIn.readInt();
                String configFile = dataIn.readUTF();
                String configPath = dataIn.readUTF();
                AbilityExtension.getInstance().start(
                        bossId,
                        phaseId,
                        new Config(AbilityExtension.getInstance(), configFile).get().getConfigurationSection(configPath)
                );
            } else if (type == 1) {
                int bossId = dataIn.readInt();
                AbilityExtension.getInstance().stop(
                        bossId
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    };
    private Quantum quantum;
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

    public void setListener(Predicate<byte[]> listener) {
        quantum.setListener(getModuleId(), listener);
    }

    public void sendAPIPacket(int bossId, int phaseId, int object, int method, byte[] data) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(bytes);
        out.writeInt(bossId);
        out.writeInt(phaseId);
        out.writeInt(object);
        out.writeInt(method);
        out.write(data);
        out.flush();
        quantum.send(getIncBossesId(), bytes.toByteArray());
    }

    private int getModuleId() {
        ConfigurationSection internection = AbilityExtension.getConfigManager().getConfig("quantum").get();
        if (internection.contains("module")) {
            return internection.getInt("module");
        }
        throw new RuntimeException("В файле 'quantum.yml' не найдено значение 'module'");
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
