package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import ru.incrementstudio.incbosses.api.AbilityExtension;
import ru.incrementstudio.incbosses.api.bosses.enums.BossDeathType;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;
import ru.incrementstudio.incbosses.api.bosses.phases.PhaseData;
import ru.incrementstudio.incbosses.api.bosses.enums.BossSpawnType;
import ru.incrementstudio.incbosses.api.internection.Packet;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class BossData {
    private int bossId;
    public BossData(Boss boss) {
        bossId = boss.getId();
    }
    public BossData(int bossId) {
        this.bossId = bossId;
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
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_NAME,
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
    public String getBossName() {
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
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_BOSS_NAME,
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
    public String getDisplayName() {
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
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_DISPLAY_NAME,
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
    public EntityType getEntityType() {
        try {
            final EntityType[] result = new EntityType[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (EntityType) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_ENTITY_TYPE,
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
    public double getHealth() {
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
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_HEALTH,
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
    public boolean isGlowing() {
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
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.IS_GLOWING,
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
    public boolean isBaby() {
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
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.IS_BABY,
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
    public BarColor getBarColor() {
        try {
            final BarColor[] result = new BarColor[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (BarColor) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_BAR_COLOR,
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
    public BarStyle getBarStyle() {
        try {
            final BarStyle[] result = new BarStyle[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (BarStyle) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_BAR_STYLE,
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
    public List<BarFlag> getBarFlags() {
        try {
            final List<BarFlag>[] result = new ArrayList[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (List<BarFlag>) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_BAR_FLAGS,
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
    public Map<String, List<String>> getSpawnActions() {
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
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_SPAWN_ACTIONS,
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
    public Map<String, List<String>> getDeathActions() {
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
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_DEATH_ACTIONS,
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
    public Map<BossSpawnType, Map<String, List<String>>> getSpawnTypeActions() {
        try {
            final Map<Integer, Map<String, List<String>>>[] result = new HashMap[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (Map<Integer, Map<String, List<String>>>) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_SPAWN_TYPE_ACTIONS,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            Map<BossSpawnType, Map<String, List<String>>> trueResult = new HashMap<>();
            result[0].forEach((k, v) -> trueResult.put(BossSpawnType.getByType(k), v));
            return trueResult;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public Map<BossDeathType, Map<String, List<String>>> getDeathTypeActions() {
        try {
            final Map<Integer, Map<String, List<String>>>[] result = new HashMap[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (Map<Integer, Map<String, List<String>>>) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_DEATH_TYPE_ACTIONS,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            Map<BossDeathType, Map<String, List<String>>> trueResult = new HashMap<>();
            result[0].forEach((k, v) -> trueResult.put(BossDeathType.getByType(k), v));
            return trueResult;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public List<PhaseData> getPhaseDatas() {
        try {
            final List<Integer>[] result = new ArrayList[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (List<Integer>) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_PHASE_DATAS,
                    new byte[0]
            );
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    QuantumInterface.DEFAULT_LISTENER
            );
            List<PhaseData> trueResult = new ArrayList<>();
            result[0].forEach(x -> trueResult.add(new PhaseData(new Phase(new Boss(bossId), x))));
            return trueResult;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public ItemStack getMainHand() {
        try {
            final ItemStack[] result = new ItemStack[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (ItemStack) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_MAIN_HAND,
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
    public ItemStack getOffHand() {
        try {
            final ItemStack[] result = new ItemStack[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (ItemStack) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_OFF_HAND,
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
    public ItemStack getHelmet() {
        try {
            final ItemStack[] result = new ItemStack[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (ItemStack) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_HELMET,
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
    public ItemStack getChestplate() {
        try {
            final ItemStack[] result = new ItemStack[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (ItemStack) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_CHESTPLATE,
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
    public ItemStack getLeggings() {
        try {
            final ItemStack[] result = new ItemStack[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (ItemStack) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_LEGGINGS,
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
    public ItemStack getBoots() {
        try {
            final ItemStack[] result = new ItemStack[1];
            AbilityExtension.getInstance().getQuantumInterface().setListener(
                    bytes -> {
                        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
                        try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
                            result[0] = (ItemStack) objectStream.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        return false;
                    }
            );
            AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.GET_BOOTS,
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
    public boolean isFlagGiveNaturalEffects() {
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
                    bossId,
                    0,
                    Packet.API.BOSS_DATA,
                    Packet.API.BossData.IS_FLAG_GIVE_NATURAL_EFFECTS,
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
