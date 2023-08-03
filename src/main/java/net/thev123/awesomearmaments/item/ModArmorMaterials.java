package net.thev123.awesomearmaments.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    //enum format credits: https://github.com/aleganza/Plenty-Of-Armors
    PLATED_IRON("plated_iron", 17, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1.0F, 0F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.IRON_INGOT});
    }),
    PLATED_DIAMOND("plated_diamond", 35, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.5F, 0.05F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.DIAMOND});
    }),
    PLATED_NETHERITE("plated_netherite", 42, new int[]{4, 6, 8, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, 0.25F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT});
    }),
    WISE_IRON("wise_iron", 15, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.IRON_INGOT});
    }),
    WISE_DIAMOND("wise_diamond", 33, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.DIAMOND});
    }),
    WISE_NETHERITE("wise_netherite", 37, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT});
    }),
    AQUA_DIAMOND("aqua_diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.DIAMOND});
    }),
    AQUA_NETHERITE("aqua_netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT});
    }),
    BULWARK("bulwark", 50, new int[]{5, 8, 9, 5}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5F, 0.5F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT});
    }),
    INFINITE_SIGHT("infinite_sight", 37, new int[]{3, 6, 8, 3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3F, 0.1F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT});
    }),
    NEPTUNE("neptune", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3F, 0.1F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT});
    });

    //    public static final StringIdentifiable.Codec<ArmorMaterials> CODEC;
    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
    }


    public int getDurability(ArmorItem.Type slot) {
        int type = -1;

        if(slot.getEquipmentSlot() == EquipmentSlot.FEET) type = 0;
        if(slot.getEquipmentSlot() == EquipmentSlot.LEGS) type = 1;
        if(slot.getEquipmentSlot() == EquipmentSlot.CHEST) type = 2;
        if(slot.getEquipmentSlot() == EquipmentSlot.HEAD) type = 3;

        return BASE_DURABILITY[type] * this.durabilityMultiplier;
    }

    public int getProtection(ArmorItem.Type slot) {
        int type = -1;

        if(slot.getEquipmentSlot() == EquipmentSlot.FEET) type = 0;
        if(slot.getEquipmentSlot() == EquipmentSlot.LEGS) type = 1;
        if(slot.getEquipmentSlot() == EquipmentSlot.CHEST) type = 2;
        if(slot.getEquipmentSlot() == EquipmentSlot.HEAD) type = 3;

        return this.protectionAmounts[type];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}