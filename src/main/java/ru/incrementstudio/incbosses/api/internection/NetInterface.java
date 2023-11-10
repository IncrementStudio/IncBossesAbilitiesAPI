package ru.incrementstudio.incbosses.api.internection;

import org.bukkit.configuration.ConfigurationSection;
import ru.incrementstudio.incapi.Config;
import ru.incrementstudio.incapi.internection.InternectionDouble;
import ru.incrementstudio.incbosses.api.AbilityExtension;

import java.io.*;

public class NetInterface {
    private final InternectionDouble netInterface;
    public InternectionDouble getInterface() {
        return netInterface;
    }

    public NetInterface() throws IOException {
        netInterface = new InternectionDouble(getServerPort(), getClientPort()) {
            @Override
            public void dataHandler(ConnectionHandler handler, byte[] data) {
                try {
                    ByteArrayInputStream byteIn = new ByteArrayInputStream(data);
                    DataInputStream dataIn = new DataInputStream(byteIn);
                    int type = dataIn.readInt();
                    if (type == 0) {
                        int serviceType = dataIn.readInt();
                        if (serviceType == 1) {
                            int bossId = dataIn.readInt();
                            int phaseId = dataIn.readInt();
                            String configFile = dataIn.readUTF();
                            String configPath = dataIn.readUTF();
                            AbilityExtension.getInstance().start(
                                    bossId,
                                    phaseId,
                                    new Config(AbilityExtension.getInstance(), configFile).get().getConfigurationSection(configPath)
                            );
                        } else if (serviceType == 2) {
                            int bossId = dataIn.readInt();
                            AbilityExtension.getInstance().stop(
                                    bossId
                            );
                            handler.close();
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        netInterface.getClient().bind();
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        DataOutputStream dataOut = new DataOutputStream(byteOut);
        dataOut.writeUTF(AbilityExtension.getInstance().getAbilityName());
        dataOut.writeInt(getServerPort());
        dataOut.flush();
        sendServicePacket(Packet.Service.REGISTRATION, byteOut.toByteArray());
    }

    public void sendServicePacket(int type, byte[] data) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(bytes);
        out.writeInt(0);
        out.writeInt(type);
        out.write(data);
        out.flush();
        netInterface.getClient().send(bytes.toByteArray());
    }

    public void sendAPIPacket(int bossId, int phaseId, int object, int method, byte[] data) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(bytes);
        out.writeInt(1);
        out.writeInt(bossId);
        out.writeInt(phaseId);
        out.writeInt(object);
        out.writeInt(method);
        out.write(data);
        out.flush();
        netInterface.getClient().send(bytes.toByteArray());
    }

    private int getServerPort() {
        ConfigurationSection internection = AbilityExtension.getConfigManager().getConfig("internection").get();
        if (internection.contains("module")) {
            return internection.getInt("module");
        }
        throw new RuntimeException("В файле 'internection.yml' не найдено значение 'module'");
    }

    private int getClientPort() {
        ConfigurationSection internection = AbilityExtension.getConfigManager().getConfig("internection").get();
        if (internection.contains("main-plugin")) {
            return internection.getInt("main-plugin");
        }
        throw new RuntimeException("В файле 'internection.yml' не найдено значение 'main-plugin'");
    }
}
