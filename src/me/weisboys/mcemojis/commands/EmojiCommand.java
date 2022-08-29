package me.weisboys.mcemojis.commands;

import me.weisboys.mcemojis.MCEmojis;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;


public interface EmojiCommand {
    
    public boolean onCommand​(CommandSender sender, String[] args);
    public String getName();
    public String getUsage();
    public default void sendEmoji(String emojiPath,CommandSender sender, MCEmojis emojis, boolean bare) {
        String emojiName = emojiPath.split("\\.")[1];
        TextComponent line = new TextComponent(emojiName);
        line.setColor(ChatColor.YELLOW);
        TextComponent emoji = new TextComponent(emojis.getConfig().getString(emojiPath));
        emoji.setColor(ChatColor.WHITE);
        line.addExtra(emoji);
        String key = emojiName;
        if (!bare){
            key = ":" + key + ":";
        }
        line.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND,key));
        sender.spigot().sendMessage(line);
     }
}
