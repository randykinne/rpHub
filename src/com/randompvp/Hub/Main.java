package com.randompvp.hub;

import RandomPvP.Core.Game.Game;
import RandomPvP.Core.Game.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
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

    @Override
    public void onEnable() {
        Game game = new Hub();
        {
            try {
                game = game.setupGame();
            } catch (Exception e) {
                e.printStackTrace();
                Bukkit.getServer().shutdown();
            }
        }
        System.out.println(getServer().getMotd().replace("§", "&"));
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getScheduler().cancelAllTasks();
        for(Entity e : Bukkit.getWorld("Hub").getEntities()) {
            if(!(e instanceof Player)) {
                e.remove();
            }
        }
    }

}