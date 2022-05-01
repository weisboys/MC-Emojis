package me.weisboys.mcemojis.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.weisboys.mcemojis.MCEmojis;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.util.StringUtil;


public class CommandManager implements TabExecutor {
   
    private MCEmojis emojis;
    private List<EmojiCommand> commands = new ArrayList<>();
    
    public CommandManager(MCEmojis emojis) {
        this.emojis = emojis;
        commands.add(new HelpCommand(emojis, this));
        commands.add(new ListCommand(emojis));
        commands.add(new ReloadCommand(emojis));
        commands.add(new SearchCommand(emojis));
        commands.add(new SpamCommand(emojis));
    }
    
    
    
    public boolean onCommand​(CommandSender sender, Command cmd, String label, String[] args){
        
        if (args.length == 0){
            executeCommand(commands.get(0), sender, args);
            return true;
        }
        
        for (EmojiCommand command : commands){
            if (command.getName().equalsIgnoreCase(args[0]) ){
                String[] modArgs = Arrays.copyOfRange(args, 1, args.length);
                executeCommand(command, sender, modArgs);
                
                return true;
                
            }
        }
        sender.sendMessage("Not a valid command!"); //todo: add chat formatting
        
        return true;
    }
    
    private void executeCommand(EmojiCommand command, CommandSender sender, String[] args){
        String permission = "mcemojis." + command.getName();
        if (!sender.hasPermission(permission)){
            sender.sendMessage(ChatColor.RED + "You do not have the correct permission to execute this command!");
            return;
        }
        boolean success = command.onCommand(sender, args);
        
        if (!success){
            String usage = command.getUsage();
            sender.sendMessage(ChatColor.YELLOW + "/mcemojis " + command.getName() + " " + usage);
        }
    }

    public List<EmojiCommand> getCommands() {
        return commands;
    }

    @Override
    public List<String> onTabComplete(CommandSender cs, Command cmnd, String string, String[] args) {
        List<String> options = new ArrayList<>();
        List<String> results = new ArrayList<>();
        if (args.length != 1){
            return options;
        }
        
        for (EmojiCommand command : getCommands()){
            options.add(command.getName());
        }
        
        StringUtil.copyPartialMatches(args[0], options, results); //Copies any matching args[0] into results
        
        return results;
    }
    
    
    
}
