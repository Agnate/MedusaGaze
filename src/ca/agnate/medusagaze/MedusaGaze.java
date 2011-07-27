package ca.agnate.medusagaze;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ca.agnate.medusagaze.MedusaPlayerListener;

public class MedusaGaze extends JavaPlugin {
	
	private int[] illegalList = {276, 277, 278, 279};
	
    public void onDisable() {
        // TODO: Place any custom disable code here.
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        // TODO: Place any custom enable code here, such as registering events
        
        System.out.println(this + " is now enabled!");
        
        PluginManager pm = getServer().getPluginManager();
        final PlayerListener playerListener = new MedusaPlayerListener(this);
        
        pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Priority.Lowest, this);
    }
    
    public int[] getIllegalItems () {
    	return illegalList;
    }
}
