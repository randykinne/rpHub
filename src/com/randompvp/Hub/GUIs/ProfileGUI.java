package com.randompvp.hub.GUIs;

import RandomPvP.Core.Util.ItemBuilder;
import com.randompvp.hub.Friends.GUIs.FriendsGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
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
public class ProfileGUI implements Listener {

    private static Inventory inv;

    public static void setup() {
        inv = Bukkit.getServer().createInventory(null, 45, ChatColor.GRAY.toString() + ChatColor.ITALIC + "Profile Page");
        {
            for (int i = 0; i < 45; i++) {
                if(!(i > 9 && i < 17) && !(i > 18 && i < 26) && !(i > 27 && i < 35)) {
                    inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
                }
            }
            inv.setItem(20, ItemBuilder.build(Material.PAPER, ChatColor.RED + "Stats", 1, Arrays.asList(ChatColor.GRAY + "Click to view your stats")));
            inv.setItem(22, ItemBuilder.build(Material.SKULL_ITEM, ChatColor.RED + "Friends", 1, Arrays.asList(ChatColor.GRAY + "Click to view your friends")));
            inv.setItem(24, ItemBuilder.build(Material.CHEST, ChatColor.RED + "Shop", 1, Arrays.asList(ChatColor.GRAY + "Click to view the shop")));
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getInventory().equals(getInventory())) {
            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                if(e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getItemMeta().hasDisplayName()) {
                        if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Stats")) {
                            e.getWhoClicked().closeInventory();
                            e.getWhoClicked().openInventory(new StatsGUI((Player) e.getWhoClicked()).getInventory());
                        } else if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Shop")) {
                            e.getWhoClicked().closeInventory();
                            ((Player) e.getWhoClicked()).performCommand("shop");
                        } else if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Friends")) {
                            e.getWhoClicked().closeInventory();
                            e.getWhoClicked().openInventory(new FriendsGUI((Player) e.getWhoClicked()).getInventory());
                        }
                    }
                }
            }
        }
    }

    public static Inventory getInventory() {
        return inv;
    }

}
