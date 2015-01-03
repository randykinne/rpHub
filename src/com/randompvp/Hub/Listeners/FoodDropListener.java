package com.randompvp.Hub.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class FoodDropListener implements Listener {

    @EventHandler
    public void onFoodDrop(FoodLevelChangeEvent e) {
        if(e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

}
