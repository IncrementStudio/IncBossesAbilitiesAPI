package ru.incrementstudio.incbosses.api.internection;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incapi.internection.InternectionClient;
import ru.incrementstudio.incapi.internection.InternectionDouble;
import ru.incrementstudio.incbosses.api.AbilityExtension;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NetInterface {
    private final InternectionDouble netInterface;
    public InternectionDouble getInterface() {
        return netInterface;
    }

    public NetInterface() throws IOException {
        netInterface = new InternectionDouble(getServerPort(), new InternectionClient(getClientPort()) {
            @Override
            public void dataHandler(byte[] data) {

            }
        }) {
            @Override
            public void dataHandler(Socket socket, byte[] data) {

            }
        };
        netInterface.getClient().bind();
        sendServicePacket(Packet.Service.REGISTRATION, AbilityExtension.getInstance().getAbilityName().getBytes());
    }

    public void sendServicePacket(int type, byte[] data) throws IOException {
        DataOutputStream out = new DataOutputStream(netInterface.getClient().getOutputStream());
        out.writeInt(data.length + 8);
        out.writeInt(0);
        out.writeInt(type);
        out.write(data);
        out.flush();
    }

    public void sendAPIPacket(int bossId, int phaseId, int object, int method, byte[] data) throws IOException {
        DataOutputStream out = new DataOutputStream(netInterface.getClient().getOutputStream());
        out.writeInt(data.length + 20);
        out.writeInt(1);
        out.writeInt(bossId);
        out.writeInt(phaseId);
        out.writeInt(object);
        out.writeInt(method);
        out.write(data);
        out.flush();
    }

    private int getClientPort() {
        ConfigurationSection internection = AbilityExtension.getConfigManager().getConfig("internection").get();
        if (internection.contains("module")) {
            return internection.getInt("module");
        }
        throw new RuntimeException("В файле 'internection.yml' не найдено значение 'module'");
    }

    private int getServerPort() {
        ConfigurationSection internection = AbilityExtension.getConfigManager().getConfig("internection").get();
        if (internection.contains("main-plugin")) {
            return internection.getInt("main-plugin");
        }
        throw new RuntimeException("В файле 'internection.yml' не найдено значение 'main-plugin'");
    }
}
