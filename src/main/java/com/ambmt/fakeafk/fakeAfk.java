package com.ambmt.fakeafk;

import com.ambmt.fakeafk.commands.ReloadConfig;
import com.ambmt.fakeafk.commands.afkOff;
import com.ambmt.fakeafk.commands.afkOn;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public final class fakeAfk extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        this.getCommand("fakeafkreload").setExecutor(new ReloadConfig(this));
        this.getCommand("fakeafkon").setExecutor(new afkOn(this));
        this.getCommand("fakeafkoff").setExecutor(new afkOff(this));
        final FileConfiguration config = getConfig();
        saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();
        Bukkit.getPluginManager().registerEvents(this, this);
        System.out.println("[FakeAfk] Plugin Loaded - made by ambmt");
    }

    @Override
    public void onDisable() {
        System.out.println();
    }
}
