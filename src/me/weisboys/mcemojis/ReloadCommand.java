package me.weisboys.mcemojis;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
  
    private MCEmojis emojis;
    
    public ReloadCommand(MCEmojis emojis) {
        this.emojis = emojis;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        emojis.reloadConfig();
        sender.sendMessage(ChatColor.YELLOW + "Reloaded MCEmojis config");
        return true;
    }

    
    
}
