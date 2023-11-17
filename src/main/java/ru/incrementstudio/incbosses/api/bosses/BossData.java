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
    public String getName() {
        final String[] result = new String[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (String) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_NAME
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public String getBossName() {
        final String[] result = new String[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (String) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_BOSS_NAME
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public String getDisplayName() {
        final String[] result = new String[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (String) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_DISPLAY_NAME
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public EntityType getEntityType() {
        final EntityType[] result = new EntityType[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (EntityType) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_ENTITY_TYPE
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public double getHealth() {
        final double[] result = new double[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (double) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_HEALTH
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public boolean isGlowing() {
        final boolean[] result = new boolean[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (boolean) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.IS_GLOWING
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public boolean isBaby() {
        final boolean[] result = new boolean[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (boolean) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.IS_BABY
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public BarColor getBarColor() {
        final BarColor[] result = new BarColor[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (BarColor) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_BAR_COLOR
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public BarStyle getBarStyle() {
        final BarStyle[] result = new BarStyle[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (BarStyle) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_BAR_STYLE
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public List<BarFlag> getBarFlags() {
        final List<BarFlag>[] result = new ArrayList[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (List<BarFlag>) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_BAR_FLAGS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Map<String, List<String>> getSpawnActions() {
        final Map<String, List<String>>[] result = new HashMap[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (Map<String, List<String>>) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_SPAWN_ACTIONS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Map<String, List<String>> getDeathActions() {
        final Map<String, List<String>>[] result = new HashMap[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (Map<String, List<String>>) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_DEATH_ACTIONS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Map<BossSpawnType, Map<String, List<String>>> getSpawnTypeActions() {
        final Map<BossSpawnType, Map<String, List<String>>>[] result = new HashMap[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (Map<BossSpawnType, Map<String, List<String>>>) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_SPAWN_TYPE_ACTIONS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public Map<BossDeathType, Map<String, List<String>>> getDeathTypeActions() {
        final Map<BossDeathType, Map<String, List<String>>>[] result = new HashMap[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (Map<BossDeathType, Map<String, List<String>>>) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_DEATH_TYPE_ACTIONS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public List<PhaseData> getPhaseDatas() {
        final List<Integer>[] result = new ArrayList[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (List<Integer>) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_PHASE_DATAS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0].stream()
                .map(x -> new PhaseData(new Phase(new Boss(bossId), x)))
                .collect(Collectors.toList());
    }
    public ItemStack getMainHand() {
        final ItemStack[] result = new ItemStack[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_MAIN_HAND
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public ItemStack getOffHand() {
        final ItemStack[] result = new ItemStack[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_OFF_HAND
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public ItemStack getHelmet() {
        final ItemStack[] result = new ItemStack[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_HELMET
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public ItemStack getChestplate() {
        final ItemStack[] result = new ItemStack[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_CHESTPLATE
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public ItemStack getLeggings() {
        final ItemStack[] result = new ItemStack[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_LEGGINGS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public ItemStack getBoots() {
        final ItemStack[] result = new ItemStack[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (ItemStack) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.GET_BOOTS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
    public boolean isFlagGiveNaturalEffects() {
        final boolean[] result = new boolean[1];
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                data -> result[0] = (boolean) data[0]
        );
        AbilityExtension.getInstance().getQuantumInterface().sendAPIPacket(
                bossId,
                0,
                Packet.API.BOSS_DATA,
                Packet.API.BossData.IS_FLAG_GIVE_NATURAL_EFFECTS
        );
        AbilityExtension.getInstance().getQuantumInterface().setListener(
                QuantumInterface.DEFAULT_LISTENER
        );
        return result[0];
    }
}
