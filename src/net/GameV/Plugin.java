package net.GameV;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void EventInventoryClick(InventoryClickEvent event) {
		if (event.getAction() != InventoryAction.SWAP_WITH_CURSOR)
			return;

		ItemStack cursorItem = event.getCursor();
		ItemStack currentItem = event.getCurrentItem();
		
		boolean flag = true;
		flag &= cursorItem.getType() == Material.GOLD_NUGGET; // sharpening material
		flag &= currentItem.getType() == Material.DIAMOND_SWORD; // weapon material

		if (flag) {
			event.setCancelled(true);

			Enchantment targetEnchant = Enchantment.DAMAGE_ALL;
			int enchantLevel = currentItem.getEnchantmentLevel(targetEnchant);
			currentItem.addUnsafeEnchantment(targetEnchant, enchantLevel + 1);
			cursorItem.setAmount(cursorItem.getAmount()-1);
			
		}
	}
	
}