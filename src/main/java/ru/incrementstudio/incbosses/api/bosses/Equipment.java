package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.inventory.ItemStack;

public interface Equipment {
    ItemStack getMainHand();
    ItemStack getOffHand();
    ItemStack getHelmet();
    ItemStack getChestplate();
    ItemStack getLeggings();
    ItemStack getBoots();
    boolean hasMainHand();
    boolean hasOffHand();
    boolean hasHelmet();
    boolean hasChestplate();
    boolean hasLeggings();
    boolean hasBoots();
}
