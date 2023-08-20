package ru.incrementstudio.incbosses;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;
import ru.incrementstudio.incbosses.bosses.Boss;
import ru.incrementstudio.incbosses.bosses.phases.Phase;

public abstract class AbilityExtension extends JavaPlugin {
    private static AbilityExtension instance;
    public static AbilityExtension getInstance() { return instance; }
    public abstract AbilityBase getAbility(Boss boss, Phase phase, ConfigurationSection config);
    public void onEnable() {
        instance = this;
    }
}
