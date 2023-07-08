package net.thev123.awesomearmaments.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;
import net.thev123.awesomearmaments.AwesomeArmaments;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    //enum format credits: https://github.com/aleganza/Plenty-Of-Armors
    PLATED_IRON("plated_iron", 16, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 0.5F, 1.0F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.IRON_INGOT});
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
