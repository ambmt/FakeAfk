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
        Player player = (Player) sender;
        if(hasPermissions(player)) {
            String disable = plugin.getConfig().getString("broadcastdisable");
            player.sendMessage(plugin.getConfig().getString("cmddisable"));
            Bukkit.broadcastMessage(ChatColor.GRAY + "* " + player.getDisplayName() + " " + ChatColor.GRAY + disable);
        }else{
            player.sendMessage(ChatColor.WHITE + "Unknown Command. Type \"/help\" for help.");
        }


        return false;
    }
    public boolean hasPermissions(Player player) {
        if (player.hasPermission("fakeafk.afkoff")) {
            return true;
        } else if (player.hasPermission("fakeafk.admin")) {
            return true;
        }
        return false;
    }
}

