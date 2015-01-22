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
public class GameMenuGUI {

    private static Inventory inv;

    public GameMenuGUI(Player p) {
        inv = Bukkit.getServer().createInventory(null, 27, ChatColor.GRAY.toString() + ChatColor.ITALIC + "Game Menu");
        for(int i=0; i < 27; i++) {
<<<<<<< HEAD
            inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
=======
            menu.setOption(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), " ", " ");
>>>>>>> 30d1bc660057746fcf9649394932f34f5a432ce0
        }
        inv.setItem(11, ItemBuilder.build(Material.DIAMOND_SWORD, ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " + ChatColor.RESET.toString() + ChatColor.BOLD + "PVPACADEMY", 1, Arrays.asList("", ChatColor.RED + "Left Click" + ChatColor.GRAY + " to join!", "")));
        inv.setItem(13, ItemBuilder.build(Material.GOLDEN_APPLE, ChatColor.GOLD.toString() + ChatColor.BOLD + ">> " + ChatColor.RESET.toString() + ChatColor.BOLD + "ULTRA-HARDCORE", 1, Arrays.asList("", ChatColor.YELLOW + "Left Click" + ChatColor.GRAY + " to join!", "")));
        inv.setItem(15, ItemBuilder.build(Material.STONE_AXE, ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ">> " + ChatColor.RESET.toString() + ChatColor.BOLD + "GLITCH CRAFT", 1, Arrays.asList("", ChatColor.GRAY + "Left Click" + ChatColor.GRAY + " to join!", "")));
        p.openInventory(inv);
    }

    public static Inventory getInventory() {
        return inv;
    }

}
