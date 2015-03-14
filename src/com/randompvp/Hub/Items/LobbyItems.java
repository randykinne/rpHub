package com.randompvp.hub.Items;

import RandomPvP.Core.Util.Color.CC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class LobbyItems {

    public void setItems(Player p) {
        Stack stack = new Stack();
        p.getInventory().clear();
        p.getInventory().setItem(0, stack.build(Material.COMPASS, 1,
                (short) 0, ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Game Menu", new String[] { ChatColor.GRAY + "Used to select a game" }));
        p.getInventory().setItem(8, stack.pskull(p, 1,
                ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Your Profile", new String[] { ChatColor.GRAY + "Used to view info about your account" }));
        p.getInventory().setItem(1, stack.build(Material.WATCH, 1,
                (short) 0, ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Hub Selector", new String[] { ChatColor.GRAY + "Used to switch between hubs" }));
        p.getInventory().setItem(7, stack.build(Material.CHEST, 1,
                (short) 0,CC.DRED.toString() + CC.BLD + "Gizmos", new String[] { CC.GRY + "Used to play with Gizmos!" } ));
    }

    public ItemStack[] getItems() {
        return null;
    }

}
