package ru.enikeian.main;

import org.bukkit.plugin.java.JavaPlugin;
import ru.enikeian.main.Tools.Teams;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Teams.setup(); // Настраивание команд для режима

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
