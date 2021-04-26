package com.kwpugh.easy_emerald.lists;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import com.kwpugh.easy_emerald.init.ItemInit;

public enum ModMaterial implements IItemTier {
	   EMERALD(2, 700, 1.0F, 3.0F, 21, () -> {
	      return Ingredient.fromItems(Items.EMERALD);
	   }),

	   RUBY(3, 1050, 2.0F, 4.0F, 25, () -> {
	      return Ingredient.fromItems(ItemInit.RUBY.get());
	   }),

	   OBSIDIAN(3, 525, 1.0F, 3.0F, 18, () -> {
	      return Ingredient.fromItems(Items.OBSIDIAN);
	   });

   private final int harvestLevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final LazyValue<Ingredient> repairMaterial;

   private ModMaterial(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) 
   {
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
      this.repairMaterial = new LazyValue<>(repairMaterialIn);
   }

   public int getMaxUses() 
   {
      return this.maxUses;
   }

   public float getEfficiency() 
   {
      return this.efficiency;
   }

   public float getAttackDamage() 
   {
      return this.attackDamage;
   }

   public int getHarvestLevel() 
   {
      return this.harvestLevel;
   }

   public int getEnchantability()
   {
      return this.enchantability;
   }

   public Ingredient getRepairMaterial()
   {
      return this.repairMaterial.getValue();
   }
}