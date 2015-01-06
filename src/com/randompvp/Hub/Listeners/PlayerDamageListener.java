package com.randompvp.Hub.Listeners;

import com.randompvp.Hub.Teleportation.TpToSpawn;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class PlayerDamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(e.getCause() == EntityDamageEvent.DamageCause.VOID) {
                e.setCancelled(true);
                new TpToSpawn(p);
            } else {
                e.setCancelled(true);
            }
        }
    }

}
