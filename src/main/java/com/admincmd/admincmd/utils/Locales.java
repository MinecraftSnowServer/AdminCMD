/*
 * This file is part of AdminCMD
 * Copyright (C) 2015 AdminCMD Team
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
package com.admincmd.admincmd.utils;

import com.admincmd.admincmd.Main;
import com.admincmd.admincmd.utils.Utils;
import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;

public enum Locales {

    MESSAGE_PREFIX_INFO("Prefix.Info", "&a[INFO]&7 "),
    MESSAGE_PREFIX_ERROR("Prefix.Error", "&4[ERROR]&7 "),
    COMMAND_MESSAGES_WRONG_SENDER_TYPE("CommandMessages.WrongSenderType", "&4You can't execute this Command!"),
    COMMAND_MESSAGES_NO_PERMISSION("CommandMessages.NoPermission", "&4[ERROR] &7You don't have permission to do that! &c(%perm%)"),
    COMMAND_MESSAGES_NO_PERMISSION_OTHER("CommandMessages.NoPermissionOther", "&4[ERROR] &7You don't have permission to do that! &c(%perm%.other)"),
    COMMAND_MESSAGES_WRONG_USAGE("CommandMessages.WrongUsage", "&c[ERROR] &7Wrong usage! Please use &6/%cmd% help &7 to see the correct usage!"),
    COMMAND_MESSAGES_NOT_ONLINE("CommandMessages.TargetNotFound", "&c[ERROR] &7That player is not online."),
    COMMAND_MESSAGES_NOT_A_NUMBER("CommandMessages.NotANumber", "&c[ERROR] &7This is not a number!"),
    COMMAND_MESSAGES_NOT_A_WORLD("CommandMessages.WorldNotFound", "&c[ERROR] &7The world is not existing!"),
    COMMAND_MESSAGES_ENABLED("CommandMessages.Enabled", "enabled"),
    COMMAND_MESSAGES_DISABLED("CommandMessages.Disabled", "disabled"),
    COMMAND_MESSAGES_NOT_A_MOB("CommandMessages.NotAMob", "This is not a mob!"),
    COMMAND_MESSAGES_NOT_SPAWNABLE("CommandMessages.NotSpawnable", "This mob is not spawnable!"),
    HELP("Help.Help", "Help"),
    HELP_SERVER_ACRELOAD_1("Help.Server.Reload.1", "Reloads the whole server."),
    HELP_SERVER_ACRELOAD_2("Help.Server.Reload.2", "Reloads a single plugin."),
    HELP_PLAYER_CW_1("Help.Player.CW.1", "Toggles commandwatcher"),
    HELP_PLAYER_CW_2("Help.Player.CW.2", "Toggles commandwatcher for the player"),
    HELP_PLAYER_FLY_1("Help.Player.Fly.1", "Toggles flying"),
    HELP_PLAYER_FLY_2("Help.Player.Fly.2", "Toggles flying for the player"),
    HELP_PLAYER_GOD_1("Help.Player.God.1", "Toggles godmode"),
    HELP_PLAYER_GOD_2("Help.Player.God.2", "Toggles godmode for the player"),
    HELP_TELEPORT_HOME_1("Help.Home.Home.1", "List's all homes"),
    HELP_TELEPORT_HOME_2("Help.Home.Home.2", "Teleports you to the given home"),
    HELP_TELEPORT_SETHOME_1("Help.Home.Sethome.1", "Creates a new home at your location with the given name"),
    HELP_TELEPORT_EDITHOME_1("Help.Home.Edithome.1", "Sets the location of the given home to your location"),
    HELP_TELEPORT_DELHOME_1("Help.Home.Delhome.1", "Deletes the given home"),
    HELP_WORLD_SUN_1("Help.World.Sun.1", "Sets the weather to sun in your current world."),
    HELP_WORLD_SUN_2("Help.World.Sun.2", "Sets the weather to sun in the given world"),
    HELP_WORLD_DAY_1("Help.World.Day.1", "Sets the time to daytime in your current world."),
    HELP_WORLD_DAY_2("Help.World.Day.2", "Sets the time to daytime in the given world"),
    HELP_WORLD_NIGHT_1("Help.World.Night.1", "Sets the time to nighttime in your current world."),
    HELP_WORLD_NIGHT_2("Help.World.Night.2", "Sets the time to nighttime in the given world"),
    HELP_WORLD_TIME_1("Help.World.Time.1", "Sets the time to daytime in your current world or the given world"),
    HELP_WORLD_TIME_2("Help.World.Time.2", "Sets the time to nighttime in your current world or the given world"),
    HELP_WORLD_TIME_3("Help.World.Time.3", "Sets the time to the given time in your current world or the given world"),
    HELP_WORLD_TIME_4("Help.World.Time.4", "Pauses the time in your current world or the given world"),
    HELP_WORLD_TIME_5("Help.World.Time.5", "Unpauses the time in your current world or the given world"),
    HELP_MOB_KILLALL_1("Help.Mob.Killall.1", "Kills all the mobs in your or the given world"),
    HELP_MOB_SPAWNMOB_1("Help.Mob.Spawnmob.1", "Spawns the given mob the given amount times to the Locfation you are looking to"),
    HOME_HOME("Home.Home", "Homes"),
    HOME_SET("Home.Set", "The home was added."),
    HOME_DELETED("Home.Deleted", "The home %home% was deleted."),
    HOME_UPDATED("Home.Updated", "The home was updated to your current location."),
    HOME_NOHOME("Home.NoHome", "You have not set this home. Try /home to list your homes."),
    HOME_ALREADY_EXISTING("Home.AlreadyExisting", "This home is already existing! Try /home to list all homes."),
    PLAYER_CW_TOGGLED("Player.CW.Toggled", "Your commandwatcher is now %status%"),
    PLAYER_CW_TOGGLED_OTHER("Player.CW.ToggledOther", "%player%'s commandwatcher is now %status%"),
    PLAYER_CW_RAN("Player.CW.Ran", "%player% ran Command: %command%"),
    PLAYER_GOD_TOGGLED("Player.God.Toggled", "Your godmode is now %status%"),
    PLAYER_GOD_TOGGLED_OTHER("Player.God.ToggledOther", "%player%'s godmode is now %status%"),
    PLAYER_FLY_TOGGLED("Player.Fly.Toggled", "Your fly mode is now %status%"),
    PLAYER_FLY_TOGGLED_OTHER("Player.Fly.ToggledOther", "%player%'s fly mode is now %status%"),
    SERVER_RELOAD_FULL("Server.Reload.Full", "The server has been reloaded."),
    SERVER_RELOAD_NOT_FOUND("Server.Reload.NotFound", "There is no plugin by that name installed."),
    SERVER_RELOAD_SINGLE("Server.Reload.Single", "The plugin has been reloaded."),
    WORLD_WEATHER_CLEAR("World.Weather.Sun", "The weather in %world% was set to sun"),
    WORLD_TIME_PAUSED("World.Time.Pause", "The time in world %world% is now paused."),
    WORLD_TIME_UNPAUSED("World.Time.Unpause", "The time in world %world% is now unpaused."),
    WORLD_TIME_SET("World.Time.Set", "The time in world %world% has been set to %time%."),
    WORLD_DAY_SET("World.Day.Set", "The time in world %world% has been set to daytime."),
    WORLD_NIGHT_SET("World.Night.Set", "The time in world %world% has been set to nighttime."),
    MOB_KILLALL("Mob.Killall" , "%num% mobs have been killed in world %world%."),
    MOB_SPAWNED("Mob.Spawn", "%num% mobs have been spawned at the location you are looking too.");

    private Locales(String path, Object val) {
        this.path = path;
        this.value = val;
    }

    private final Object value;
    private final String path;
    private static YamlConfiguration cfg;
    private static final File f = new File(Main.getInstance().getDataFolder(), "locales.yml");

    public String getPath() {
        return path;
    }

    public Object getDefaultValue() {
        return value;
    }

    public String getString() {
        return Utils.replaceColors(cfg.getString(path));
    }

    public static void load() {
        Main.getInstance().getDataFolder().mkdirs();
        reload(false);
        for (Locales c : values()) {
            if (!cfg.contains(c.getPath())) {
                c.set(c.getDefaultValue(), false);
            }
        }
        try {
            cfg.save(f);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void set(Object value, boolean save) {
        cfg.set(path, value);
        if (save) {
            try {
                cfg.save(f);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            reload(false);
        }
    }

    public static void reload(boolean complete) {
        if (!complete) {
            cfg = YamlConfiguration.loadConfiguration(f);
            return;
        }
        load();
    }

}
