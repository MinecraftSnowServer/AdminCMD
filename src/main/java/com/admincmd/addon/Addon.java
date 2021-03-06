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
package com.admincmd.addon;

import com.admincmd.Main;
import com.admincmd.commandapi.CommandManager;
import com.admincmd.database.Database;
import com.admincmd.database.DatabaseFactory;
import com.admincmd.metrics.Metrics;
import com.admincmd.utils.ACLogger;
import java.io.IOException;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Addon extends JavaPlugin {

    private CommandManager cmdManager;
    private static Addon INSTANCE;

    /**
     * Returns an instance of the AdminCMD main class.
     *
     * @return {@link com.admincmd.Main}
     */
    public Main getAdminCMD() {
        return Main.getInstance();
    }

    /**
     * Returns the loaded database.
     *
     * @return {@link com.admincmd.database.Database}
     */
    public Database getDB() {
        return DatabaseFactory.getDatabase();
    }

    /**
     * Returns the commandmanager for this addon.
     *
     * @return {@link com.admincmd.commandapi.CommandManager}
     */
    public CommandManager getCommandManager() {
        return cmdManager;
    }

    /**
     * Returns an instance of this class.
     *
     * @return {@link com.admincmd.addon.Addon}
     */
    public static Addon getInstance() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {
        INSTANCE = this;
        cmdManager = new CommandManager(this);
        try {
            Metrics m = new Metrics(this);
            m.start();
            ACLogger.info("Enabled Metrics!");
        } catch (IOException ex) {
            ACLogger.severe("Could not enable Metrics!", ex);
        }

        enable();
    }

    @Override
    public void onDisable() {
        disable();
        cmdManager = null;
        INSTANCE = null;
    }

    /**
     * Called in the onEnable Bukkit method after the commandManager is loaded
     * for this addon.
     */
    public abstract void enable();

    /**
     * Called in the onDisable Bukkit method.
     */
    public abstract void disable();

}
