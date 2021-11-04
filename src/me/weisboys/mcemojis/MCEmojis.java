/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.weisboys.mcemojis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author weisb
 */
public class MCEmojis extends JavaPlugin implements Listener {
    @Override
    public void onEnable (){
        Bukkit.getPluginManager().registerEvents(this, this);
        
    }
    @EventHandler
    public void onChat (AsyncPlayerChatEvent event){
        String playerInput = event.getMessage();
        playerInput = playerInput.replaceAll(":tank:", "\u3a00");
        playerInput = playerInput.replaceAll(":ooh:", "\u3a01");
        playerInput = playerInput.replaceAll(":puppet:", "\u3a02");
        playerInput = playerInput.replaceAll(":mcqueen:", "\u3a03");
        playerInput = playerInput.replaceAll(":diamond:", "\ue505");
        playerInput = playerInput.replaceAll(":creeper:", "\ue824");
        playerInput = playerInput.replaceAll(":lava:", "\ue01f");
        playerInput = playerInput.replaceAll(":fire:", "\ue0e7");
        playerInput = playerInput.replaceAll(":chest:", "\ue0ee");
        playerInput = playerInput.replaceAll(":nether:", "\ue16a");
        playerInput = playerInput.replaceAll(":villager:", "\ue88b");
        playerInput = playerInput.replaceAll(":snowball:", "\ue548");
        
//<>: Observer (Face)
//<>: Emerald
//<>: Tree
//<>: Sun
//<>: Moon Phases:
//<>: Wither Skeleton Head
//<>: Ghast
//<>: Ghast Angry
//<>: Coal
//<>: Iron Ingot
//<>: Gold Ingot
//<>: Lapis Lazuli
        

        
        event.setMessage(playerInput);
    }
    public boolean onCommand​(CommandSender sender, Command command, String label, String[] args){
        
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + "Available Emojis:");
        sender.sendMessage("\u3a00" + ChatColor.YELLOW + " :tank:");
        sender.sendMessage("\u3a01" + ChatColor.YELLOW + " :ooh:");
        sender.sendMessage("\u3a02" + ChatColor.YELLOW + " :puppet:");
        sender.sendMessage("\u3a03" + ChatColor.YELLOW + " :mcqueen:");
        sender.sendMessage("\ue505" + ChatColor.YELLOW + " :diamond:");
        sender.sendMessage("\ue824" + ChatColor.YELLOW + " :creeper:");
        sender.sendMessage("\ue01f" + ChatColor.YELLOW + " :lava:");
        sender.sendMessage("\ue0e7" + ChatColor.YELLOW + " :fire:");
        sender.sendMessage("\ue0ee" + ChatColor.YELLOW + " :chest:");
        sender.sendMessage("\ue16a" + ChatColor.YELLOW + " :nether:");
        sender.sendMessage("\ue88b" + ChatColor.YELLOW + " :villager:");
        sender.sendMessage("\ue548" + ChatColor.YELLOW + " :snowball:");
        
        return true;
    }
}
