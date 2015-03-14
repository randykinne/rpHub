package com.randompvp.hub.Listeners;

import RandomPvP.Core.Game.GameManager;
import RandomPvP.Core.Player.PlayerManager;
import RandomPvP.Core.Player.RPlayer;
import RandomPvP.Core.Player.Rank.Rank;
import RandomPvP.Core.Player.Scoreboard.RandomPvPScoreboard;
import RandomPvP.Core.RPICore;
import com.randompvp.hub.Items.LobbyItems;
import com.randompvp.hub.Scoreboard.Scoreboard;
import com.randompvp.hub.Teleportation.Teleportation;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class PlayerListeners implements Listener {

    @EventHandler
    public void onFoodDrop(FoodLevelChangeEvent e) {
        if(e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(e.getCause() == EntityDamageEvent.DamageCause.VOID) {
                e.setCancelled(true);
                new Teleportation().teleportToSpawn(p);
            } else {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if(e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if(e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        final RPlayer rp = PlayerManager.getInstance().getPlayer(p);
        new Teleportation().teleportToSpawn(p);
        p.getInventory().clear();
        p.setFoodLevel(20);
        p.setSaturation(20);
        new BukkitRunnable() {
            public void run() {
                new LobbyItems().setItems(p);
                p.setScoreboard(Scoreboard.getScoreboard(p));
                p.sendMessage("");
                {
                    p.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ">> " + ChatColor.RED + "Welcome to the "
                            + ChatColor.DARK_RED.toString() + ChatColor.BOLD + "RandomPvP " + ChatColor.RED + "Hub!");
                    if (rp.getRank().has(Rank.PREMIUM)) {
                        p.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ">> " + ChatColor.RED + "Thank you for your support! "
                                + ChatColor.AQUA + "Premium " + ChatColor.RED + "players keep us going!");
                    } else {
                        p.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ">> " + ChatColor.RED + "Please purchase" + ChatColor.AQUA
                                + " Premium " + ChatColor.RED + "to unlock all features!");
                    }
                }
                p.sendMessage("");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 2F, 1F);
            }
        }.runTaskLater(RPICore.getInstance(), 30L);
    }

}
