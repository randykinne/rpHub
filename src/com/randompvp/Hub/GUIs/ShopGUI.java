package com.randompvp.Hub.GUIs;

import RandomPvP.Core.RPICore;
import RandomPvP.Core.Util.GUI.IconMenu;
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
public class ShopGUI {

    private static Inventory inv;

    public ShopGUI(Player p) {
        inv = Bukkit.getServer().createInventory(null, 27, ChatColor.GRAY.toString() + ChatColor.ITALIC + "Shop Page");
        for(int i=0; i < 27; i++) {
            inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
        }
        inv.setItem(0, ItemBuilder.build(Material.TNT, ChatColor.RED + "Close", 1));
        inv.setItem(13, ItemBuilder.build(Material.ENDER_CHEST, ChatColor.RED + "1 Day Credit Booster" , 1, Arrays.asList("", ChatColor.GRAY + "Receive x2 credits for one day when",
                ChatColor.GRAY + "purchased.", "", ChatColor.DARK_RED.toString() + ChatColor.BOLD + "WARNING: "
                        + ChatColor.GRAY + "This can only be purchased", ChatColor.GRAY + "once every week.",
                "", ChatColor.RED + "Price: " + ChatColor.GRAY + "Coming Soon!", "")));
        p.openInventory(inv);
    }

    public static Inventory getInventory() {
        return inv;
    }

}
