package ru.enikeian.main.Tools;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class chat {

    /*
    Класс создан для быстрого доступа к чату или префиксам
    В основном используется для отсылания тайтлов.

    Создан: 18.09.2021
     */

    public String prefix = "[§cRemoted§f] ";
    public String system = "[§bСистема§f] ";

    // Отправляет всем командам сообщение
    public static void sendAll(String message) {
        for(Player players : Bukkit.getOnlinePlayers()) {
            players.sendMessage(message); // Отправление всем сообщение
        }
    }

    // Отправляет всем командам на экран сообщение
    public static void sendAllTitle(String title, String subtitle, int fadein, int stay, int fadeout) {
        for(Player players : Bukkit.getOnlinePlayers()) {
            players.sendTitle(title, subtitle, fadein, stay, fadeout); // Отправление всем сообщение
        }
    }

    // Отравляет всем командам сообщение в быстрые слоты
    public static void sendAllActionbar(String message) {
        for(Player players : Bukkit.getOnlinePlayers()) {
            players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
        }
    }

    // Отправляет определённому игороку в быстрые слоты сообщение
    public static void sendActionbar(String message, Player receiver) {
        receiver.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
    }
}
