package ru.enikeian.main.Gamemode;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Scoreboard;
import ru.enikeian.ELO.api.ELOapi;
import ru.enikeian.main.Enums.Team;
import ru.enikeian.main.Main;
import ru.enikeian.main.Tools.Map;
import ru.enikeian.main.Tools.chat;

import java.util.Random;

public class vip implements Listener {

    /*
    * utils - использует ли режим другие функции
    * version - версия режима
    */
    public boolean utils = true;
    public String version = "0.0.1";
    private final Random random = new Random();
    public static Main plugin;

    public boolean enabled = false;

    public void start() {
        long prepare = (long) Integer.parseInt(Map.getSetting("preparation.time")) * 20;
        // Парс время подготовки

        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();

        org.bukkit.scoreboard.Team red = board.getTeam("red");
        org.bukkit.scoreboard.Team blue = board.getTeam("blue");

        for(Player player : Bukkit.getOnlinePlayers()) {
            //

            if(red.hasPlayer(player))
                player.teleport(Map.getTeamSpawn(Team.RED));
            else if(blue.hasPlayer(player))
                player.teleport(Map.getTeamSpawn(Team.BLUE));
            else
                player.teleport(Map.getTeamSpawn(Team.RED));
        }

        chat.sendAll("%team%Выбераем VIP игорока...");

        Player vip = null;

        while (vip != null) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if(blue.hasPlayer(player)) {
                    if(random.nextBoolean()) {
                        vip = player;
                        vip.sendMessage("[§bEnikeian§r] Вы теперь §eV.I.P§r!");
                        break;
                    }
                }
            }
        }

        chat.sendAll("[%team%Enikeian§r] Миссия начнётся через §e" + Map.getSetting("preparation.time") + "§r секунд!");
        chat.sendAllActionbar("§eПОДГОТОВКА");

        chat.sendAllTitle(
                "§eСпасение V.I.P",
                "§bСинии§r должны довести §e" + vip.getName() + "§r\nдо безопасной зоны.\n§cКрасные§r должны убить §r" + vip.getName(),
                2, 5, 2
        );

        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {

                    main();

                    }
                }, prepare
        );

    }

    public void end() {
        ELOapi elo = new ELOapi();
    }

    public void main() {
        end(); // Заглушка
    }

}
