package me.weisboys.mcemojis.commands;

import me.weisboys.mcemojis.MCEmojis;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements EmojiCommand {
    
     private final MCEmojis emojis;
     private final CommandManager manager;
     private final String baseCommand;
    
    public HelpCommand(MCEmojis emojis,CommandManager manager) {
        this.emojis = emojis;
        this.manager = manager;
        //Get the base mcemojis command
        baseCommand = "/" + emojis.getDescription().getCommands().keySet().iterator().next(); 
    }
    
    @Override
    public boolean onCommand​(CommandSender sender, String[] args){
        
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + "MCEmojis:");
        sender.sendMessage(ChatColor.GOLD + "Commands");
        for (EmojiCommand command : manager.getCommands()){
            // Yellow + /mcemojis [subcommand] &a [usage]   
            sender.sendMessage(ChatColor.YELLOW + baseCommand + " " + command.getName() + ChatColor.GREEN + " "  + command.getUsage());
        }
      
        
        
        return true;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getUsage() {
        return "";
    }

}
