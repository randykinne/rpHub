package com.randompvp.hub.Gizmos;

import RandomPvP.Core.Player.RPlayer;
import org.bukkit.Material;

import java.util.List;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public interface Gizmo {

    public String getName();

    public String getDisplayName();

    public Material getIcon();

    public List<String> getDiscription();

    public int getPrice();

    public void use(RPlayer p);

}
