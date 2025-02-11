package org.twindev.devAPI.menus.builder.actions.impl;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.twindev.devAPI.menus.builder.actions.Action;

public class PlayerCommandAction extends Action {

    public PlayerCommandAction() {
        super("player");
    }

    @Override
    public boolean run(@NotNull Player player, @NotNull String commandLine) {
        Bukkit.dispatchCommand(player, commandLine);
        return true;
    }
}
