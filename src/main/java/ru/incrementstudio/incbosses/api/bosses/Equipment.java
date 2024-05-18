package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface Equipment {
    /**
     * @return the item in the main hand
     */
    @Nullable
    ItemStack getMainHand();

    /**
     * @return the item in the second hand
     */
    @Nullable
    ItemStack getSecondHand();

    /**
     * @return the item in the helmet slot
     */
    @Nullable
    ItemStack getHelmet();

    /**
     * @return the item in the chestplate slot
     */
    @Nullable
    ItemStack getChestplate();

    /**
     * @return the item in the leggings slot
     */
    @Nullable
    ItemStack getLeggings();

    /**
     * @return the item in the boots slot
     */
    @Nullable
    ItemStack getBoots();

    /**
     * @return {@code true} if the item in the main hand is not equal to {@code null}
     */
    boolean hasMainHand();

    /**
     * @return {@code true} if the item in the second hand is not equal to {@code null}
     */
    boolean hasSecondHand();

    /**
     * @return {@code true} if the item in the helmet slot is not equal to {@code null}
     */
    boolean hasHelmet();

    /**
     * @return {@code true} if the item in the chestplate slot is not equal to {@code null}
     */
    boolean hasChestplate();

    /**
     * @return {@code true} if the item in the leggings slot is not equal to {@code null}
     */
    boolean hasLeggings();

    /**
     * @return {@code true} if the item in the boots slot is not equal to {@code null}
     */
    boolean hasBoots();
}