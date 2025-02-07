package org.twindev.devAPI.menus.builder.actions.impl;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.twindev.devAPI.menus.builder.actions.Action;

public class ConsoleCommandAction extends Action {

    public ConsoleCommandAction() {
        super("console");
    }

    @Override
    public boolean run(@NotNull Player player, @NotNull String commandLine) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commandLine.replace("{player}", player.getName()));
        return true;
    }
}
