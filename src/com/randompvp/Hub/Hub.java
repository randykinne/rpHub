package com.randompvp.Hub;

import RandomPvP.Core.Game.Game;
import RandomPvP.Core.Game.Team.Team;
import org.bukkit.ChatColor;
import org.bukkit.World;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ***************************************************************************************
 * Copyright (c) Randomizer27 2014. All rights reserved.
 * All code contained within this document and any APIs assocated are
 * the sole property of Randomizer27. Please do not distribute/reproduce without
 * expressed explicit permission from Randomizer27. Not doing so will break the terms of
 * the license, and void any agreements with you, the third party.
 * Thanks.
 * ***************************************************************************************
 */
public class Hub implements Game {

    @Override
    public Game setupGame() throws SQLException {
        return null;
    }

    @Override
    public int getBufferOverflow() {
        return 0;
    }

    @Override
    public String getName() {
        return "Hub";
    }

    @Override
    public ArrayList<String> getDescription() {
        return null;
    }

    @Override
    public ChatColor getPrimaryColor() {
        return ChatColor.DARK_RED;
    }

    @Override
    public ChatColor getSecondaryColor() {
        return ChatColor.RED;
    }

    @Override
    public void setTeams(ArrayList<Team> teams) {

    }

    @Override
    public boolean isTeamBased() {
        return false;
    }

    @Override
    public void setLobby(World world) {

    }

    @Override
    public int getMaxPlayers() {
        return -1;
    }

    @Override
    public int getMinPlayers() {
        return 0;
    }
}
