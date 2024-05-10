package ru.incrementstudio.incbosses.api;

import com.google.common.base.Charsets;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.Objects;

public class Config {
    private final AbilityPlugin plugin;
    private final File file;
    private FileConfiguration config = null;

    public Config(AbilityPlugin plugin, File file) {
        this.plugin = plugin;
        this.file = file;
        update();
        reload();
    }

    public FileConfiguration get() {
        return config;
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(file);
        InputStream defConfigStream = plugin.getClass().getResourceAsStream(file.getName());
        if (defConfigStream == null)
            return;
        config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
    }

    public void save() {
        try {
            get().save(file);
        } catch (IOException ignored) { }
    }

    public void update() {
        if (file.exists())
            return;
        file.getParentFile().mkdirs();
        try {
            try (FileOutputStream outputStream = new FileOutputStream(file)) {
                try (InputStream inputStream = plugin.getClass().getResourceAsStream(file.getName())) {
                    outputStream.write(Objects.requireNonNull(inputStream).readAllBytes());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
