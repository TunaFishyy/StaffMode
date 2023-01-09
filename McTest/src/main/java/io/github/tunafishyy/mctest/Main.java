package io.github.tunafishyy.mctest;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("staffmode").setExecutor(new StaffChatToggle());
        getServer().getPluginManager().registerEvents(new StaffMode(), this);
    }

    @Override
    public void onDisable() {
    }
}
