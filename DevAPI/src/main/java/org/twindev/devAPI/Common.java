package org.twindev.devAPI;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.twindev.devAPI.enums.common.LegacyConvertor;
import org.twindev.devAPI.enums.common.LogLevels;

public final class Common {

    private static String DEFAULT_PREFIX = "&7[&6DevAPI&7] ";

    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

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

    public static Component colorize(String string) {
        return MINI_MESSAGE.deserialize(LegacyConvertor.convert(DEFAULT_PREFIX) + LegacyConvertor.convert(string));
    }

    public static void setPrefix(String prefix) {
        DEFAULT_PREFIX = prefix;
    }

    public static String getDefaultPrefix() {
        return DEFAULT_PREFIX;
    }
}
