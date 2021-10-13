package ru.enikeian.main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ru.enikeian.main.Tools.Map;
import ru.enikeian.main.Tools.Teams;
import ru.enikeian.main.Tools.chat;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {

    private File maps_file;
    private FileConfiguration maps;
    public Main plug = this;
    public static String mode_version = "0.0.1 ALPHA | BUGS";

    public static String soft_depencies() {
        return "DelCore, MyCurrency";
    }

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
            chat.sendAll("При загрузке maps.yml найдена ошибка: " + error.getMessage());
            chat.sendAll("Сервер будет выключен через 10 секунд...");

            Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                @Override
                public void run() {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.kickPlayer("Сервер выключен из-за ошибки!\nЛоги в: Remoted/assets/logs\nПодробнее на дискорд сервере\nhttps://discord.gg/arEUDEVT9r");
                    }
                    plug.getServer().shutdown();
                }
            }, 200);
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
