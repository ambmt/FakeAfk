package com.ambmt.fakeafk.commands;

import com.ambmt.fakeafk.events.afkEvent;
import com.ambmt.fakeafk.fakeAfk;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class afkOn implements CommandExecutor {
    public static fakeAfk plugin;

    public afkOn(fakeAfk instance) {
        plugin = instance;
    }


        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(sender instanceof Player) {
            if (hasPermissions(player)) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    builder.append(args[i]).append(" ");
                }
                String broadcastenable = plugin.getConfig().getString("broadcastenable");


                String message = (ChatColor.GRAY + "* " + player.getDisplayName() + " " + ChatColor.GRAY + broadcastenable);
                player.sendMessage(plugin.getConfig().getString("cmdenable"));
                afkEvent event = new afkEvent(player);
                Bukkit.getPluginManager().callEvent(event);
                if (!event.isCancelled()) {
                    Bukkit.broadcastMessage(ChatColor.GRAY + "* " + player.getDisplayName() + " " + ChatColor.GRAY + broadcastenable);
                }
            }else {
                player.sendMessage(ChatColor.WHITE + "Unknown Command. Type \"/help\" for help.");
        }
        }
        return false;

        }
        public boolean hasPermissions(Player player) {
         if (player.hasPermission("fakeafk.afkon")) {
            return true;
         } else if (player.hasPermission("fakeafk.admin")) {
            return true;
         }
        return false;
    }
}


