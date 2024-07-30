package org.twindev.devAPI.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Config {

    // Replace JavaPlugin with your main class here and in the constructor!
    private final JavaPlugin plugin;

    private File configFile;
    private FileConfiguration fileConfiguration;
    private final String fileName;
    private final String id;

    public Config(JavaPlugin plugin, String id) {
        this.id = id;
        fileName = id + ".yml";
        this.plugin = plugin;

        fileConfiguration = YamlConfiguration.loadConfiguration(file());
        save();
        reload();
    }

    private File file() {
        return new File(plugin.getDataFolder(), fileName);
    }

    public FileConfiguration options() {
        return fileConfiguration;
    }

    public boolean exists() {
        return file().exists();
    }

    public void saveFile() {
        if (!((fileConfiguration == null) || (configFile == null))) {
            try { options().save(configFile); }
            catch (IOException e) { e.printStackTrace(); }
        }
    }

    public void save() {
        if (configFile == null) configFile = file();
        if (configFile.exists()) return;
        plugin.saveResource(fileName, false);
    }

    public void reload() {
        fileConfiguration = YamlConfiguration.loadConfiguration(file());
    }

}
