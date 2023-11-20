package ru.incrementstudio.incbosses.api;

import org.bukkit.plugin.Plugin;
import ru.incrementstudio.incapi.Config;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigManager {
    private final Plugin plugin;
    private final File configFolder;

    public ConfigManager(Plugin plugin) {
        this.plugin = plugin;
        configFolder = new File("plugins//IncBosses//abilities//" + plugin.getName());
        if (!configFolder.exists())
            configFolder.mkdirs();
    }

    public Config getConfig(String name) {
        File configFile = new File(configFolder.getPath() + "//" + name + ".yml");
        if (configFile.exists())
            return new Config(plugin, configFile.getPath());
        plugin.getLogger().severe("Конфиг '" + name + ".yml' не найден");
        return null;
    }

    public void reloadAll(String... configs) {
        for (String config : configs) {
            if (getConfig(config) != null)
                getConfig(config).reload();
        }
    }

    public void updateAll(String... configs) {
        for (String config : configs) {
            if (getConfig(config) != null)
                getConfig(config).update();
        }
    }

    public void saveAll(String... configs) {
        for (String config : configs) {
            if (getConfig(config) != null)
                getConfig(config).save();
        }
    }
}
