package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ru.incrementstudio.incapi.Config;
import ru.incrementstudio.incapi.Logger;
import ru.incrementstudio.incapi.quantum.Quantum;
import ru.incrementstudio.incbosses.api.bosses.Boss;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbilityPlugin extends JavaPlugin {
    private final Map<Integer, AbilityBase> abilities = new HashMap<>();
    public static int ID;
    private static AbilityPlugin instance;
    public static AbilityPlugin getInstance() {
        return instance;
    }
    private static ConfigManager configManager;
    public static ConfigManager getConfigManager() {
        return configManager;
    }
    private static Logger logger;
    public static Logger logger() { return logger; }
    private QuantumInterface quantumInterface;
    public final QuantumInterface getQuantumInterface() {
        return quantumInterface;
    }
    public String getAbilityName() {
        Config quantumConfig = AbilityPlugin.getConfigManager().getConfig("config");
        if (quantumConfig != null) {
            ConfigurationSection quantum = quantumConfig.get();
            if (quantum.contains("name")) {
                return quantum.getString("name");
            }
            throw new RuntimeException("В файле 'config.yml' не найдено значение 'name'");
        }
        throw new RuntimeException("Файл 'config.yml' не найден!");
    }

    @Override
    public final void onEnable() {
        instance = this;
        logger = new Logger(this);
        configManager = new ConfigManager(this);
        if (getAbilityName() == null || getAbilityName().isEmpty()) {
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        try {
            quantumInterface = new QuantumInterface();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        onAbilityEnable();
    }

    @Override
    public final void onDisable() {
        onAbilityDisable();
    }

    public void onAbilityEnable() { }
    public void onAbilityDisable() { }
    public final void start(int bossId, int phaseId, FileConfiguration bossConfig, ConfigurationSection abilityConfig, StartReason reason) {
        AbilityBase ability = getAbility(new Boss(bossId), new Phase(new Boss(bossId), phaseId), bossConfig, abilityConfig);
        abilities.put(bossId, ability);
        ability.start(reason);
    }
    public final void stop(int bossId, StopReason reason) {
        AbilityBase ability = abilities.get(bossId);
        ability.stop(reason);
        abilities.remove(bossId);
    }
    public abstract AbilityBase getAbility(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig);
    private final Quantum quantum() {
        return quantumInterface.getQuantum();
    }
}
