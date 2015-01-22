package com.randompvp.Hub;

import RandomPvP.Core.Game.GameManager;
import RandomPvP.Core.Game.GameState.GameState;
import com.randompvp.Hub.Chat.Annoucements;
import com.randompvp.Hub.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class Main extends JavaPlugin {

    protected static Main plugin;

    @Override
    public void onEnable() {
        GameManager.setState(GameState.LOBBY);

        plugin = this;

        new Annoucements();

        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new FoodDropListener(), this);
        pm.registerEvents(new PlayerLoginListener(), this);
        pm.registerEvents(new ProfileItemListener(), this);
        pm.registerEvents(new GameMenuItemListener(), this);
        pm.registerEvents(new ItemDropListener(), this);
        pm.registerEvents(new ItemPickupListener(), this);
        pm.registerEvents(new BlockBreakListener(), this);
        pm.registerEvents(new PlayerDamageListener(), this);
        pm.registerEvents(new GUIListener(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getScheduler().cancelAllTasks();
        plugin = null;
    }

    public static Plugin getInstance() {
        return plugin;
    }

}
