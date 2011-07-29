package ca.agnate.medusagaze;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ca.agnate.medusagaze.MedusaPlayerListener;
import java.util.List;
import java.util.LinkedList;

public class MedusaGaze extends JavaPlugin {

    // Weapons
    public static final List<Material> WEAPONS_TYPE = new LinkedList<Material>();
    public static final List<Material> SWORDS_TYPE = new LinkedList<Material>();
    public static final List<Material> AXES_TYPE = new LinkedList<Material>();
    public static final List<Material> PICKAXES_TYPE = new LinkedList<Material>();
    public static final List<Material> SPADES_TYPE = new LinkedList<Material>();
    public static final List<Material> HOES_TYPE = new LinkedList<Material>();

    static {
	// Weapons
	SWORDS_TYPE.add(Material.WOOD_SWORD);
	SWORDS_TYPE.add(Material.STONE_SWORD);
	SWORDS_TYPE.add(Material.GOLD_SWORD);
	SWORDS_TYPE.add(Material.IRON_SWORD);
	SWORDS_TYPE.add(Material.DIAMOND_SWORD);

	AXES_TYPE.add(Material.WOOD_AXE);
	AXES_TYPE.add(Material.STONE_AXE);
	AXES_TYPE.add(Material.GOLD_AXE);
	AXES_TYPE.add(Material.IRON_AXE);
	AXES_TYPE.add(Material.DIAMOND_AXE);

	PICKAXES_TYPE.add(Material.WOOD_PICKAXE);
	PICKAXES_TYPE.add(Material.STONE_PICKAXE);
	PICKAXES_TYPE.add(Material.GOLD_PICKAXE);
	PICKAXES_TYPE.add(Material.IRON_PICKAXE);
	PICKAXES_TYPE.add(Material.DIAMOND_PICKAXE);

	SPADES_TYPE.add(Material.WOOD_SPADE);
	SPADES_TYPE.add(Material.STONE_SPADE);
	SPADES_TYPE.add(Material.GOLD_SPADE);
	SPADES_TYPE.add(Material.IRON_SPADE);
	SPADES_TYPE.add(Material.DIAMOND_SPADE);

	HOES_TYPE.add(Material.WOOD_HOE);
	HOES_TYPE.add(Material.STONE_HOE);
	HOES_TYPE.add(Material.GOLD_HOE);
	HOES_TYPE.add(Material.IRON_HOE);
	HOES_TYPE.add(Material.DIAMOND_HOE);

	WEAPONS_TYPE.addAll(SWORDS_TYPE);
	WEAPONS_TYPE.addAll(AXES_TYPE);
	WEAPONS_TYPE.addAll(PICKAXES_TYPE);
	WEAPONS_TYPE.addAll(SPADES_TYPE);
	WEAPONS_TYPE.addAll(HOES_TYPE);
    }

    public void onDisable() {
	System.out.println("Medusa has left your server... for now.  [" + this
		+ " is disabled.]");
    }

    public void onEnable() {
	System.out
		.println("Medusa has reared her beautiful, wretched face! Hide your illegal tools!  ["
			+ this + " is enabled.]");

	PluginManager pm = getServer().getPluginManager();
	final PlayerListener playerListener = new MedusaPlayerListener(this);

	pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener,
		Priority.Lowest, this);
	pm.registerEvent(Event.Type.INVENTORY_OPEN, playerListener,
		Priority.Lowest, this);
    }

    public boolean isProperMaterial(Material mat) {
	if (WEAPONS_TYPE.contains(mat))
	    return true;

	if (SWORDS_TYPE.contains(mat))
	    return true;

	if (AXES_TYPE.contains(mat))
	    return true;

	if (PICKAXES_TYPE.contains(mat))
	    return true;

	if (HOES_TYPE.contains(mat))
	    return true;

	return false;
    }

    public void gazeUponInventory(Inventory inv) {
	for (ItemStack item : inv.getContents()) {
	    if (isProperMaterial(item.getType()) && item.getDurability() < 0) {
		// Found a hacked weapon/tool, so convert it to stone.
		item.setDurability((short) 0);
		item.setType(Material.STONE);
		item.setAmount(1);
	    }
	}
    }
}
