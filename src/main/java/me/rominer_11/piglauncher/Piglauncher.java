package me.rominer_11.piglauncher;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public final class Piglauncher extends JavaPlugin implements Listener {

    public static ArrayList<Player> inGame = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);

        getCommand("play").setExecutor(new Play());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals("e")) {
            TNTPrimed pig = event.getPlayer().getWorld().spawn(event.getPlayer().getEyeLocation(), TNTPrimed.class);
            pig.setVelocity(new Vector(event.getPlayer().getLocation().getDirection().getX() * 3, event.getPlayer().getLocation().getDirection().getY() * 3, event.getPlayer().getLocation().getDirection().getZ() * 3));
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.CLICK, 1.0f, 1.0f);
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (inGame.contains(event.getEntity())) {
            event.getEntity().setGameMode(GameMode.SPECTATOR);
            inGame.remove(event.getEntity());
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!inGame.contains(event.getPlayer())) {
            event.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
    }

}
