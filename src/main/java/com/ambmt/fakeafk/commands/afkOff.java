package com.ambmt.fakeafk.commands;

import com.ambmt.fakeafk.fakeAfk;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class afkOff implements CommandExecutor {
    public static fakeAfk plugin;

    public afkOff(fakeAfk instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        String disable = plugin.getConfig().getString("broadcastdisable");
        p.sendMessage(plugin.getConfig().getString("cmddisable"));
        Bukkit.broadcastMessage(ChatColor.GRAY + "* " + p.getDisplayName() + " " + ChatColor.GRAY + disable);




        return false;
    }

}
