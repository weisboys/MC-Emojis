package me.weisboys.mcemojis.commands;

import me.weisboys.mcemojis.MCEmojis;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ListCommand implements EmojiCommand {
    
    private MCEmojis emojis;
    
    public ListCommand(MCEmojis emojis) {
        this.emojis = emojis;
    }
    
    @Override
    public boolean onCommand​(CommandSender sender, String[] args){
        
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + "Available Emojis:");
        for (String key : emojis.getConfig().getConfigurationSection("Emojis").getKeys(false)) {
            sendEmoji("Emojis." + key, sender, emojis, false);
        }
        for (String key : emojis.getConfig().getConfigurationSection("BareEmojis").getKeys(false)) {
            sendEmoji("BareEmojis." + key, sender, emojis, true);
        }
        sender.sendMessage(ChatColor.GOLD.toString() + "You can also type the name of a block, item, or entity incased in \":\"s.");
        
        return true;
    }

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getUsage() {
       return ""; 
    }

}
