package com.randompvp.Hub.Listeners;

import RandomPvP.Core.Player.RPlayer;
import RandomPvP.Core.Player.RPlayerManager;
import RandomPvP.Core.Player.Rank.Rank;
import RandomPvP.Core.RPICore;
import com.randompvp.Hub.Items.LobbyItems;
import com.randompvp.Hub.Scoreboard.Scoreboard;
import com.randompvp.Hub.Teleportation.TpToSpawn;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class PlayerLoginListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        new TpToSpawn(p);
        p.getInventory().clear();
        p.setFoodLevel(20);
        p.setSaturation(20);
        new BukkitRunnable() {
            public void run() {
                new LobbyItems(p);
                new Scoreboard(p);
                p.sendMessage("");
                p.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ">> " + ChatColor.RED + "Welcome to the " + ChatColor.DARK_RED.toString() + ChatColor.BOLD + "RandomPvP " + ChatColor.RED + "Hub!");
                try {
                    RPlayer rp = RPlayerManager.getInstance().getPlayer(p);
                    if(rp.getRank() == Rank.PREMIUM || rp.getRank() == Rank.VIP || rp.getRank() == Rank.MOD || rp.getRank() == Rank.DEV || rp.getRank() == Rank.ADMIN || rp.getRank() == Rank.OWNER) {
                        p.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ">> " + ChatColor.RED + "Thank you for your support! " + ChatColor.AQUA + "Premium " + ChatColor.RED + "keep us going!");
                    } else {
                        p.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ">> " + ChatColor.RED + "Please purchase " + ChatColor.AQUA + "Premium " + ChatColor.RED + "to unlock all features!");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                p.sendMessage("");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
            }
        }.runTaskLater(RPICore.getInstance(), 60L);
    }

}
