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
public class ShopGUI {

    //coming soon

    public ShopGUI(Player p) {
        IconMenu menu = new IconMenu(ChatColor.GRAY.toString() + ChatColor.ITALIC + "Shop Page", 27, new IconMenu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(IconMenu.OptionClickEvent e) {
                e.setWillDestroy(true);
                e.setWillDestroy(true);
            }
        }, RPICore.getInstance());
        menu.setSpecificTo(p);
        for(int i=0; i < 27; i++) {
            menu.setOption(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7), "");
        }
        menu.setOption(13, new ItemStack(Material.BEDROCK, 1), ChatColor.YELLOW + "Coming soon!", ChatColor.GRAY + "This feature is coming soon");
        menu.open(p);
    }

}
