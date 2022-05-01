package me.weisboys.mcemojis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import me.weisboys.mcemojis.commands.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MCEmojis extends JavaPlugin implements Listener {
    @Override
    public void onEnable (){
        Bukkit.getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        getCommand("mcemojis").setExecutor(new CommandManager(this));
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
    
}
