package com.randompvp.Hub.GUIs;

import RandomPvP.Core.Player.RPlayer;
import RandomPvP.Core.Player.RPlayerManager;
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
public class StatsGUI {

    private static Inventory inv;

    public StatsGUI(Player p) {
        inv = Bukkit.getServer().createInventory(null, 27, ChatColor.GRAY.toString() + ChatColor.ITALIC + "Profile Page");
        for(int i=0; i < 27; i++) {
            inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
        }
        try {
            RPlayer rp = RPlayerManager.getInstance().getPlayer(p);
            inv.setItem(0, ItemBuilder.build(Material.TNT, ChatColor.RED + "Close", 1));
            inv.setItem(11, ItemBuilder.build(Material.PAPER, ChatColor.RED + "RandomPvP ID", 1, Arrays.asList(ChatColor.GRAY + "Your RPID is " + ChatColor.RED + rp.getRPID() + ChatColor.GRAY + ".")));
            inv.setItem(13, ItemBuilder.build(Material.BEACON, ChatColor.RED + "Rank" , 1, Arrays.asList(ChatColor.GRAY + "Your current rank is " + ChatColor.RED + rp.getRank() + ChatColor.GRAY + ".")));
            inv.setItem(15, ItemBuilder.build(Material.REDSTONE, ChatColor.RED + "Credits" , 1, Arrays.asList(ChatColor.GRAY + "Your balance is " + ChatColor.RED + rp.getCredits() + ChatColor.GRAY + ".")));
        } catch (Exception ex) {
            ex.printStackTrace();
            p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " + ChatColor.GRAY + "An error occurred while retrieving your data.");
            return;
        }
        p.openInventory(inv);
    }

    public static Inventory getInventory() {
        return inv;
    }

}
