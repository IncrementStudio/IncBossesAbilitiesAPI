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

public class BossData {
    public BossData(String name) { }
    public BossData newIdentity() { return null; }
    public String getName() { return null; }
    public String getBossName() { return null; }
    public String getDisplayName() { return null; }
    public EntityType getEntityType() { return null; }
    public double getHealth() { return 0; }
    public boolean isGlowing() { return false; }
    public boolean isBaby() { return false; }
    public BarColor getBarColor() { return null; }
    public BarStyle getBarStyle() { return null; }
    public List<BarFlag> getBarFlags() { return null; }
    public Map<String, List<String>> getSpawnActions() { return null; }
    public Map<String, List<String>> getDeathActions() { return null; }
    public Map<BossSpawnType, Map<String, List<String>>> getSpawnTypeActions() { return null; }
    public Map<BossDeathType, Map<String, List<String>>> getDeathTypeActions() { return null; }
    public PhaseStartType getStartPhaseType() { return null; }
    public String getStartPhase() { return null; }
    public List<PhaseData> getPhases() { return null; }
    public ItemStack getMainHand() { return null; }
    public ItemStack getOffHand() { return null; }
    public ItemStack getHelmet() { return null; }
    public ItemStack getChestplate() { return null; }
    public ItemStack getLeggings() { return null; }
    public ItemStack getBoots() { return null; }
    public boolean isFlagGiveNaturalEffects() { return false; }
    public List<ConfigurationSection> getDrops() { return null; }
}
