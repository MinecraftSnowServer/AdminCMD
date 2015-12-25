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
package com.admincmd.admincmd.commandapi;

import com.admincmd.admincmd.utils.Locales;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.CommandSender;

public class HelpPage {

    public HelpPage(String command, String... arguments) {
        this.command = command;

        for (int i = 0; i < arguments.length; i++) {
            int num = i + 1;

            for (Locales loc : Locales.values()) {
                if (!loc.toString().toLowerCase().contains("help")) {
                    continue;
                }

                String[] l = loc.toString().toLowerCase().split("_");

                for (String s : l) {                  
                    if (!s.equalsIgnoreCase(command)) {
                        continue;
                    }
                    if (loc.toString().toLowerCase().contains("" + num)) {
                        if (arguments[i].isEmpty()) {
                            addPage(arguments[i], loc.getString());
                        } else {
                            addPage(" " + arguments[i], loc.getString());
                        }
                    }
                }

            }
        }

        if (helpPages == null || helpPages.isEmpty()) {
            return;
        }
        HELP_TEXT.add("§a------------------------§1" + Locales.HELP.getString() + "§a-------------------------");
        for (CommandHelp ch : helpPages) {
            HELP_TEXT.add("§6/" + ch.getText());
        }
        HELP_TEXT.add("§a-----------------------------------------------------");
    }

    private final List<CommandHelp> helpPages = new ArrayList<>();
    private final List<String> HELP_TEXT = new ArrayList<>();
    private final String command;

    private void addPage(String argument, String description) {
        helpPages.add(new CommandHelp(command + argument, description));
    }

    public boolean sendHelp(CommandSender s, CommandArgs args) {
        if (args.getLength() == 1 && (args.getString(0).equalsIgnoreCase("?") || args.getString(0).equalsIgnoreCase("help")) && !HELP_TEXT.isEmpty()) {
            for (String string : HELP_TEXT) {
                s.sendMessage(string);
            }
            return true;
        }
        return false;
    }

    private class CommandHelp {

        private final String FULL_TEXT;

        public CommandHelp(String cmd, String description) {
            this.FULL_TEXT = "§6" + cmd + "§7" + " - " + description;
        }

        public String getText() {
            return FULL_TEXT;
        }

    }

}
