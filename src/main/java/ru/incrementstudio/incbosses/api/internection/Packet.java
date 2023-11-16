package ru.incrementstudio.incbosses.api.internection;

public class Packet {
    public static class API {
        public static final int BOSS = 0;
        public static final int BOSS_DATA = 1;
        public static final int PHASE = 2;
        public static final int PHASE_DATA = 3;
        public static class Boss {
            public static final int GET_ENTITY = 0;
            public static final int KILL = 1;
            public static final int SPAWN = 2;
            public static final int IS_KILLED = 3;
            public static final int GET_KILLER = 4;
            public static final int GET_CURRENT_PHASE = 5;
            public static final int GET_PHASES = 6;
            public static final int CHANGE_PHASE = 7;
            public static final int EXECUTE_BOSS_ACTIONS = 8;
            public static final int EXECUTE_PLAYERS_ACTIONS = 9;
            public static final int GET_BOSS_BAR = 10;
            public static final int GET_DAMAGE_MAP = 11;
            public static final int GET_DEATH_TYPE = 12;
            public static final int GET_SPAWN_TYPE = 13;
        }
        public static class BossData {
            public static final int GET_NAME = 0;
            public static final int GET_BOSS_NAME = 1;
            public static final int GET_DISPLAY_NAME = 2;
            public static final int GET_ENTITY_TYPE = 3;
            public static final int GET_HEALTH = 4;
            public static final int IS_GLOWING = 5;
            public static final int IS_BABY = 6;
            public static final int GET_BAR_COLOR = 7;
            public static final int GET_BAR_STYLE = 8;
            public static final int GET_BAR_FLAGS = 9;
            public static final int GET_SPAWN_ACTIONS = 10;
            public static final int GET_DEATH_ACTIONS = 11;
            public static final int GET_SPAWN_TYPE_ACTIONS = 12;
            public static final int GET_DEATH_TYPE_ACTIONS = 13;
            public static final int GET_PHASE_DATAS = 14;
            public static final int GET_MAIN_HAND = 15;
            public static final int GET_OFF_HAND = 16;
            public static final int GET_HELMET = 17;
            public static final int GET_CHESTPLATE = 18;
            public static final int GET_LEGGINGS = 19;
            public static final int GET_BOOTS = 20;
            public static final int IS_FLAG_GIVE_NATURAL_EFFECTS = 21;
        }
        public static class Phase {
            public static final int GET_LIFETIME = 0;
            public static final int START = 1;
            public static final int STOP = 2;
        }
        public static class PhaseData {
            public static final int GET_NAME = 0;
            public static final int GET_PHASE_NAME = 1;
            public static final int GET_START_ACTIONS = 2;
            public static final int GET_AREA_PLAYERS_ACTIONS = 3;
            public static final int GET_FIGHTERS_ACTIONS = 4;
            public static final int GET_PLAYERS_ACTIONS_AREA_RANGE = 5;
            public static final int IS_FLAG_CHAT_START_NOTIFICATION = 6;
            public static final int IS_FLAG_CLEAR_EFFECTS_ON_END = 7;
        }
    }
}
