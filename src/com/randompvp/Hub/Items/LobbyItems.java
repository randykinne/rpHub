package com.randompvp.Hub.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class LobbyItems {

    private Stack stack;

    public LobbyItems(Player p) {
        stack = new Stack();

        p.getInventory().setItem(0, stack.build(Material.COMPASS, 1, (short) 0, ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Game Menu", new String[] { ChatColor.GRAY + "Used to select a game" }));
        p.getInventory().setItem(8, stack.pskull(p, 1, ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Your Profile", new String[] { ChatColor.GRAY + "Used to view info about your account" }));

        stack = null;
    }

}
