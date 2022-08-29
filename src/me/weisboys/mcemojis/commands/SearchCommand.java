package me.weisboys.mcemojis.commands;

import me.weisboys.mcemojis.MCEmojis;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SearchCommand implements EmojiCommand {
    
    private MCEmojis emojis;
    
    public SearchCommand(MCEmojis emojis) {
        this.emojis = emojis;
    }
    
    @Override
    public boolean onCommand​(CommandSender sender, String[] args){
        
        if (args.length != 1) {
            return false;
        }
        
        
        String input = args[0].toLowerCase();
        boolean output = true;
        int results = 0;
        for (String emojiPath : emojis.getConfig().getKeys(true)) {
            if (!emojis.getConfig().isString(emojiPath)) continue;
            if (!emojiPath.toLowerCase().contains(input)) continue;
             results ++;
             sendEmoji(emojiPath, sender, emojis, emojiPath.startsWith("BareEmojis"));
             output = false;
        }
        
        if (output == true) {
            sender.sendMessage(ChatColor.RED + "Couldn't find any matching emojis.");
        }
        if (output == false){
            sender.sendMessage(ChatColor.GOLD + "Found " + ChatColor.GREEN + results + ChatColor.GOLD + " matching emojis.");
        }
        return true;
       
    }

    @Override
    public String getName() {
        return "search";
    }

    @Override
    public String getUsage() {
        return "<emojiName>";
    }
    
}
