package com.randompvp.hub.GUIs;

import RandomPvP.Core.Player.MsgType;
import RandomPvP.Core.Player.PlayerManager;
import RandomPvP.Core.Player.RPlayer;
import RandomPvP.Core.Player.Rank.Rank;
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
import sun.plugin.net.protocol.jar.CachedJarURLConnection;

import java.util.Arrays;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class GameMenuGUI implements Listener {

    private static Inventory inv;

    public static void setup() {
        inv = Bukkit.getServer().createInventory(null, 45, ChatColor.GRAY.toString() + ChatColor.ITALIC + "Game Menu");
        {
            for (int i = 0; i < 45; i++) {
                if(!(i > 9 && i < 17) && !(i > 18 && i < 26) && !(i > 27 && i < 35)) {
                    inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7));
                }
            }
            inv.setItem(20, ItemBuilder.build(Material.DIAMOND_SWORD, ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " + ChatColor.RESET.toString() + ChatColor.BOLD + "PVPACADEMY",
                    1, Arrays.asList("", ChatColor.RED + "Left Click" + ChatColor.GRAY + " to select a server!", "")));
            inv.setItem(22, ItemBuilder.build(Material.BOAT, ChatColor.GOLD.toString() + ChatColor.BOLD + ">> " + ChatColor.RESET.toString() + ChatColor.BOLD + "PIRATE WARS",
                    1, Arrays.asList("", ChatColor.YELLOW + "Left Click" + ChatColor.GRAY + " to select a server!", "")));
            inv.setItem(24, ItemBuilder.build(Material.STONE_AXE, ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ">> " + ChatColor.RESET.toString() + ChatColor.BOLD + "GLITCH CRAFT",
                    1, Arrays.asList("", ChatColor.GRAY + "Left Click" + ChatColor.GRAY + " to select a server!", "")));
            inv.setItem(40, ItemBuilder.build(Material.WATCH, ChatColor.DARK_RED.toString() + ChatColor.BOLD + "HUB SELECTOR",
                    1, Arrays.asList("", ChatColor.DARK_RED + "Left Click" + ChatColor.GRAY + " to select a hub!", "")));
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getInventory().equals(getInventory())) {
            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                if(e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getItemMeta().hasDisplayName()) {
                        RPlayer p = PlayerManager.getInstance().getPlayer((Player) e.getWhoClicked());
                        if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals(">> PVPACADEMY")) {
                            e.getWhoClicked().closeInventory();
                            e.getWhoClicked().openInventory(PAGUI.getInventory());
                        } else if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals(">> PIRATE WARS")) {
                            e.getWhoClicked().closeInventory();
                            p.message(MsgType.ERROR, "This game is coming soon!");
                        } else if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals(">> GLITCH CRAFT")) {
                            e.getWhoClicked().closeInventory();
                            p.message(MsgType.ERROR, "This game is coming soon!");
                        } else if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("HUB SELECTOR")) {
                            if(p.has(Rank.PREMIUM)) {
                                e.getWhoClicked().closeInventory();
                                e.getWhoClicked().openInventory(HubsGUI.getInventory());
                            } else {
                                p.message(MsgType.ERROR, "Only premium members can switch hubs!");
                            }
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
