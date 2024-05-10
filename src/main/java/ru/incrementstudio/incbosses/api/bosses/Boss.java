package ru.incrementstudio.incbosses.api.bosses;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import ru.incrementstudio.incbosses.api.AbilityPlugin;
import ru.incrementstudio.incbosses.api.bosses.enums.BossDeathType;
import ru.incrementstudio.incbosses.api.bosses.enums.BossSpawnType;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class Boss {
    private final Object boss;
    public Boss(Object boss) {
        this.boss = boss;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Boss)
            return ((Boss) obj).getId() == getId();
        return false;
    }

    private Object invoke(String method, Object... params) {
        try {
            return boss.getClass().getMethod(method, Arrays.stream(params)
                    .map(Object::getClass)
                    .toArray(Class[]::new)
            ).invoke(boss, params);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ignore) { }
        return null;
    }
    private <T> T notNullOrDefault(T obj, T defaultObj) {
        return obj == null ? defaultObj : obj;
    }

    public int getId() {
        return (int) notNullOrDefault(invoke("getId"), 0);
    }
    public BossData getData() {
        return new BossData(invoke("getData"));
    }
    public LivingEntity getEntity() {
        return (LivingEntity) invoke("getEntity");
    }
    public void kill() {
        invoke("kill");
    }
    public boolean isKilled() {
        return (boolean) notNullOrDefault(invoke("isKilled"), true);
    }
    public Player getLastDamager() {
        return (Player) invoke("getKiller");
    }
    public Phase getCurrentPhase() {
        return new Phase(this, invoke("getCurrentPhase"));
    }
    public List<Phase> getPhases() {
        return notNullOrDefault((Map<Integer, Object>) invoke("getPhases"), new HashMap<>()).values().stream()
                .map(x -> new Phase(this, x))
                .collect(Collectors.toList());
    }
    public void changePhase(String name) {
        invoke("changePhase", name, AbilityPlugin.StartReason.PHASE_CHANGING.type);
    }
    public Map<String, Double> getDamageMap() {
        return (Map<String, Double>) invoke("getDamageMap");
    }
    public BossDeathType getDeathType() {
        return BossDeathType.getByType((int) notNullOrDefault(invoke("getDeathType"), -1));
    }
    public BossSpawnType getSpawnType() {
        return BossSpawnType.getByType((int) notNullOrDefault(invoke("getSpawnType"), -1));
    }
}