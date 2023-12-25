package ru.incrementstudio.incbosses.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ru.incrementstudio.incapi.configs.Config;
import ru.incrementstudio.incapi.Logger;
import ru.incrementstudio.incapi.quantum.Quantum;
import ru.incrementstudio.incbosses.api.bosses.Boss;
import ru.incrementstudio.incbosses.api.bosses.phases.Phase;
import ru.incrementstudio.incbosses.api.internection.QuantumInterface;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbilityPlugin extends JavaPlugin {
    private final Map<Integer, List<AbilityBase>> abilities = new HashMap<>();
    private int ID;
    public final void setID(int id) {
        ID = id;
    }
    public final int getID() {
        return ID;
    }
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
        return getName();
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
        if (!abilities.containsKey(bossId))
            abilities.put(bossId, new ArrayList<>());
        abilities.get(bossId).add(ability);
        ability.start(reason);
    }
    public final void stop(int bossId, StopReason reason) {
        List<AbilityBase> ability = abilities.get(bossId);
        ability.forEach(x -> x.stop(reason));
        abilities.remove(bossId);
    }
    public abstract AbilityBase getAbility(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig);
    public final Quantum quantum() {
        return quantumInterface.getQuantum();
    }
}
