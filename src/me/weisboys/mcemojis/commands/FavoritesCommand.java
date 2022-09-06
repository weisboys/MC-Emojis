package me.weisboys.mcemojis.commands;

import me.weisboys.mcemojis.MCEmojis;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FavoritesCommand implements EmojiCommand {
    private MCEmojis emojis;
    
    public FavoritesCommand(MCEmojis emojis) {
        this.emojis = emojis;
    }
    
    @Override
    public boolean onCommand​(CommandSender sender, String[] args){
        
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + "Favorite Emojis:");
        
        return true;
    }

     @Override
    public String getName() {
        return "favorites";
    }

    @Override
    public String getUsage() {
       return ""; 
    }
    
}
