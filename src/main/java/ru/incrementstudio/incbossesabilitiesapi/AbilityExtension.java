package ru.incrementstudio.incbossesabilitiesapi;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbilityExtension extends JavaPlugin {
    private static AbilityExtension instance;
    public static AbilityExtension getInstance() { return instance; }

    public abstract AbilityBase getAbility(String boss, String phase, String capability);

    @Override
    public void onEnable() {
        instance = this;
    }
}
