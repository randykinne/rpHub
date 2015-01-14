package com.randompvp.Hub.GUIs;

import RandomPvP.Core.Player.RPlayer;
import RandomPvP.Core.Player.RPlayerManager;
import RandomPvP.Core.RPICore;
import RandomPvP.Core.Util.GUI.IconMenu;
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
public class StatsGUI {

    public StatsGUI(Player p) {
        IconMenu menu = new IconMenu(ChatColor.GRAY.toString() + ChatColor.ITALIC + "Stats Page", 27, new IconMenu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(IconMenu.OptionClickEvent e) {
                Player c = e.getPlayer();
                if(e.getPosition() == 0) {
                    new ProfileGUI(c);
                }
                e.setWillDestroy(true);
                e.setWillDestroy(true);
            }
        }, RPICore.getInstance());
        menu.setSpecificTo(p);
        for(int i=0; i < 27; i++) {
            menu.setOption(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), "");
        }
        try {
            RPlayer rp = RPlayerManager.getInstance().getPlayer(p);
            menu.setOption(0, new ItemStack(Material.ARROW, 1), ChatColor.DARK_GRAY + "< Go Back <");
            menu.setOption(11, new ItemStack(Material.PAPER, 1), ChatColor.RED + "RandomPvP ID", ChatColor.GRAY + "Your RPID is " + ChatColor.RED + rp.getRPID() + ChatColor.GRAY + ".");
            menu.setOption(13, new ItemStack(Material.BEACON, 1), ChatColor.RED + "Rank", ChatColor.GRAY + "Your current rank is " + ChatColor.RED + rp.getRank() + ChatColor.GRAY + ".");
            menu.setOption(15, new ItemStack(Material.REDSTONE, 1), ChatColor.RED + "Credits", ChatColor.GRAY + "Your balance is " + ChatColor.RED + rp.getCredits() + ChatColor.GRAY + ".");
        } catch (Exception ex) {
            p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " + ChatColor.RED + "An error occurred while retrieving your data.");
            menu.destroy();
            ex.printStackTrace();
            return;
        }
        menu.open(p);
    }

}
