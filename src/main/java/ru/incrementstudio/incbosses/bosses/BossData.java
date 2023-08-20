package ru.incrementstudio.incbosses.bosses;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import ru.incrementstudio.incbosses.bosses.enums.BossDeathType;
import ru.incrementstudio.incbosses.bosses.enums.BossSpawnType;
import ru.incrementstudio.incbosses.bosses.enums.PhaseStartType;
import ru.incrementstudio.incbosses.bosses.phases.PhaseData;

import java.util.List;
import java.util.Map;

public interface BossData {
    BossData newIdentity();
    String getName();
    String getBossName();
    String getDisplayName();
    EntityType getEntityType();
    double getHealth();
    boolean isGlowing();
    boolean isBaby();
    BarColor getBarColor();
    BarStyle getBarStyle();
    List<BarFlag> getBarFlags();
    Map<String, List<String>> getSpawnActions();
    Map<String, List<String>> getDeathActions();
    Map<BossSpawnType, Map<String, List<String>>> getSpawnTypeActions();
    Map<BossDeathType, Map<String, List<String>>> getDeathTypeActions();
    PhaseStartType getStartPhaseType();
    String getStartPhase();
    List<PhaseData> getPhases();
    ItemStack getMainHand();
    ItemStack getOffHand();
    ItemStack getHelmet();
    ItemStack getChestplate();
    ItemStack getLeggings();
    ItemStack getBoots();
    boolean isFlagGiveNaturalEffects();
    List<ConfigurationSection> getDrops();
}
