package ru.enikeian.main.Tools;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import ru.enikeian.main.Enums.Mode;
import ru.enikeian.main.Enums.Team;
import ru.enikeian.main.Main;

public class Map {
    public static String currect = null;

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
            chat.sendAll("[%team%Enikeian§r] Карта не найдена! Ставлю %team%" + default_map);
            changeLevel(default_map); // Рекурсия для смены карты на дефолт
        }

        for(Player players : Bukkit.getOnlinePlayers()) {
            Game.changeTeam(players, Team.SPECTATOR);
            players.teleport(getLobby());
        }

        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        org.bukkit.scoreboard.Team red = board.getTeam("red");
        org.bukkit.scoreboard.Team blue = board.getTeam("blue");
        org.bukkit.scoreboard.Team spectator = board.getTeam("spectator");

//        Получение спавна команд
        int red_x = Integer.parseInt(getSetting(map_name + ".red_spawn.x"));
        int red_y = Integer.parseInt(getSetting(map_name + ".red_spawn.y"));
        int red_z = Integer.parseInt(getSetting(map_name + ".red_spawn.z"));

        int blue_x = Integer.parseInt(getSetting(map_name + ".blue_spawn.x"));
        int blue_y = Integer.parseInt(getSetting(map_name + ".blue_spawn.y"));
        int blue_z = Integer.parseInt(getSetting(map_name + ".blue_spawn.z"));

        for (Player player : Bukkit.getOnlinePlayers()) {
            if(red.hasPlayer(player))
                player.teleport(new Location(Bukkit.getWorld("world"), red_x, red_y, red_z));

            else if (blue.hasPlayer(player))
                player.teleport(new Location(Bukkit.getWorld("world"), blue_x, blue_y, blue_z));

            else
                player.teleport(new Location(Bukkit.getWorld("world"), red_x, red_y, red_z));
        }

        currect = map_name;
        Game.startGame(currect);
    }

    private static Boolean map_exists(String name) {
        return getSetting("maps.%map%".replace("%map%", name)) != null;
    }

    public static String getSetting(String to_get) {
        return String.valueOf(config.get(to_get));
    }

    public static void addConfig(FileConfiguration file) {config = file;}

    public static Location getLobby() {
        int x = Integer.parseInt(getSetting("lobby.x"));
        int y = Integer.parseInt(getSetting("lobby.y"));
        int z = Integer.parseInt(getSetting("lobby.z"));

        return new Location(Bukkit.getWorld("world"), x, y, z);
    }

    public static String getExpanded() {
        if (currect.startsWith(Mode.VIP.getPrefix())) return Mode.VIP.getExpanded();
        else if (currect.startsWith(Mode.CAPTURE_POINTS.getPrefix())) return Mode.CAPTURE_POINTS.getExpanded();
        else if (currect.startsWith(Mode.CAPTURE_ALL_POINTS.getPrefix())) return Mode.CAPTURE_ALL_POINTS.getExpanded();
        else if (currect.startsWith(Mode.CAPTURE_THE_FLAG.getPrefix())) return Mode.CAPTURE_THE_FLAG.getExpanded();
        else if (currect.startsWith(Mode.ZOMBIE_INFECT.getPrefix())) return Mode.ZOMBIE_INFECT.getExpanded();
        else if (currect.startsWith(Mode.DEATH_MATCH.getPrefix())) return Mode.DEATH_MATCH.getExpanded();
        else return Mode.ESCORT_MINECART.getExpanded();
    }
}
