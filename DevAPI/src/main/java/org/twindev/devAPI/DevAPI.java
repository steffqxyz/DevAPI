package org.twindev.devAPI;


import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.twindev.devAPI.menus.MenuListener;
import org.twindev.devAPI.menus.MenuManager;

public final class DevAPI {

    private static NamespacedKey namespacedKeyLeft;
    private static NamespacedKey namespacedKeyRight;
    private static NamespacedKey namespacedKeyPaginated;
    private static MenuManager menuManager;

    public static void onLoad(@NotNull final JavaPlugin plugin, MenuManager menuManager) {
        namespacedKeyLeft = new NamespacedKey(plugin, "left-click-actions");
        namespacedKeyRight = new NamespacedKey(plugin, "right-click-actions");
        namespacedKeyPaginated = new NamespacedKey(plugin, "paginated");
        DevAPI.menuManager = menuManager;
    }


    public static NamespacedKey getNamespacedKeyLeft() {
        return namespacedKeyLeft;
    }

    public static NamespacedKey getNamespacedKeyPaginated() {
        return namespacedKeyPaginated;
    }

    public static NamespacedKey getNamespacedKeyRight() {
        return namespacedKeyRight;
    }

    public static MenuManager getMenuManager() {
        return menuManager;
    }
}
