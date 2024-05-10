package ru.incrementstudio.incbosses.api;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

// @formatter:off
public interface BossData {
    String getName();
    String getBossName();
    String getDisplayName();
    EntityType getEntityType();
    double getHealth();
    boolean isGlowing();
    boolean isBaby();
    List<PhaseData> getPhaseDatas();
    ItemStack getMainHand();
    ItemStack getOffHand();
    ItemStack getHelmet();
    ItemStack getChestplate();
    ItemStack getLeggings();
    ItemStack getBoots();
}