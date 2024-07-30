package org.twindev.devAPI;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.twindev.devAPI.enums.common.LegacyConvertor;
import org.twindev.devAPI.enums.common.LogLevels;

public final class Common {

    private static final String DEFAULT_PREFIX = "";

    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

    private static String legacyToMiniMessage(String message) {
        return LegacyConvertor.convert(message);
    }

    public static void tellNoPrefix(Player player, String message) {
        player.sendMessage(colorize(message));
    }

    public static void tellNoPrefix(CommandSender sender, String message) {
        sender.sendMessage(colorize(message));
    }

    public static void tell(CommandSender sender, String message) {
        sender.sendMessage(colorize(message));
    }

    public static void tell(Player player, String message) {
        player.sendMessage(colorize(message));
    }

    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(colorize(message));
    }

    public static void log(LogLevels logLevel, String message) {
        log(logLevel.getPrefix() + " " + logLevel.getLevel() + message);
    }

    public static String colorize(String string) {
        return legacyToMiniMessage(DEFAULT_PREFIX) + MINI_MESSAGE.deserialize(legacyToMiniMessage(string));
    }

    public static String setPrefix(String prefix) {
        return colorize(prefix);
    }


}
