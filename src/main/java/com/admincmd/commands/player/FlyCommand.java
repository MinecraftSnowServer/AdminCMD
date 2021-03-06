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
package com.admincmd.commands.player;

import com.admincmd.commandapi.BaseCommand;
import com.admincmd.commandapi.CommandArgs;
import com.admincmd.commandapi.CommandHandler;
import com.admincmd.commandapi.CommandResult;
import com.admincmd.player.BukkitPlayer;
import com.admincmd.player.PlayerManager;
import com.admincmd.utils.Locales;
import com.admincmd.utils.Messager;
import com.admincmd.utils.Utils;
import org.bukkit.entity.Player;

@CommandHandler
public class FlyCommand {

    @BaseCommand(command = "fly", sender = BaseCommand.Sender.PLAYER, permission = "admincmd.player.fly", aliases = "f", helpArguments = {"", "<-p player>"})
    public CommandResult executeFly(Player sender, CommandArgs args) {
        if (args.isEmpty()) {
            BukkitPlayer p = PlayerManager.getPlayer(sender);
            p.setFly(!p.isFly());

            sender.setAllowFlight(p.isFly());
            String s = p.isFly() ? Locales.COMMAND_MESSAGES_ENABLED.getString() : Locales.COMMAND_MESSAGES_DISABLED.getString();
            String msg = Locales.PLAYER_FLY_TOGGLED.getString().replaceAll("%status%", s);
            return Messager.sendMessage(sender, msg, Messager.MessageType.INFO);
        }

        if (args.hasFlag("p")) {
            if (!sender.hasPermission("admincmd.player.fly.other")) {
                return CommandResult.NO_PERMISSION_OTHER;
            }
            CommandArgs.Flag flag = args.getFlag("p");
            if (!flag.isPlayer()) {
                return CommandResult.NOT_ONLINE;
            }

            Player target = flag.getPlayer();
            BukkitPlayer p = PlayerManager.getPlayer(target);
            p.setFly(!p.isFly());

            target.setAllowFlight(p.isFly());
            String s = p.isFly() ? Locales.COMMAND_MESSAGES_ENABLED.getString() : Locales.COMMAND_MESSAGES_DISABLED.getString();
            String msg = Locales.PLAYER_FLY_TOGGLED_OTHER.getString().replaceAll("%status%", s).replaceAll("%player%", Utils.replacePlayerPlaceholders(target));
            String msg2 = Locales.PLAYER_FLY_TOGGLED.getString().replaceAll("%status%", s);
            Messager.sendMessage(target, msg2, Messager.MessageType.INFO);
            return Messager.sendMessage(sender, msg, Messager.MessageType.INFO);
        }

        return CommandResult.ERROR;
    }

}
