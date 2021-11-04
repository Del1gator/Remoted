package ru.enikeian.main.Tools;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import ru.enikeian.main.Enums.Team;
import ru.enikeian.main.Gamemode.vip;

import static ru.enikeian.main.Tools.Map.getSetting;

public class Game {

    private static ru.enikeian.main.Gamemode.vip vip;

    public static boolean allow_team_change = true;
    public static boolean match = false;

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
                chat.sendAll("[%team%Enikeian§r] Игрок §c" + player.getName() + "§r сменил свою команду на §cКРАСНЫЕ");
                break;
            case BLUE:
                blue.addPlayer(player);
                player.setHealth(0D);
                chat.sendAll("[%team%Enikeian§r] Игрок §b" + player.getName() + "§r сменил свою команду на §bСИНИИ");
                break;
            case SPECTATOR:
                spectator.addPlayer(player);
                player.setHealth(0D);
                player.setGameMode(GameMode.SPECTATOR);
                chat.sendAll("[%team%Enikeian§r] Игрок §c" + player.getName() + "§r сменил свою команду на §cНАБЛЮДАТЕЛИ");
                break;
        }
    }

    public static void startGame(String map) {

        if(Bukkit.getOnlinePlayers().size() <= 2) {
            int x = Integer.parseInt(getSetting("warmup.x"));
            int y = Integer.parseInt(getSetting("warmup.y"));
            int z = Integer.parseInt(getSetting("warmup.z"));

            chat.sendAll("[%team%Enikeian§r] Недостаточно игороков чтобы начать карту " + map + ", нужно %team%2§r человека!");

            return;
        }

        if (map.startsWith("vip_")) {
            match = true;
            vip.enabled = true;

            vip.start();
        }
    }

}
