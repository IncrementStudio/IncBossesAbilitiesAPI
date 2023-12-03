package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import ru.incrementstudio.incbosses.api.AbilityPlugin;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;
import ru.incrementstudio.incbosses.api.bosses.phases.PhaseData;
import ru.incrementstudio.incbosses.api.internection.Packet;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

import java.util.*;
import java.util.stream.Collectors;

public class BossData {
    private final int bossId;
    public BossData(Boss boss) {
        bossId = boss.getId();
    }
    public BossData(int bossId) {
        this.bossId = bossId;
    }
    public final String getName() {
        final String[] result = new String[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (String) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_NAME
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final String getBossName() {
        final String[] result = new String[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (String) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_BOSS_NAME
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final String getDisplayName() {
        final String[] result = new String[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (String) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_DISPLAY_NAME
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final EntityType getEntityType() {
        final EntityType[] result = new EntityType[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (EntityType) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_ENTITY_TYPE
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final double getHealth() {
        final double[] result = new double[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (double) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_HEALTH
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final boolean isGlowing() {
        final boolean[] result = new boolean[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (boolean) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.IS_GLOWING
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final boolean isBaby() {
        final boolean[] result = new boolean[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (boolean) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.IS_BABY
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final List<PhaseData> getPhaseDatas() {
        final List<Integer>[] result = new ArrayList[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (List<Integer>) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_PHASE_DATAS
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0].stream()
                .map(x -> new PhaseData(new Phase(new Boss(bossId), x)))
                .collect(Collectors.toList());
    }
    public final ItemStack getMainHand() {
        final ItemStack[] result = new ItemStack[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_MAIN_HAND
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final ItemStack getOffHand() {
        final ItemStack[] result = new ItemStack[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_OFF_HAND
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final ItemStack getHelmet() {
        final ItemStack[] result = new ItemStack[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_HELMET
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final ItemStack getChestplate() {
        final ItemStack[] result = new ItemStack[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_CHESTPLATE
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final ItemStack getLeggings() {
        final ItemStack[] result = new ItemStack[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_LEGGINGS
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public final ItemStack getBoots() {
        final ItemStack[] result = new ItemStack[1];
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityPlugin.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_BOOTS
        );
        AbilityPlugin.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
}
