package net.GameV;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import net.GameV.module.Sharpening;

public class Plugin extends JavaPlugin implements Listener {

	List<Sharpening> sharpenings;
	
	@Override
	public void onEnable() {
		sharpenings = Arrays.asList(new Sharpening[] {
				new Sharpening("Sharp1", Material.GOLD_NUGGET, Material.DIAMOND_SWORD, Enchantment.DAMAGE_ALL, 1),
				new Sharpening("Sharp2", Material.DIAMOND_AXE, Material.DIAMOND_SWORD, Enchantment.SWEEPING_EDGE, 2),
				new Sharpening("Sharp3", Material.STICK, Material.DIAMOND_SWORD, Enchantment.KNOCKBACK, 1),
		});
		
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void EventInventoryClick(InventoryClickEvent event) {		
		if (event.getAction() != InventoryAction.SWAP_WITH_CURSOR)
			return;
		
		ItemStack cursorItem = event.getCursor();
		ItemStack currentItem = event.getCurrentItem();
		
		for (int i = 0; i < sharpenings.size(); i++) {
			Sharpening sharpening = sharpenings.get(i);
			
			if (cursorItem.getType() == sharpening.getSharpeningMaterial()) {
				event.setCancelled(true);
				
				boolean flag = currentItem.getType() == sharpening.getWeaponMaterial();

				if (flag) {
					Enchantment targetEnchant = sharpening.getEnchantment();
					int enchantLevel = currentItem.getEnchantmentLevel(targetEnchant);
					currentItem.addUnsafeEnchantment(targetEnchant, enchantLevel + sharpening.getLevel());
					cursorItem.setAmount(cursorItem.getAmount() - 1);
				}
				
			}
		
		}
	
	}

}