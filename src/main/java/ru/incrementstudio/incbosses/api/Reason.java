package ru.incrementstudio.incbosses.api;

public class Reason {
    public static class Start {
        public static final int SPAWN = 0;
        public static final int PHASE_CHANGING = 1;
    }

    public static class Stop {
        public static final int DEATH = 0;
        public static final int PHASE_CHANGING = 1;
    }
}
