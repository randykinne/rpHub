package com.randompvp.hub.Gizmos;

import RandomPvP.Core.Data.MySQL;
import RandomPvP.Core.Player.RPlayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class GizmoBase {

    public void addGizmo(Gizmo gizmo, RPlayer p) {
        try {
            PreparedStatement stmt = MySQL.getConnection().prepareStatement("SELECT * FROM `gizmos` WHERE `rpid`=?;");
            stmt.setInt(1, p.getRPID());
            ResultSet res = stmt.executeQuery();
            if(res.next()) {
                PreparedStatement update = MySQL.getConnection().prepareStatement("UPDATE `gizmos` SET `gizmos`=? WHERE `rpid`=?;");
                update.setString(1, getGizmos(p) + "|" + gizmo.getName());
                update.setInt(2, p.getRPID());
                update.executeUpdate();
            } else {
                PreparedStatement add = MySQL.getConnection().prepareStatement("INSERT INTO `gizmos` (?,?);");
                add.setInt(1, p.getRPID());
                add.setString(2, "|" + gizmo.getName());
                add.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String[] getGizmosArray(RPlayer p) {
        return getGizmos(p).split("\\|");
    }

    public String getGizmos(final RPlayer p) {
        try {
            Future<String> task = Executors.newCachedThreadPool().submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    PreparedStatement stmt = MySQL.getConnection().prepareStatement("SELECT * FROM `gizmos` WHERE `rpid`=?");
                    stmt.setInt(1, p.getRPID());
                    ResultSet res = stmt.executeQuery();
                    if(res.next()) {
                        return res.getString("gizmos");
                    }
                    return null;
                }
            });
            return task.get();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
