package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;
import ru.incrementstudio.incapi.ConfigManager;
import ru.incrementstudio.incapi.Logger;
import ru.incrementstudio.incbosses.api.internection.NetInterface;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AbilityExtension extends JavaPlugin {
    private final Map<Integer, AbilityBase> abilities = new HashMap<>();
    private static AbilityExtension instance;
    public static AbilityExtension getInstance() {
        return instance;
    }
    private static ConfigManager configManager;
    public static ConfigManager getConfigManager() {
        return configManager;
    }
    private static Logger logger;
    public static Logger logger() { return logger; }
    private NetInterface netInterface;
    public NetInterface getNetInterface() {
        return netInterface;
    }
    private String abilityName = null;
    protected void setAbilityName(String name) {
        this.abilityName = name;
    }
    public String getAbilityName() {
        return abilityName;
    }

    @Override
    public void onEnable() {
        instance = this;
        logger = new Logger(this);
        configManager = new ConfigManager(this, Collections.singletonList("internection"));
        configManager.updateAll();
        onAbilityEnable();
        if (abilityName == null || abilityName.isEmpty()) {
            logger.fatalError("Вы не установили значение abilityName! Установите имя способности при помощи setAbilityName(String) внутри метода onAbilityEnable()");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        try {
            netInterface = new NetInterface();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        onAbilityDisable();
        if (netInterface != null) {
            try {
                netInterface.getInterface().close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onAbilityEnable() { }
    public void onAbilityDisable() { }
    public void start(int bossId, int phaseId, ConfigurationSection config) {
        logger().warn("Ability added");
        AbilityBase ability = new AbilityBase(bossId, phaseId, config);
        abilities.put(bossId, ability);
        ability.start();
    }
    public void stop(int bossId) {
        logger().warn("Ability removed");
        AbilityBase ability = abilities.get(bossId);
        ability.stop();
        abilities.remove(bossId);
    }
}
