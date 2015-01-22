package com.randompvp.Hub.GUIs;

import RandomPvP.Core.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class ProfileGUI {

    private static Inventory inv;

    public ProfileGUI(Player p) {
        inv = Bukkit.getServer().createInventory(null, 27, ChatColor.GRAY.toString() + ChatColor.ITALIC + "Profile Page");
        for(int i=0; i < 27; i++) {
            inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
        }
        inv.setItem(11, ItemBuilder.build(Material.PAPER, ChatColor.RED + "Stats", 1, Arrays.asList(ChatColor.GRAY + "Click to view your stats")));
        inv.setItem(15, ItemBuilder.build(Material.CHEST, ChatColor.RED + "Credits Shop" , 1, Arrays.asList(ChatColor.GRAY + "Click to view the credits shop")));
        p.openInventory(inv);
    }

    public static Inventory getInventory() {
        return inv;
    }

}
