package ca.agnate.medusagaze;

import org.bukkit.Material;
import org.bukkit.entity.Player;
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
}
