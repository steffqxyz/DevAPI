package org.twindev.devAPI.menus.builder.actions.impl;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.twindev.devAPI.Common;
import org.twindev.devAPI.menus.builder.actions.Action;

public class MessageAction extends Action {
    public MessageAction() {
        super("message");
    }

    @Override
    public boolean run(@NotNull final Player player, @NotNull final String commandLine) {
        player.sendMessage(Common.colorize(commandLine));
        return true;
    }
}
