package org.twindev.devAPI.menus;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {

    private static final Map<String, Menu> menus = new HashMap<>();

    public static void register(@NotNull final Menu menu) {
        menus.putIfAbsent(menu.getId(), menu);
    }

    public boolean exists(@NotNull final String id) {
        return menus.containsKey(id);
    }

    public Menu getMenu(@NotNull final String id) {
        return menus.getOrDefault(id, null);
    }

}
