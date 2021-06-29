package com.rishabhroy;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main extends JavaPlugin implements Listener {
    private static JavaPlugin instance;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AmethystListener(), this);
        instance = this;
    }

    @Override
    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("play")) {
            Player p = this.getServer().getPlayer(sender.getName());
            if (!AmethystListener.playerSongs.contains(p)) {
                AmethystListener.enrollPlayer(p);
            }
            p.playSound(p.getLocation(), Sound.BLOCK_LODESTONE_PLACE, 10, AmethystListener.convertPiano(Integer.parseInt(args[0])));
            p.sendMessage("Note " + args[0] + " played");
            return true;
        }
        if (label.equalsIgnoreCase("verbose")) {
            Player p = this.getServer().getPlayer(sender.getName());
            if (!AmethystListener.playerSongs.contains(p)) {
                AmethystListener.enrollPlayer(p);
            }
            if (args[0].equalsIgnoreCase("on")) {
                AmethystListener.setVerbose(p,true);
                p.sendMessage("Turned verbose mode on");
                return true;
            }
            if (args[0].equalsIgnoreCase("off")) {
                AmethystListener.setVerbose(p, false);
                p.sendMessage("Turned verbose mode off");
                return true;
            }
        }
        if (label.equalsIgnoreCase("song")) {
            Player p = this.getServer().getPlayer(sender.getName());
            if (!AmethystListener.playerSongs.contains(p)) {
                AmethystListener.enrollPlayer(p);
            }
            Type listType = new TypeToken<ArrayList<Integer>>() {}.getType();
            ArrayList<Integer> song = new Gson().fromJson(args[0],listType);
            AmethystListener.setSong(p,song);
            p.sendMessage("Song set!");
            return true;
        }
        return false;
    }


    public static JavaPlugin getPlugin(){
        return instance;
    }

}