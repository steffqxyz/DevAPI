package org.twindev.devAPI.enums;

public enum LogLevels {
    ERROR("<red>", "[ERROR]"), SUCCESS("<green>", "[SUCCESS]"), INFO("<gray>", "[INFO]");


    private final String level;
    private final String prefix;

    LogLevels(String level, String prefix) {
        this.level = level;
        this.prefix = prefix;
    }

    public String getLevel() {
        return level;
    }

    public String getPrefix() {
        return prefix;
    }
}
