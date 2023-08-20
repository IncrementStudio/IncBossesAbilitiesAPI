package ru.incrementstudio.incbosses.bosses.phases;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.Map;

public class PhaseData {
    public PhaseData(FileConfiguration bossConfig, String name) { }
    public String getName() { return null; }
    public String getPhaseName() { return null; }
    public Map<String, List<String>> getStartActions() { return null; }
    public Map<String, List<String>> getPlayersAreaActions() { return null; }
    public Map<String, List<String>> getFightersActions() { return null; }
    public double getPlayersActionsRange() { return 0; }
    public boolean isFlagChatStartNotification() { return false; }
    public boolean isFlagClearEffectsOnEnd() { return false; }
    public Map<String, TransitionData> getTransitions() { return null; }
}
