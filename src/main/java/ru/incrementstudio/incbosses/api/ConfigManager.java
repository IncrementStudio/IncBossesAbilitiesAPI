package ru.incrementstudio.incbosses.api;

import java.io.File;

public final class ConfigManager {
    private final AbilityPlugin plugin;
    private final File configFolder;

    public ConfigManager(AbilityPlugin plugin) {
        this.plugin = plugin;
        configFolder = new File("plugins/IncBosses/abilities/" + plugin.getName());
        if (!configFolder.exists())
            configFolder.mkdirs();
    }

    public Config getConfig(String name) {
        File configFile = new File(configFolder.getPath() + "/" + name + ".yml");
        if (configFile.exists())
            return new Config(plugin, configFile);
        plugin.getLogger().severe("Config '" + name + ".yml' not found!");
        return null;
    }
}
