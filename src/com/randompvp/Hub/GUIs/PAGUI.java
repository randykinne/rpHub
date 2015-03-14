package com.randompvp.hub.GUIs;

import RandomPvP.Core.Util.GUI.GameGUI;
import RandomPvP.Core.Util.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class PAGUI {

    private static GameGUI gui = new GameGUI(ChatColor.GRAY.toString() + ChatColor.GRAY + "Game Menu - PvPAcademy", "pvpacademy", "PA",
            ItemBuilder.build(Material.DIAMOND_SWORD, ChatColor.DARK_RED.toString() + ChatColor.BOLD + ">> " +
                    ChatColor.RESET.toString() + ChatColor.BOLD + "PVPACADEMY", 1), GameMenuGUI.getInventory());

    public static Inventory getInventory() {
        return gui.getInventory();
    }

    public static GameGUI getGui() {
        return gui;
    }

}
