package com.randompvp.hub.GUIs;

import RandomPvP.Core.Player.PlayerManager;
import RandomPvP.Core.Player.RPlayer;
import RandomPvP.Core.RPICore;
import RandomPvP.Core.Util.ItemBuilder;
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
public class StatsGUI implements Listener {

    private static Inventory inv;

    public StatsGUI(Player p) {
        Bukkit.getServer().getPluginManager().registerEvents(this, RPICore.getInstance());

        inv = Bukkit.getServer().createInventory(p, 27, ChatColor.GRAY.toString() + ChatColor.ITALIC + "Profile Page");
        {
            for (int i = 0; i < 27; i++) {
                inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
            }
            try {
                RPlayer rp = PlayerManager.getInstance().getPlayer(p);
                inv.setItem(0, ItemBuilder.build(Material.ARROW, ChatColor.DARK_GRAY + "< Go Back <", 1));
                inv.setItem(11, ItemBuilder.build(Material.PAPER, ChatColor.RED + "RandomPvP ID", 1, Arrays.asList(ChatColor.GRAY + "Your RPID is " + ChatColor.RED + rp.getRPID() + ChatColor.GRAY + ".")));
                inv.setItem(13, ItemBuilder.build(Material.BEACON, ChatColor.RED + "Rank", 1, Arrays.asList(ChatColor.GRAY + "Your current rank is " + ChatColor.RED + rp.getRank() + ChatColor.GRAY + ".")));
                inv.setItem(15, ItemBuilder.build(Material.REDSTONE, ChatColor.RED + "Credits", 1, Arrays.asList(ChatColor.GRAY + "Your balance is " + ChatColor.RED + rp.getCredits() + ChatColor.GRAY + ".")));
            } catch (Exception ex) {
                p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " + ChatColor.GRAY + "An error occurred while retrieving your data.");
                ex.printStackTrace();
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getInventory().equals(getInventory())) {
            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                if(e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getItemMeta().hasDisplayName()) {
                        if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("< Go Back <")) {
                            e.getWhoClicked().closeInventory();
                            e.getWhoClicked().openInventory(ProfileGUI.getInventory());
                        }
                    }
                }
            }
        }
    }

    public Inventory getInventory() {
        return inv;
    }

}
