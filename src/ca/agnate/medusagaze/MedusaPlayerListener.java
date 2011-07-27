package ca.agnate.medusagaze;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

public class MedusaPlayerListener extends PlayerListener {
	
	private MedusaGaze plugin;
	
	public MedusaPlayerListener (MedusaGaze medusaGaze) {
		this.plugin = plugin;
	}
	
	public void onPlayerJoin (PlayerJoinEvent event) {
        final Player p = event.getPlayer();
        
        
    }
	
	private void checkPlayerInv ( Player p ) {
		PlayerInventory inv = p.getInventory();
		
		for (int id : plugin.getIllegalItems()) {
			if ( inv.contains(id) == false )
				continue;
			
			for (ItemStack item : inv.getContents() ) {
				if ( item.getTypeId() == id  &&  item.getDurability() < 0 ) {
					// Found a hacked weapon/tool.
					inv.remove( item );
				}
			}
		}
	}
}
