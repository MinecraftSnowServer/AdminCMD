/*
 * This file is part of AdminCMD
 * Copyright (C) 2017 AdminCMD Team
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.admincmd.player;

import com.admincmd.database.Database;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class BukkitPlayer extends SQLPlayer {

    private Location lastLoc;
    private int lastMsg = -1;

    public BukkitPlayer(OfflinePlayer p, Database db) {
        super(p.getUniqueId(), db);
    }

    public BukkitPlayer(UUID uuid, Database db) {
        super(uuid, db);
    }

    public BukkitPlayer(String uuid, Database db) {
        super(UUID.fromString(uuid), db);
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(getUuid());
    }

    public boolean isOnline() {
        return getPlayer() != null;
    }

    public Location getLastLocation() {
        return lastLoc;
    }

    public void setLastLocation(Location lastLoc) {
        this.lastLoc = lastLoc;
    }

    public boolean hasLastLoc() {
        return lastLoc != null;
    }

    public int getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(int lastMsg) {
        this.lastMsg = lastMsg;
    }

}
