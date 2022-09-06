package me.weisboys.mcemojis.commands;

import me.weisboys.mcemojis.MCEmojis;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SpamCommand implements EmojiCommand {
    private MCEmojis emojis;
    
    public SpamCommand(MCEmojis emojis) {
        this.emojis = emojis;
    }
     
    @Override
    public boolean onCommand​(CommandSender sender, String[] args){
        StringBuilder spam = new StringBuilder();
        section("Emojis", spam);
        section("BareEmojis", spam);
        section("HiddenEmojis", spam);
        sender.sendMessage(spam.toString());
        return true;   
    }
    private void section(String section, StringBuilder sb){
        
        int i = 0;
        
        for (String key : emojis.getConfig().getConfigurationSection(section).getKeys(false)) {
            sb.append(emojis.getConfig().getString(section + "." + key));
        }
    }

    @Override
    public String getName() {
        return "spam";
    }

    @Override
    public String getUsage() {
        return "";
    }
        
}
