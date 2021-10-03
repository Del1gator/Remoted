package ru.enikeian.main.Tools;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import ru.enikeian.main.Enums.Team;
import ru.enikeian.main.Gamemode.vip;

public class Game {

    private static ru.enikeian.main.Gamemode.vip vip;

    public Game(ru.enikeian.main.Gamemode.vip vip) {
        Game.vip = vip;
    }

    public static void changeTeam(Player player, Team team) {

        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        org.bukkit.scoreboard.Team red = board.getTeam("red");
        org.bukkit.scoreboard.Team blue = board.getTeam("blue");
        org.bukkit.scoreboard.Team spectator = board.getTeam("spectator");

        if (red == null || blue == null || spectator == null)
            Teams.setup(); Bukkit.getLogger().info("Teams has not been created! May has errors or problems while game!");

        switch (team) {
            case RED:
                red.addPlayer(player);
                player.setHealth(0D); // Убийство игорока
                break;
            case BLUE:
                blue.addPlayer(player);
                player.setHealth(0D);
                break;
            case SPECTATOR:
                spectator.addPlayer(player);
                player.setHealth(0D);
                player.setGameMode(GameMode.SPECTATOR);
                break;
        }
    }

    public static void startGame(String map) {
        if (map.startsWith("vip_")) {
            vip.enabled = true;

            vip.start();
        }
    }

}
