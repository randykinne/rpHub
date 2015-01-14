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
public class GameMenuGUI {

    public GameMenuGUI(final Player p) {
        IconMenu menu = new IconMenu(ChatColor.GRAY.toString() + ChatColor.ITALIC + "Game Menu", 27, new IconMenu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(IconMenu.OptionClickEvent e) {
                RPlayer rp = RPlayerManager.getInstance().getPlayer(p);
                if(e.getPosition() == 11) {
                    rp.send("PA1");
                } else if(e.getPosition() == 13) {
                    p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " + ChatColor.RED + "This game is coming to our network shortly.");
                } else if(e.getPosition() == 15) {
                    p.sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " + ChatColor.RED + "This game is coming to our network shortly.");
                }
                e.setWillClose(true);
                e.setWillDestroy(true);
            }
        }, RPICore.getInstance());
        for(int i=0; i < 27; i++) {
            menu.setOption(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), " ", " ");
        }
        menu.setOption(11, new ItemStack(Material.DIAMOND_SWORD, 1), ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " + ChatColor.RESET.toString() + ChatColor.BOLD + "PVPACADEMY", new String[] { "", ChatColor.RED + "Left Click" + ChatColor.GRAY + " to join!", "" });
        menu.setOption(13, new ItemStack(Material.GOLDEN_APPLE, 1), ChatColor.GOLD.toString() + ChatColor.BOLD + ">> " + ChatColor.RESET.toString() + ChatColor.BOLD + "ULTRA-HARDCORE", new String[] { "", ChatColor.YELLOW + "Left Click" + ChatColor.GRAY + " to join!", "" });
        menu.setOption(15, new ItemStack(Material.STONE_AXE, 1), ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ">> " + ChatColor.RESET.toString() + ChatColor.BOLD + "GLITCH CRAFT", new String[] { "", ChatColor.GRAY + "Left Click to join!", "" });
        menu.open(p);
    }

}
