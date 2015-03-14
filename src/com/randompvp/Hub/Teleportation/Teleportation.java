package com.randompvp.hub.Teleportation;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class Teleportation {

    public void teleportToSpawn(Player p) {
        Location loc = new Location(p.getWorld(), 878.5, 16, 265.5);
        p.teleport(loc);
    }

}
