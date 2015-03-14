package com.randompvp.hub;

import RandomPvP.Core.Game.Game;
import RandomPvP.Core.Game.GameManager;
import RandomPvP.Core.Game.GameState.GameState;
import RandomPvP.Core.Game.Map.RMap;
import RandomPvP.Core.Game.Mode.Gamemode;
import RandomPvP.Core.Game.Team.Team;
import RandomPvP.Core.Player.PlayerManager;
import RandomPvP.Core.Player.RPlayer;
import RandomPvP.Core.Player.Scoreboard.RandomPvPScoreboard;
import RandomPvP.Core.RPICore;
import RandomPvP.Core.Util.ServerToggles;
import com.randompvp.hub.Commands.FriendsCmd;
import com.randompvp.hub.GUIs.*;
import com.randompvp.hub.Listeners.ItemListeners;
import com.randompvp.hub.Listeners.PlayerListeners;
import com.randompvp.hub.Listeners.WeatherListener;
import com.randompvp.hub.Villagers.PAVillager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

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
        GameManager.setState(GameState.LOBBY);
        GameManager.setGame(this);
        GameManager.setMap(new RMap("Hub", "Unknown", Arrays.asList("RandomPvP"), Bukkit.getWorld("Hub")));
        GameManager.setMode(new Gamemode("Online", 1, ChatColor.GREEN));

        RPICore.getInstance().addListener(new ItemListeners());
        RPICore.getInstance().addListener(new PlayerListeners());
        RPICore.getInstance().addListener(new GameMenuGUI());
        RPICore.getInstance().addListener(new ProfileGUI());
        RPICore.getInstance().addListener(new WeatherListener());

        RPICore.getInstance().addCommand(new FriendsCmd());

        ServerToggles.setPollVoting(true);

        GameMenuGUI.setup();
        ProfileGUI.setup();
        PAGUI.getGui().build();
        HubsGUI.getGui().build();

        PAVillager.spawn();

        return this;
    }

    @Override
    public String getName() {
        return "Hub";
    }

    @Override
    public int getID() {
        return Integer.valueOf(Bukkit.getServerName().replace("H", ""));
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
    public ArrayList<Gamemode> getModes() {
        return null;
    }

    @Override
    public int getMaxPlayers() {
        return 100;
    }

    @Override
    public int getMinPlayers() {
        return 0;
    }

    @Override
    public int getBufferOverflow() { return 100; }
}
