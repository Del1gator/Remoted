package ru.enikeian.main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ru.enikeian.main.Tools.Map;
import ru.enikeian.main.Tools.Teams;
import ru.enikeian.main.Tools.chat;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {

    private File maps_file;
    private FileConfiguration maps;

    @Override
    public void onEnable() {
        // Plugin startup

        maps_file = new File(getDataFolder(), "assets/configs/maps.yml");

        if(!maps_file.exists()) {
            maps_file.getParentFile().mkdirs();
            saveResource("assets/configs/maps.yml", false);
        }

        maps = new YamlConfiguration();
        try {
            maps.load(maps_file);
        } catch (IOException | InvalidConfigurationException error) {
            getLogger().severe("While trying load maps.yml has exception: ");
            error.printStackTrace();

            this.setEnabled(false);
        }

        Map.addConfig(maps);

        Teams.setup(); // Настраивание команд для режима

        if(Bukkit.getOnlinePlayers().size() != 0) {
            chat.sendAll("[%team%Enikeian§r] Сервер был перезагружен и теперь всем нужно %team%залогиниться и зайти в команду§r!");

        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
