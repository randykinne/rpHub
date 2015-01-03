package com.randompvp.Hub.Listeners;

import com.randompvp.Hub.GUIs.GameMenuGUI;
import com.randompvp.Hub.Items.Stack;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class GameMenuItemListener implements Listener{

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getItem().getType() == Material.COMPASS) {
                if(e.getItem().hasItemMeta()) {
                    if(e.getItem().getItemMeta().hasDisplayName()) {
                        if(ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName()).equals("Game Menu")) {
                            p.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ">> " + ChatColor.DARK_RED + "Opening Game Menu...");
                            new GameMenuGUI(p);
                        }
                    }
                }
            }
        }
    }

}
