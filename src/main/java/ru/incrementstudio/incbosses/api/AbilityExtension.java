package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;
import ru.incrementstudio.incapi.Config;
import ru.incrementstudio.incapi.ConfigManager;
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
    private static Config config;
    public static Config getQuantumConfig() {
        return config;
    }
    private static Logger logger;
    public static Logger logger() { return logger; }
    private QuantumInterface quantumInterface;
    public QuantumInterface getQuantumInterface() {
        return quantumInterface;
    }
    public abstract String getAbilityName();

    @Override
    public void onEnable() {
        instance = this;
        logger = new Logger(this);
        config = new Config(this, "plugins//IncBosses//abilities//" + getAbilityName() + "//quantum.yml");
        config.update();
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
    public void start(int bossId, int phaseId, ConfigurationSection config, int reason) {
        logger().warn("Ability added");
        AbilityBase ability = getAbility(bossId, phaseId, config);
        abilities.put(bossId, ability);
        ability.start(reason);
    }
    public void stop(int bossId, int reason) {
        logger().warn("Ability removed");
        AbilityBase ability = abilities.get(bossId);
        ability.stop(reason);
        abilities.remove(bossId);
    }
    public abstract AbilityBase getAbility(int bossId, int phaseId, ConfigurationSection config);
    public Quantum quantum() {
        return quantumInterface.getQuantum();
    }
}
