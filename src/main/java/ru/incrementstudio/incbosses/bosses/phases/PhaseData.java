package ru.incrementstudio.incbosses.bosses.phases;

import ru.incrementstudio.incbosses.bosses.abilities.Ability;

import java.util.List;
import java.util.Map;

public interface PhaseData {
    String getName();
    String getPhaseName();
    Map<String, List<String>> getStartActions();
    Map<String, List<String>> getPlayersActions();
    double getPlayersActionsRange();
    boolean isFlagChatStartNotification();
    boolean isFlagClearEffectsOnEnd();
    Map<String, TransitionData> getTransitions();
}
