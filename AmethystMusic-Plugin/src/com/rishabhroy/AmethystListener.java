package com.rishabhroy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.List;

public class AmethystListener implements Listener {

    static List<Float> pianoConversion = new ArrayList<Float>(){{
        add(0,(float)0.5);
        add(1,(float)0.529732);
        add(2,(float)0.561231);
        add(3,(float)0.594604);
        add(4,(float)0.629961);
        add(5,(float)0.667420);
        add(6,(float)0.707107);
        add(7,(float)0.749154);
        add(8,(float)0.793701);
        add(9,(float)0.840896);
        add(10,(float)0.890899);
        add(11,(float)0.943874);
        add(12,(float)1);
        add(13,(float)1.059463);
        add(14,(float)1.122462);
        add(15,(float)1.189207);
        add(16,(float)1.259921);
        add(17,(float)1.334840);
        add(18,(float)1.414214);
        add(19,(float)1.498307);
        add(20,(float)1.587401);
        add(21,(float)1.681793);
        add(22,(float)1.781797);
        add(23,(float)1.887749);
        add(24,(float)2);
    }};

    // C D# F F# F D# C
    static ArrayList<Integer> defaultSong = new ArrayList<Integer>(){{
        add(0,6);
        add(1,9);
        add(2,11);
        add(3,12);
        add(4,11);
        add(5,9);
        add(6,6);
        add(7,4);
        add(8,8);
        add(9,6);
    }};

    static List<Player> playerSongs = new ArrayList<Player>();
    static List<ArrayList<Integer>> songData = new ArrayList<ArrayList<Integer>>();
    static List<Boolean> verbose = new ArrayList<Boolean>();
    static List<Integer> playerBuffers = new ArrayList<Integer>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Material blockType = e.getBlockPlaced().getType();
        if (blockType == Material.AMETHYST_BLOCK) {
            if (!playerSongs.contains(e.getPlayer())) {
                enrollPlayer(e.getPlayer());
            }
            for(Player p : Main.getPlugin().getServer().getOnlinePlayers()) {
                p.playSound(e.getBlock().getLocation(), Sound.BLOCK_LODESTONE_PLACE, 10, convertPiano(songData.get(playerSongs.indexOf(e.getPlayer())).get(playerBuffers.get(playerSongs.indexOf(e.getPlayer())))));
            }
            if (verbose.get(playerSongs.indexOf(e.getPlayer()))) {
                e.getPlayer().sendMessage("Sound " + (playerBuffers.get(playerSongs.indexOf(e.getPlayer())) + 1) + " played");
            }
            if (playerBuffers.get(playerSongs.indexOf(e.getPlayer())) == (songData.get(playerSongs.indexOf(e.getPlayer())).size() - 1)) {
                playerBuffers.set(playerSongs.indexOf(e.getPlayer()),0);
            }
            else if (!(playerBuffers.get(playerSongs.indexOf(e.getPlayer())) == (songData.get(playerSongs.indexOf(e.getPlayer())).size() - 1))) {
                playerBuffers.set(playerSongs.indexOf(e.getPlayer()),playerBuffers.get(playerSongs.indexOf(e.getPlayer())) + 1);
            }
        }
    }

    public static float convertPiano(Integer index) {
        return pianoConversion.get(index);
    }

    public static void setVerbose(Player p, Boolean bool) {
        verbose.set(playerSongs.indexOf(p),bool);
    }

    public static void setSong(Player p, ArrayList<Integer> song) {
        songData.set(playerSongs.indexOf(p), song);
        playerBuffers.set(playerSongs.indexOf(p),0);
    }

    public static void enrollPlayer(Player p) {
        playerSongs.add(p);
        songData.add(playerSongs.indexOf(p), defaultSong);
        playerBuffers.add(playerSongs.indexOf(p), 0);
        verbose.add(playerSongs.indexOf(p), false);
    }
}

