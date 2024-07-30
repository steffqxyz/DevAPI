package org.twindev.devAPI.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public final class PlayerUtils {

    public static void showPlayerInventory(Player player, Player target) {
        PlayerInventory playerInventory = target.getInventory();
        ItemStack[] contents = playerInventory.getContents();

    }

}
