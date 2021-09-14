package net.GameV.module;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class Sharpening {
	private String name;
	private Material sharpeningMaterial;
	private Material weaponMaterial;
	private Enchantment enchantment;
	private int level;

	public Sharpening(String name, Material sharpeningMaterial, Material weaponMaterial, Enchantment enchantment, int level) {
		this.name = name;
		this.sharpeningMaterial = sharpeningMaterial;
		this.weaponMaterial = weaponMaterial;
		this.enchantment = enchantment;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public Material getSharpeningMaterial() {
		return sharpeningMaterial;
	}

	public Material getWeaponMaterial() {
		return weaponMaterial;
	}

	public Enchantment getEnchantment() {
		return enchantment;
	}

	public int getLevel() {
		return level;
	}
	
}
