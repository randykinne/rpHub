package com.randompvp.hub.Scoreboard;

import RandomPvP.Core.Player.PlayerManager;
import RandomPvP.Core.Player.RPlayer;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class Scoreboard {

    public static org.bukkit.scoreboard.Scoreboard getScoreboard(Player p) {
        RPlayer rp = PlayerManager.getInstance().getPlayer(p);
        ScoreboardManager sb = Bukkit.getServer().getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard hub = sb.getNewScoreboard();
        Objective obj = hub.registerNewObjective("hub", "dummy");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.GRAY + "RP " + ChatColor.DARK_GRAY + "-" + ChatColor.DARK_RED.toString() + ChatColor.BOLD + " Hub 1");

        Score score1 = score1 = obj.getScore(ChatColor.RED + "Credits ");
        try {
            score1.setScore(rp.getCredits());
        } catch (Exception ex) {
            score1.setScore(0);
            ex.printStackTrace();
        }

        return hub;
    }

}
