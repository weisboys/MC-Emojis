package me.weisboys.mcemojis;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {
    
     private MCEmojis emojis;
    
    public HelpCommand(MCEmojis emojis) {
        this.emojis = emojis;
    }
    
    public boolean onCommand​(CommandSender sender, Command command, String label, String[] args){
        
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + "MCEmojis");
        sender.sendMessage(ChatColor.GOLD + "Commands");
        //list commands
        
        
        return true;
    }
}
