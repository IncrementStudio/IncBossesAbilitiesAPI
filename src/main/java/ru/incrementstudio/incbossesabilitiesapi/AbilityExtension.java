package ru.incrementstudio.incbossesabilitiesapi;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public abstract class AbilityExtension extends JavaPlugin {
    private static AbilityExtension instance;
    public static AbilityExtension getInstance() { return instance; }
    @NotNull
    public abstract AbilityBase getAbility(@NotNull String boss, @NotNull String phase, @NotNull String capability);

    @Override
    public void onEnable() {
        instance = this;
    }
}
