package ru.enikeian.main.Functions.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.enikeian.main.Main;

public class about implements CommandExecutor {

    /*
    * Пометка себе
    * НАХУЯ Я ЭТО ДЕЛАЛ?
    */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage(
                "----------------------" +
                "Remoted version: " + Main.mode_version +
                "GitHub: https://github.com/Del1gator/Remoted" +
                "Зависимости: " + Main.soft_depencies() +
                "----------------------"
        );

        return true;
    }
}
