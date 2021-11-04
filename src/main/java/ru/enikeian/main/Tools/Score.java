package ru.enikeian.main.Tools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Score {
    public static void init(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        Objective obj = board.registerNewObjective("game", "dummy", "§7[§c§lRemoted§7]");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);


        org.bukkit.scoreboard.Score nick;
        org.bukkit.scoreboard.Score map;
        org.bukkit.scoreboard.Score mode;
        org.bukkit.scoreboard.Score empty;
        org.bukkit.scoreboard.Score site;

        /*
            [Remoted]
        Ник: [Creator] Del1gator
        Карта: vip_mineshaft
        Режим: Спасение VIP

        https://enikeian.ru
        */

        /*
            [Remoted]
        Ник: [Creator] Del1gator
        Карта: Загрузка
        Режим: -

        https://enikeian.ru
        */


        nick = obj.getScore("Ник: " + Teams.getPlayerNameWithColoredPrefix(player));
        nick.setScore(5);

        map = obj.getScore("Карта: " + Map.currect);
        map.setScore(4);

        mode = obj.getScore("Режим: " + Map.getExpanded());
        mode.setScore(3);

        empty = obj.getScore("");
        empty.setScore(2);

        site = obj.getScore("https://enikeian.ru");
        site.setScore(1);

        player.setScoreboard(board);
    }

    public static void update(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        Objective obj = board.registerNewObjective("game", "dummy", "§7[§c§lRemoted§7]");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        org.bukkit.scoreboard.Score nick;
        org.bukkit.scoreboard.Score map;
        org.bukkit.scoreboard.Score mode;
        org.bukkit.scoreboard.Score empty;
        org.bukkit.scoreboard.Score site;


        nick = obj.getScore("Ник: " + Teams.getPlayerNameWithColoredPrefix(player));
        nick.setScore(5);

        map = obj.getScore("Карта: " + Map.currect);
        map.setScore(4);

        mode = obj.getScore("Режим: " + Map.getExpanded());
        mode.setScore(3);

        empty = obj.getScore("");
        empty.setScore(2);

        site = obj.getScore("https://enikeian.ru");
        site.setScore(1);

        player.setScoreboard(board);
    }

}
