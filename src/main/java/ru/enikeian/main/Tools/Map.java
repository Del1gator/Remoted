package ru.enikeian.main.Tools;

import jdk.internal.org.jline.reader.ConfigurationPath;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.enikeian.main.Main;

public class Map {
    private String currect;

    private static Main plugin;
    private static FileConfiguration config;
    public static String default_map = "vip_mineshaft";

    private Map(Main plugin) {this.plugin = plugin;}

    /*
    * Меняет уровень на другой
    * map_name - название карты которую надо ставить
    * Все карты чекаются в maps.yml
    */
    public static void changeLevel(String map_name) {
        if(!map_exists(map_name)) {
            Bukkit.getLogger().severe("Map " + map_name + "not found! Changing map to default " + default_map);
        }
    }

    private static Boolean map_exists(String name) {
        return true; // soon
    }

    public static void addConfig(FileConfiguration file) {config = file;}
}
