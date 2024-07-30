package org.twindev.devAPI.enums;

public enum LegacyConvertor {
    // Color Codes
    BLACK("&0", "<black>"),
    DARK_BLUE("&1", "<dark_blue>"),
    DARK_GREEN("&2", "<dark_green>"),
    DARK_AQUA("&3", "<dark_aqua>"),
    DARK_RED("&4", "<dark_red>"),
    DARK_PURPLE("&5", "<dark_purple>"),
    GOLD("&6", "<gold>"),
    GRAY("&7", "<gray>"),
    DARK_GRAY("&8", "<dark_gray>"),
    BLUE("&9", "<blue>"),
    GREEN("&a", "<green>"),
    AQUA("&b", "<aqua>"),
    RED("&c", "<red>"),
    LIGHT_PURPLE("&d", "<light_purple>"),
    YELLOW("&e", "<yellow>"),
    WHITE("&f", "<white>"),

    // Formatting Codes
    OBFUSCATED("&k", "<obfuscated>"),
    BOLD("&l", "<bold>"),
    STRIKETHROUGH("&m", "<strikethrough>"),
    UNDERLINE("&n", "<underlined>"),
    ITALIC("&o", "<italic>"),
    RESET("&r", "<reset>");

    private final String legacyCode;
    private final String miniMessageTag;

    LegacyConvertor(String legacyCode, String miniMessageTag) {
        this.legacyCode = legacyCode;
        this.miniMessageTag = miniMessageTag;
    }

    public String getLegacyCode() {
        return legacyCode;
    }

    public String getMiniMessageTag() {
        return miniMessageTag;
    }

    // Method to convert a legacy code to a MiniMessage tag
    public static String convert(String message) {
        for (LegacyConvertor convertor : LegacyConvertor.values()) {
            message = message.replace(convertor.getLegacyCode(), convertor.getMiniMessageTag());
        }
        return message;
    }
}
