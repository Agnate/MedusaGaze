package ca.agnate.medusagaze;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

public class MedusaPlayerListener extends PlayerListener {

    private MedusaGaze plugin;

    public MedusaPlayerListener(MedusaGaze medusaGaze) {
        this.plugin = plugin;
    }

    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player p = event.getPlayer();

        // Check player's inventory and turn it to stone.
        plugin.gazeUponInventory(p.getInventory());
    }

    public void onInventoryOpen(PlayerInventoryEvent event) {
        // Check inventory and turn it to stone.
        plugin.gazeUponInventory(event.getInventory());
    }

    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        String[] args = event.getMessage().split(" ");

        if (args.length >= 2) {
            if (args[0] == "/medusagaze") {
                if (args[1].equalsIgnoreCase("turnHerGazeOntoTheWorld")) {
                    if (args.length == 2) {
                        Player p = event.getPlayer();

                        if (p != null) {
                            p.sendMessage("WARNING! Allowing Medusa to cast her gaze on your server will CAUSE AN INTENSE AMOUNT OF LAG! To continue, type: /medusagaze turnHerGazeOntoTheWorld YES");
                        }
                    }
                    else if (args[2].equalsIgnoreCase("YES")) {
                        plugin.releaseMedusaOntoTheWorld();
                    }
                }
            }
        }
    }
}
