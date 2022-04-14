package me.weisboys.mcemojis;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SpamCommand implements CommandExecutor {
    private MCEmojis emojis;
    
    public SpamCommand(MCEmojis emojis) {
        this.emojis = emojis;
    }
     
    @Override
    public boolean onCommand​(CommandSender sender, Command command, String label, String[] args){
        StringBuilder spam = new StringBuilder();
        section("Emojis", spam);
        section("BareEmojis", spam);
        section("HiddenEmojis", spam);
        sender.sendMessage(spam.toString());
        return true;   
    }
    private void section(String section, StringBuilder sb){
        for (String key : emojis.getConfig().getConfigurationSection(section).getKeys(false)) {
            sb.append(emojis.getConfig().getString(section + "." + key));
        }
    }
        
}
