package me.weisboys.mcemojis.commands;

import me.weisboys.mcemojis.MCEmojis;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements EmojiCommand {
  
    private MCEmojis emojis;
    
    public ReloadCommand(MCEmojis emojis) {
        this.emojis = emojis;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        emojis.reloadConfig();
        sender.sendMessage(ChatColor.GOLD + "Reloaded MCEmojis config");
        return true;
    }

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getUsage() {
        return "";
    }

    
    
}
