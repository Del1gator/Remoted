package ru.enikeian.main.Tools;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class chat {

    /*
    Класс создан для быстрого доступа к чату или префиксам
    В основном используется для отсылания тайтлов.

    Создан: 18.09.2021
     */

    /*
    Отправляет сообщение всем команд, но в зависимости от команды текст будет разного цвета
    Для цвета команды юзать: %team%
     */
    public static void sendAll(final String message) {
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        Team red = board.getTeam("red");
        Team blue = board.getTeam("blue");
        Team spectator = board.getTeam("spectator"); // Наблюдает за игрой

        for(Player teams : Bukkit.getOnlinePlayers()) {

            String finalmsg;

            if(red.hasPlayer(teams))
                finalmsg = message.replace("%team%", "§c");
            else if(blue.hasPlayer(teams))
                finalmsg = message.replace("%team%", "§9");
            else if(spectator.hasPlayer(teams))
                finalmsg = message.replace("%team%", "§7");
            else
                finalmsg = message.replace("%team%", "§e");

            teams.sendMessage(finalmsg);
        }
    }

    // Отправляет всем командам на экран сообщение
    public static void sendAllTitle(String title, String subtitle, int fadein, int stay, int fadeout) {

        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        Team red = board.getTeam("red");
        Team blue = board.getTeam("blue");
        Team spectator = board.getTeam("spectator"); // Наблюдает за игрой

        for(Player teams : Bukkit.getOnlinePlayers()) {
            String finaltitle;
            String finalsubtitle;

            if(red.hasPlayer(teams)) {
                finaltitle = title.replace("%team%", "§c");
                finalsubtitle = subtitle.replace("%team%", "§c");
            }
            else if(blue.hasPlayer(teams)){
                finaltitle = title.replace("%team%", "§9");
                finalsubtitle = subtitle.replace("%team%", "§9");
            }
            else if(spectator.hasPlayer(teams)){
                finaltitle = title.replace("%team%", "§7");
                finalsubtitle = subtitle.replace("%team%", "§7");
            }
            else{
                finaltitle = title.replace("%team%", "§e");
                finalsubtitle = subtitle.replace("%team%", "§e");
            }

            teams.sendTitle(finaltitle, finalsubtitle, fadein, stay, fadeout); // Отправление всем сообщение
        }
    }

    // Отравляет всем командам сообщение в быстрые слоты
    public static void sendAllActionbar(String message) {
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        Team red = board.getTeam("red");
        Team blue = board.getTeam("blue");
        Team spectator = board.getTeam("spectator"); // Наблюдает за игрой

        for(Player teams : Bukkit.getOnlinePlayers()) {

            String finalmsg;

            if(red.hasPlayer(teams))
                finalmsg = message.replace("%team%", "§c");
            else if(blue.hasPlayer(teams))
                finalmsg = message.replace("%team%", "§9");
            else if(spectator.hasPlayer(teams))
                finalmsg = message.replace("%team%", "§7");
            else
                finalmsg = message.replace("%team%", "§e");

            teams.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(finalmsg));
        }
    }

    // Отправляет определённому игороку в быстрые слоты сообщение
    public static void sendActionbar(String message, Player receiver) {

        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        Team red = board.getTeam("red");
        Team blue = board.getTeam("blue");
        Team spectator = board.getTeam("spectator"); // Наблюдает за игрой

        if(red.hasPlayer(receiver))
            message = message.replace("%team%", "§c");
        else if(blue.hasPlayer(receiver))
            message = message.replace("%team%", "§9");
        else if(spectator.hasPlayer(receiver))
            message = message.replace("%team%", "§7");
        else
            message = message.replace("%team%", "§e");

        receiver.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
    }
}
