package com.randompvp.hub.Listeners;

import RandomPvP.Core.Player.MsgType;
import RandomPvP.Core.Player.PlayerManager;
import RandomPvP.Core.Player.Rank.Rank;
import com.randompvp.hub.GUIs.GameMenuGUI;
import com.randompvp.hub.GUIs.HubsGUI;
import com.randompvp.hub.GUIs.ProfileGUI;
import com.randompvp.hub.Items.LobbyItems;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class ItemListeners implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getItem() != null) {
                if(e.getItem().hasItemMeta()) {
                    if(e.getItem().getItemMeta().hasDisplayName()) {
                        Player p = e.getPlayer();
                        switch(e.getItem().getType()) {
                            case COMPASS: p.openInventory(GameMenuGUI.getInventory()); break;
                            case SKULL_ITEM: p.openInventory(ProfileGUI.getInventory()); break;
                            case WATCH:
                                if(PlayerManager.getInstance().getPlayer(p).has(Rank.PREMIUM)) {
                                    p.openInventory(HubsGUI.getInventory());
                                } else {
                                    PlayerManager.getInstance().getPlayer(p).message(MsgType.ERROR, "Only premium members can switch hubs!");
                                }
                                break;
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        e.getItemDrop().remove();
        new LobbyItems().setItems(p);
    }

    @EventHandler
    public void onPick(PlayerPickupItemEvent e) {
        e.setCancelled(true);
    }

}
