package com.randompvp.Hub.ServerBase;

import RandomPvP.Core.Data.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ****************************************************************************************
 * All code contained within this document is sole property of WesJD. All rights reserved.*
 * Do NOT distribute/reproduce any of this code without permission from WesJD.            *
 * Not following this statement will result in a void of all agreements made.             *
 * Enjoy.                                                                                 *
 * ****************************************************************************************
 */
public class ServerBase {

    public ServerBase() {
        try {
            //TODO finish this
            //PreparedStatement stmt = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS servers ('id', '')");
            PreparedStatement placeholder = MySQL.getConnection().prepareStatement("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getServerData(int i) {
        try {
            PreparedStatement stmt = MySQL.getConnection().prepareStatement("SELECT * FROM servers WHERE serverid=?");
            stmt.setString(0, i + "");

            return stmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int getServerAmount() {
        try {
            PreparedStatement stmt = MySQL.getConnection().prepareStatement("SELECT MAX(PRIMARY_KEY) FROM servers");
            ResultSet res = stmt.executeQuery();
            while(res.next()) {
                return res.getInt("id");
            }
            res.close();
            stmt.close();
            return 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }


}
