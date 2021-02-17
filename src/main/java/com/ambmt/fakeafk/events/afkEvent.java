package com.ambmt.fakeafk.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class afkEvent extends Event implements Cancellable{

    private final Player player;
    private boolean cancelled;

    private static final HandlerList HANDLERS = new HandlerList();

    public afkEvent(Player player){
        this.player = player;
    }
    public Player getPlayer(){

        return player;

    }
    public static HandlerList getHandlerList(){

        return HANDLERS;
    }




    @Override
    public HandlerList getHandlers(){
        return HANDLERS;

    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;

    }
}
