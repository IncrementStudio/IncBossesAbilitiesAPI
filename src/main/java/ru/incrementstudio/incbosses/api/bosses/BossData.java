package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import ru.incrementstudio.incbosses.api.bosses.phases.PhaseData;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public final class BossData {
    private final Object bossData;
    public BossData(Object bossData) {
        this.bossData = bossData;
    }

    private Object invoke(String method, Object... params) {
        try {
            return bossData.getClass().getMethod(method, Arrays.stream(params)
                    .map(Object::getClass)
                    .toArray(Class[]::new)
            ).invoke(bossData, params);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ignore) { }
        return null;
    }
    private <T> T notNullOrDefault(T obj, T defaultObj) {
        return obj == null ? defaultObj : obj;
    }

    public String getName() {
        return (String) invoke("getName");
    }
    public String getBossName() {
        return (String) invoke("getBossName");
    }
    public String getDisplayName() {
        return (String) invoke("getDisplayName");
    }
    public EntityType getEntityType() {
        return (EntityType) invoke("getEntityType");
    }
    public double getHealth() {
        return (double) notNullOrDefault(invoke("getHealth"), 0);
    }
    public boolean isGlowing() {
        return (boolean) notNullOrDefault(invoke("isGlowing"), false);
    }
    public boolean isBaby() {
        return (boolean) notNullOrDefault(invoke("isBaby"), false);
    }
    public List<PhaseData> getPhaseDatas() {
        return ((List<Object>) invoke("getPhases")).stream()
                .map(PhaseData::new)
                .collect(Collectors.toList());
    }
    public ItemStack getMainHand() {
        return (ItemStack) invoke("getMainHand");
    }
    public ItemStack getOffHand() {
        return (ItemStack) invoke("getOffHand");
    }
    public ItemStack getHelmet() {
        return (ItemStack) invoke("getHelmet");
    }
    public ItemStack getChestplate() {
        return (ItemStack) invoke("getChestplate");
    }
    public ItemStack getLeggings() {
        return (ItemStack) invoke("getLeggings");
    }
    public ItemStack getBoots() {
        return (ItemStack) invoke("getBoots");
    }
}
