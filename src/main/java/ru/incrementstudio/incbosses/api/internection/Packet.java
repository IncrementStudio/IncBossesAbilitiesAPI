package ru.incrementstudio.incbosses.api.internection;

public class Packet {
    public static class Service {
        public static final int REGISTRATION = 0;
    }
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
        }
        public static class Phase {
        }
        public static class PhaseData {
        }
    }
}
