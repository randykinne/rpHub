package com.randompvp.Hub.GUIs;

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
public class ProfileGUI {

    public ProfileGUI(Player p) {
        IconMenu menu = new IconMenu(ChatColor.GRAY.toString() + ChatColor.ITALIC + "Profile Page", 27, new IconMenu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(IconMenu.OptionClickEvent e) {
                Player c = e.getPlayer();
                if(e.getPosition() == 11) {
                    new StatsGUI(c);
                } else if(e.getPosition() == 15) {
                    new ShopGUI(c);
                }
                e.setWillDestroy(true);
                e.setWillDestroy(true);
            }
        }, RPICore.getInstance());
        menu.setSpecificTo(p);
        for(int i=0; i < 27; i++) {
            menu.setOption(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), "");
        }
        menu.setOption(11, new ItemStack(Material.PAPER, 1), ChatColor.RED + "Stats", ChatColor.GRAY + "Click to view your stats");
        menu.setOption(15, new ItemStack(Material.CHEST, 1), ChatColor.RED + "Credits Shop", ChatColor.GRAY + "Click to view the credits shop");
        menu.open(p);
    }

}
