package com.randompvp.hub.Commands;

import RandomPvP.Core.Commands.Command.RCommand;
import RandomPvP.Core.Player.RPlayer;
import com.randompvp.hub.Friends.GUIs.FriendsGUI;

import java.util.Arrays;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class FriendsCmd extends RCommand {

    public FriendsCmd() {
        super("friends");
        setPlayerOnly(true);
        setMaximumArgs(0);
        setAliases(Arrays.asList("f"));
    }

    @Override
    public void onCommand(RPlayer pl, String s, String[] strings) {
        pl.getPlayer().openInventory(new FriendsGUI(pl.getPlayer()).getInventory());
    }

}
