package me.weisboys.mcemojis;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SearchCommand implements CommandExecutor {
    
    private MCEmojis emojis;
    
    public SearchCommand(MCEmojis emojis) {
        this.emojis = emojis;
    }
    
    @Override
    public boolean onCommand​(CommandSender sender, Command command, String label, String[] args){
        
        if (args.length != 1) {
            return false;
        }
        
        
        String input = args[0].toLowerCase();
        boolean output = true;
        for (String emojiName : emojis.getConfig().getKeys(true)) {
            if (!emojis.getConfig().isString(emojiName)) continue;
            if (!emojiName.toLowerCase().contains(input)) continue;
             sender.sendMessage(ChatColor.YELLOW + emojiName.split("\\.")[1] + ChatColor.RESET + emojis.getConfig().getString(emojiName));
             output = false;
        }
        
        if (output == true) {
            sender.sendMessage(ChatColor.RED + "Couldn't find any matching emojis.");
        }
        return true;
       
    }
    
}
