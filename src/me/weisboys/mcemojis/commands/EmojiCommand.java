package me.weisboys.mcemojis.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;


public interface EmojiCommand {
    
     public boolean onCommandâ€‹(CommandSender sender, String[] args);
     public String getName();
     public String getUsage();
}
