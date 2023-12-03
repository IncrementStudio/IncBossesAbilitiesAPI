package ru.incrementstudio.incbosses.api.internection;

public final class Packet {
    public final static class API {
        public static final int BOSS = 0;
        public static final int BOSS_DATA = 1;
        public static final int PHASE = 2;
        public static final int PHASE_DATA = 3;
        public static class Boss {
            public static final int GET_ENTITY = 0;
            public static final int KILL = 1;
            public static final int IS_KILLED = 2;
            public static final int GET_KILLER = 3;
            public static final int GET_CURRENT_PHASE = 4;
            public static final int GET_PHASES = 5;
            public static final int CHANGE_PHASE = 6;
            public static final int GET_DAMAGE_MAP = 7;
            public static final int GET_DEATH_TYPE = 8;
            public static final int GET_SPAWN_TYPE = 9;
        }
        public final static class BossData {
            public static final int GET_NAME = 0;
            public static final int GET_BOSS_NAME = 1;
            public static final int GET_DISPLAY_NAME = 2;
            public static final int GET_ENTITY_TYPE = 3;
            public static final int GET_HEALTH = 4;
            public static final int IS_GLOWING = 5;
            public static final int IS_BABY = 6;
            public static final int GET_PHASE_DATAS = 7;
            public static final int GET_MAIN_HAND = 8;
            public static final int GET_OFF_HAND = 9;
            public static final int GET_HELMET = 10;
            public static final int GET_CHESTPLATE = 11;
            public static final int GET_LEGGINGS = 12;
            public static final int GET_BOOTS = 13;
        }
        public final static class Phase {
            public static final int GET_LIFETIME = 0;
            public static final int START = 1;
            public static final int STOP = 2;
        }
        public final static class PhaseData {
            public static final int GET_NAME = 0;
            public static final int GET_PHASE_NAME = 1;
        }
    }
}
