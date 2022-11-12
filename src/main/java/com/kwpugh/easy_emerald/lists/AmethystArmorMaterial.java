package com.kwpugh.easy_emerald.lists;

import com.kwpugh.easy_emerald.EasyEmerald;
import com.kwpugh.easy_emerald.config.GeneralModConfig;
import com.kwpugh.easy_emerald.init.ItemInit;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class AmethystArmorMaterial implements ArmorMaterial
{
    private static int durabilityMultiplier = GeneralModConfig.AMETHYST_ARMOR_DURABILITY_MULTIPLIER.get();
    private static int enchantability = GeneralModConfig.AMETHYST_ARMOR_ENCHANTABILITY.get();
    private static double toughness = GeneralModConfig.AMETHYST_ARMOR_TOUGHNESS.get();
    private static double knochback = GeneralModConfig.AMETHYST_ARMOR_KNOCKBACK_RESISTANCE.get();

    private static int amethystHead = GeneralModConfig.AMETHYST_ARMOR_PROTECTION_HEAD.get();
    private static int amethystBody = GeneralModConfig.AMETHYST_ARMOR_PROTECTION_BODY.get();
    private static int amethystLeggings = GeneralModConfig.AMETHYST_ARMOR_PROTECTION_LEGGINGS.get();
    private static int amethystFeet = GeneralModConfig.AMETHYST_ARMOR_PROTECTION_FEET.get();

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_AMOUNT = new int[]{amethystHead, amethystLeggings, amethystBody, amethystFeet};

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot)
    {
        return BASE_DURABILITY[slot.getIndex()] * durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot)
    {
        return PROTECTION_AMOUNT[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue()
    {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return SoundEvents.ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(Items.AMETHYST_SHARD );
    }

    @Override
    public String getName()
    {
        return EasyEmerald.modid + ":" + "amethyst";
    }

    @Override
    public float getToughness()
    {
        return (float) toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return (float) knochback;
    }
}