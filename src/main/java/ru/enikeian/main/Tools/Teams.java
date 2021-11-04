package ru.enikeian.main.Tools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;

public class Teams {
    public static void setup() {
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        try {
            Team red = board.registerNewTeam("red");
            red.setColor(ChatColor.RED);
            red.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.FOR_OWN_TEAM);
        } catch (Exception error) {
            Bukkit.getLogger().severe("Error while creating team RED: " + error);
        }
        try {
            Team blue = board.registerNewTeam("blue");
            blue.setColor(ChatColor.BLUE);
            blue.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.FOR_OWN_TEAM);
        } catch (Exception error) {
            Bukkit.getLogger().severe("Error while creating team RED: " + error);
        }
        try {
            Team spectator = board.registerNewTeam("spectator");
            spectator.setColor(ChatColor.GRAY);
            spectator.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.FOR_OWN_TEAM);
        } catch (Exception error) {
            Bukkit.getLogger().severe("Error while creating team RED: " + error);
        }
    }

    public static HashMap<Player, ru.enikeian.main.Enums.Team> getPayerTeams() {
        HashMap<Player, ru.enikeian.main.Enums.Team> map = new HashMap<>();

        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        org.bukkit.scoreboard.Team red = board.getTeam("red");
        org.bukkit.scoreboard.Team blue = board.getTeam("blue");
        org.bukkit.scoreboard.Team spectator = board.getTeam("spectator");

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (red.hasPlayer(player))
                map.put(player, ru.enikeian.main.Enums.Team.RED);
            else if (blue.hasPlayer(player))
                map.put(player, ru.enikeian.main.Enums.Team.BLUE);
            else map.put(player, ru.enikeian.main.Enums.Team.SPECTATOR);
        }

        return map;
    }

    public static ru.enikeian.main.Enums.Team getPlayerTeam(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        org.bukkit.scoreboard.Team red = board.getTeam("red");
        org.bukkit.scoreboard.Team blue = board.getTeam("blue");
        org.bukkit.scoreboard.Team spectator = board.getTeam("spectator");


        if (red.hasPlayer(player))
            return ru.enikeian.main.Enums.Team.RED;

        else if (blue.hasPlayer(player))
            return ru.enikeian.main.Enums.Team.BLUE;

        else
            return ru.enikeian.main.Enums.Team.SPECTATOR;
    }

    public static String getPlayerNameWithColoredPrefix(Player player) {
        if (player.hasPermission("enikeian.creator")) {
            return "[§eCreator§r] " + player.getName();
        } else if (player.hasPermission("eniekian.cocreator")) {
            return "[§6Co. Creator§r] " + player.getName();
        } else if (player.hasPermission("enikeian.elder")) {
            return "[§5Elder Moderator§r] " + player.getName();
        } else if(player.hasPermission("enikeian.mod")) {
            return "[§9Moderator§r] " + player.getName();
        } else if(player.hasPermission("enikeian.helper")) {
            return "[§6Helper§r] " + player.getName();
        } else if(player.hasPermission("enikeian.patron")) {
            return "[§bPatron§r] " + player.getName();
        } else return "[§7Игрок§r] " + player.getName();
    }
}
