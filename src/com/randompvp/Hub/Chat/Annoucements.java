package com.randompvp.Hub.Chat;

import com.randompvp.Hub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class Annoucements {

    private Random r;
    private String last = "";
    private List<String> messages = Arrays.asList(
            "Follow us on Twitter! " + ChatColor.DARK_RED.toString() + ChatColor.UNDERLINE + "http://twitter.com/RandomPvP",
            "Join the community! " + ChatColor.RED.toString() + ChatColor.UNDERLINE + "http://randompvp.com",
            "This is " + ChatColor.DARK_RED.toString() + ChatColor.BOLD + "PUBLIC BETA" + ChatColor.GRAY + "! Please report bugs on our website!",
            "Quickly switch to different games using the " + ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Game Menu" + ChatColor.GRAY + "!",
            "View your RandomPvP account information using the " + ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Your Profile" + ChatColor.GRAY + " item!",
            "Support the server and purchase " + ChatColor.AQUA + "Premium" + ChatColor.GRAY + " at " + ChatColor.RED.toString() + ChatColor.UNDERLINE + "http://randompvp.com/shop");

    private String getNewMessage() {
        String msg = messages.get(r.nextInt(messages.size()));
        if(last.equals(msg)) {
            return getNewMessage();
        } else {
            last = msg;
            return msg;
        }
    }

    public Annoucements() {
        r = new Random();
        new BukkitRunnable() {
            public void run() {
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + ">> " + ChatColor.GRAY + getNewMessage());
            }
        }.runTaskTimer(Main.getInstance(),20L,2400L);
    }

}
