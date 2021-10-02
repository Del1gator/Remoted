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
        } catch(Exception error) {Bukkit.getLogger().severe("Error while creating team RED: " + error);}
        try {
            Team blue = board.registerNewTeam("red");
            blue.setColor(ChatColor.BLUE);
            blue.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.FOR_OWN_TEAM);
        } catch(Exception error) {Bukkit.getLogger().severe("Error while creating team RED: " + error);}
        try {
            Team spectator = board.registerNewTeam("red");
            spectator.setColor(ChatColor.GRAY);
            spectator.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.FOR_OWN_TEAM);
        } catch(Exception error) {Bukkit.getLogger().severe("Error while creating team RED: " + error);}
    }

    public static HashMap<Player, ru.enikeian.main.Enums.Team> getPayerTeams() {
        HashMap<Player, ru.enikeian.main.Enums.Team> map = new HashMap<>();

        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        org.bukkit.scoreboard.Team red = board.getTeam("red");
        org.bukkit.scoreboard.Team blue = board.getTeam("blue");
        org.bukkit.scoreboard.Team spectator = board.getTeam("spectator");

        for(Player player : Bukkit.getOnlinePlayers()) {
            if(red.hasPlayer(player))
                map.put(player, ru.enikeian.main.Enums.Team.RED);
            else if (blue.hasPlayer(player))
                map.put(player, ru.enikeian.main.Enums.Team.BLUE);
            else map.put(player, ru.enikeian.main.Enums.Team.SPECTATOR);
        }

        return map;
    }
}
