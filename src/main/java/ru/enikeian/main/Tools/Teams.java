package ru.enikeian.main.Tools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

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
}
