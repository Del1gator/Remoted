package ru.enikeian.main.Functions.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.enikeian.main.Enums.Team;
import ru.enikeian.main.Tools.Game;

import java.util.ArrayList;

public class ChangeTeam implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;

        if(!(sender instanceof Player)) {
            return true;
        } else {
            player = Bukkit.getPlayer(sender.getName());
        }

        if (args.length == 0) {
            return false;
        }
        if (!(args[0] == "red") || !(args[0] == "blue") || !(args[0] == "spec") || !(args[0] == "spectator")) {
            return false;
        }

        if(!Game.allow_team_change) {
            player.sendMessage("§cВ данном матче отключена возможность смены команды." +
                    " Ожидайте окончания матча и попробуйте это ещё раз.");
            return true;
        }

        if(args[0] == "red") {
            Game.changeTeam(player, Team.RED);
        } else if(args[0] == "blue") {
            Game.changeTeam(player, Team.BLUE);
        } else if(args[0] == "spec") {
            Game.changeTeam(player, Team.SPECTATOR);
        } else if(args[0] == "spectator") {
            Game.changeTeam(player, Team.SPECTATOR);
        }

        return true;
    }
}
