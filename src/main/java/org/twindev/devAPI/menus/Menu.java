package org.twindev.devAPI.menus;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.twindev.devAPI.DevAPI;
import org.twindev.devAPI.configuration.Config;
import org.twindev.devAPI.menus.builder.ItemBuilder;

import java.util.HashMap;
import java.util.Map;

public final class Menu implements InventoryHolder {

    private static NamespacedKey namespacedKey;
    private String id;

    public static void load(JavaPlugin plugin) {
        Menu.namespacedKey = new NamespacedKey(plugin, "menus-devapi");
    }

    public static NamespacedKey getNamespacedKey() {
        return namespacedKey;
    }

    private final Config config;

    private final String title;
    private final int size;
    private final String pageAppend;
    private Paginate<?> paginate;

    private final Map<String, ItemBuilder> contents = new HashMap<>();
    private final Map<String, ItemBuilder> items = new HashMap<>();


    public Menu(final String id, final Config config) {
        this.id = id;
        this.config = config;
        this.title = config.options().getString("title");
        this.pageAppend = config.options().getString("page-append");
        int rows = config.options().getInt("rows", 6);
        if (rows < 1) rows = 1;
        else if (rows > 6) rows = 6;
        this.size = rows *9;

        final ConfigurationSection contents = config.options().getConfigurationSection("contents");
        if (contents != null) {
            contents.getKeys(false).forEach(key -> {
                final String path = "contents." + key;
                this.contents.put(key, new ItemBuilder(config, path).setId(path));
            });

            DevAPI.getMenuManager().register(this);
        }
    }

    public @NotNull Inventory getInventory(final Player player, int page) {
        String titleAppend = "";
        if (paginate != null) {
            final int pages = paginate.pages();
            if (page < 1) page = 1;
            else if (page > pages) page = pages;
            if (pages > 1) titleAppend = pageAppend
                    .replace("{PAGE}", String.valueOf(page))
                    .replace("{PAGES}", String.valueOf(pages));
        }

        final Inventory inventory = Bukkit.createInventory(
                this,
                size,
                title + titleAppend
        );

        contents.forEach((id, builder) -> {
            final ItemStack item = builder.build(player);
            builder.getSlots().forEach(slot -> inventory.setItem(slot, item));
        });

        items.forEach((id, builder) -> {
            final ItemStack item = builder.build(player);
            builder.getSlots().forEach(slot -> inventory.setItem(slot, item));
        });

        if (paginate != null) paginate.populate(page, inventory, player);
        return inventory;
    }

    public @NotNull Inventory getInventory(final Player player) {
        return getInventory(player, 1);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return getInventory(null, 1);
    }

    public void addItem(ItemBuilder builder) {
        items.put(builder.id(), builder);
    }

    public ItemBuilder getContent(String id) {
        return contents.getOrDefault(id, null);
    }

    public ItemBuilder getItem(String id) {
        return items.getOrDefault(id, null);
    }

    public void open(@NotNull final Player player, int page) {
        player.openInventory(getInventory(player, page));
    }

    public void open(@NotNull final Player player) {
        player.openInventory(getInventory(player, 1));
    }

    public void closeAll() {
        Bukkit.getOnlinePlayers().forEach(p -> {
            final Inventory inv = p.getOpenInventory().getTopInventory();
            if (!(inv.getHolder() instanceof Menu)) return;
            p.closeInventory();
        });
    }

    public Config getConfig() { return config; }

    public void paginate(Paginate<?> paginate) {
        this.paginate = paginate;
    }

    public String getId() {
        return id;
    }
    public Paginate<?> paginate() { return paginate; }
    public boolean isPaginated() { return paginate != null; }

}
