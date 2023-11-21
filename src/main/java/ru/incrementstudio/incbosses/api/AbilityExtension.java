package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ru.incrementstudio.incapi.Config;
import ru.incrementstudio.incapi.Logger;
import ru.incrementstudio.incapi.quantum.Quantum;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class AbilityExtension extends JavaPlugin {
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
    private QuantumInterface quantumInterface;
    public QuantumInterface getQuantumInterface() {
        return quantumInterface;
    }
    public String getAbilityName() {
        Config quantumConfig = AbilityExtension.getConfigManager().getConfig("config");
        if (quantumConfig != null) {
            ConfigurationSection quantum = quantumConfig.get();
            if (quantum.contains("name")) {
                return quantum.getString("name");
            }
            throw new RuntimeException("В файле 'config.yml' не найдено значение 'name'");
        }
        throw new RuntimeException("Файл 'config.yml' не найден!");
    }
    public int getAbilityId() {
        return QuantumInterface.getModuleId();
    }

    @Override
    public void onEnable() {
        instance = this;
        logger = new Logger(this);
        configManager = new ConfigManager(this);
        configManager.updateAll("config");
        onAbilityEnable();
        if (getAbilityName() == null || getAbilityName().isEmpty()) {
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        try {
            quantumInterface = new QuantumInterface();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        onAbilityDisable();
    }

    public void onAbilityEnable() { }
    public void onAbilityDisable() { }
    public void start(int bossId, int phaseId, FileConfiguration bossConfig, ConfigurationSection abilityConfig, int reason) {
        AbilityBase ability = getAbility(bossId, phaseId, bossConfig, abilityConfig);
        abilities.put(bossId, ability);
        ability.start(reason);
    }
    public void stop(int bossId, int reason) {
        AbilityBase ability = abilities.get(bossId);
        ability.stop(reason);
        abilities.remove(bossId);
    }
    public abstract AbilityBase getAbility(int bossId, int phaseId, FileConfiguration bossConfig, ConfigurationSection abilityConfig);
    public Quantum quantum() {
        return quantumInterface.getQuantum();
    }
}
