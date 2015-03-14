package com.randompvp.hub.Villagers;

import RandomPvP.Core.Util.Entity.Villager.GameVillager.GameVillager;
import com.randompvp.hub.GUIs.PAGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class PAVillager {

    public static void spawn() {
        new GameVillager(new Location(Bukkit.getWorld("Hub"), 878.5, 15, 274.5), ChatColor.DARK_RED.toString() + ChatColor.BOLD + "PVPACADEMY", PAGUI.getInventory());
    }

}
