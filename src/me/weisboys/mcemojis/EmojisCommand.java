package me.weisboys.mcemojis;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EmojisCommand implements CommandExecutor {
    
    private MCEmojis emojis;
    
    public EmojisCommand(MCEmojis emojis) {
        this.emojis = emojis;
    }
    
    @Override
    public boolean onCommand​(CommandSender sender, Command command, String label, String[] args){
        
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + "Available Emojis:");
        for (String key : emojis.getConfig().getConfigurationSection("Emojis").getKeys(false)) {
            sender.sendMessage( emojis.getConfig().getString("Emojis." + key) + ChatColor.YELLOW + ":" + key +":" );
        }
        for (String key : emojis.getConfig().getConfigurationSection("BareEmojis").getKeys(false)) {
            sender.sendMessage( emojis.getConfig().getString("BareEmojis." + key) + ChatColor.YELLOW + key );
        }
        sender.sendMessage(ChatColor.GOLD.toString() + "You can also type the name of a block, item, or entity incased in \":\"s.");
        
        return true;
    }
}
