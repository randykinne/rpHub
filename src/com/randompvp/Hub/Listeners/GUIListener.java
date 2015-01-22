package com.randompvp.Hub.Listeners;

import RandomPvP.Core.Game.Game;
import RandomPvP.Core.Player.RPlayer;
import RandomPvP.Core.Player.RPlayerManager;
import com.randompvp.Hub.GUIs.GameMenuGUI;
import com.randompvp.Hub.GUIs.ProfileGUI;
import com.randompvp.Hub.GUIs.ShopGUI;
import com.randompvp.Hub.GUIs.StatsGUI;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class GUIListener implements Listener {

    private void sendToServer(Player p, String servername) {
        try {
            RPlayer rp = RPlayerManager.getInstance().getPlayer(p);
            rp.send(servername);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getCurrentItem() != null) {
            if(e.getCurrentItem().hasItemMeta()) {
                if(e.getCurrentItem().getItemMeta().hasDisplayName()) {
                    if(e.getInventory().equals(ShopGUI.getInventory()) || e.getInventory().equals(StatsGUI.getInventory())) {
                        if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Close")) {
                            p.closeInventory();
                        } else if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("1 Day Credit Booster")) {
                            p.closeInventory();
                            p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " + ChatColor.GRAY + "Sorry! This item is coming soon!");
                        }
                    } else if(e.getInventory().equals(GameMenuGUI.getInventory())) {
                        e.setCancelled(true);
                        if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals(">> PVPACADEMY")) {
                            p.closeInventory();
                            sendToServer(p, "PA");
                        } else if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals(">> ULTRA-HARDCORE")) {
                            p.sendMessage("uhc");
                            p.closeInventory();
                            p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " + ChatColor.GRAY + "Sorry! This game is coming soon!");
                        } else if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals(">> GLITCH CRAFT")) {
                            p.closeInventory();
                            p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " + ChatColor.GRAY + "Sorry! This game is coming soon!");
                        }
                    } else if(e.getInventory().equals(ProfileGUI.getInventory())) {
                        e.setCancelled(true);
                        if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Stats")) {
                            p.closeInventory();
                            new StatsGUI(p);
                        } else if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Credits Shop")) {
                            p.closeInventory();
                            new ShopGUI(p);
                        }
                    }
                }
            }
        }
    }

}
