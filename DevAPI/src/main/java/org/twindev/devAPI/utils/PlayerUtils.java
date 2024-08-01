package org.twindev.devAPI.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public final class PlayerUtils {

    public static void showPlayerInventory(Player player, Player target) {
        PlayerInventory playerInventory = target.getInventory();
        ItemStack[] contents = playerInventory.getContents();

        Inventory inventory = Bukkit.createInventory(player, 36, target.getName() + "'s Inventory");
        inventory.setContents(contents);
        player.openInventory(inventory);
    }

    public static void showPlayerEnderChest(Player player, Player target) {
        Inventory enderChest = target.getEnderChest();
        Inventory inventory = Bukkit.createInventory(player, 27, target.getName() + "'s Ender Chest");
        inventory.setContents(enderChest.getContents());
        player.openInventory(inventory);
    }

    public static void showPlayerArmor(Player player, Player target) {
        PlayerInventory playerInventory = target.getInventory();
        ItemStack[] armorContents = playerInventory.getArmorContents();

        Inventory inventory = Bukkit.createInventory(player, 9, target.getName() + "'s Armor");
        inventory.setContents(armorContents);
        player.openInventory(inventory);
    }

}
