package me.weisboys.mcemojis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MCEmojis extends JavaPlugin implements Listener {
    @Override
    public void onEnable (){
        Bukkit.getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        getCommand("mcereload").setExecutor(new ReloadCommand(this));
        getCommand("emojis").setExecutor(new EmojisCommand(this));
        getCommand("emojispam").setExecutor(new SpamCommand(this));
        getCommand("searchemojis").setExecutor(new SearchCommand(this));
    }
    @EventHandler
    public void onChat (AsyncPlayerChatEvent event){
        String playerInput = event.getMessage();
        for (String key : this.getConfig().getConfigurationSection("Emojis").getKeys(false)) {
            playerInput = playerInput.replace(":" + key + ":", this.getConfig().getString("Emojis." + key));
        }
        for (String key : this.getConfig().getConfigurationSection("HiddenEmojis").getKeys(false)) {
            playerInput = playerInput.replace(":" + key + ":", this.getConfig().getString("HiddenEmojis." + key));
        }
        List<String> keys = new ArrayList<>(this.getConfig().getConfigurationSection("BareEmojis").getKeys(false));
        keys.sort(Comparator.comparing(s -> s.length()));
        Collections.reverse(keys);
        for (String key : keys) {
            playerInput = playerInput.replace( key, this.getConfig().getString("BareEmojis." + key));
        }
               
        event.setMessage(playerInput);
    }
    
    public boolean onCommand​(CommandSender sender, Command command, String label, String[] args){
        
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + "Available Emojis:");
        for (String key : this.getConfig().getConfigurationSection("Emojis").getKeys(false)) {
            sender.sendMessage( this.getConfig().getString("Emojis." + key) + ChatColor.YELLOW + ":" + key +":" );
        }
        for (String key : this.getConfig().getConfigurationSection("BareEmojis").getKeys(false)) {
            sender.sendMessage( this.getConfig().getString("BareEmojis." + key) + ChatColor.YELLOW + key );
        }
        sender.sendMessage(ChatColor.GOLD.toString() + "You can also type the name of a block, item, or entity incased in \":\"s.");
        
        return true;
    }
}
