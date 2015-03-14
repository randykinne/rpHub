package com.randompvp.hub.GUIs;

import RandomPvP.Core.Util.GUI.GameGUI;
import RandomPvP.Core.Util.ItemBuilder;
import net.md_5.bungee.api.ChatColor;
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
public class HubsGUI {

    private static GameGUI gui =
            new GameGUI("Hub Selector", "hub", "h", ItemBuilder.build(Material.WATCH, ChatColor.DARK_RED.toString()
                    + ChatColor.BOLD + "HUB SELECTOR"), GameMenuGUI.getInventory());;

    public static GameGUI getGui() {
        return gui;
    }

    public static Inventory getInventory() {
        return gui.getInventory();
    }

}
