package net.thev123.magusarmors.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thev123.magusarmors.MagusArmors;
import net.thev123.magusarmors.item.custom.*;

public class ModItems {
    //armor
    public static final Item FIRE_HELMET = registerItem("fire_helmet",
            new ModArmorFire(ModArmorMaterials.FIRE_MATERIAL, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item FIRE_CHESTPLATE= registerItem("fire_chestplate",
            new ModArmorFire(ModArmorMaterials.FIRE_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item FIRE_LEGGINGS = registerItem("fire_leggings",
            new ModArmorFire(ModArmorMaterials.FIRE_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings()));
    public static final Item FIRE_BOOTS = registerItem("fire_boots",
            new ModArmorFire(ModArmorMaterials.FIRE_MATERIAL, ArmorItem.Type.BOOTS,
                    new FabricItemSettings()));

    public static final Item FROST_HELMET = registerItem("frost_helmet",
            new ModArmorFrost(ModArmorMaterials.FROST_MATERIAL, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item FROST_CHESTPLATE= registerItem("frost_chestplate",
            new ModArmorFrost(ModArmorMaterials.FROST_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item FROST_LEGGINGS = registerItem("frost_leggings",
            new ModArmorFrost(ModArmorMaterials.FROST_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings()));
    public static final Item FROST_BOOTS = registerItem("frost_boots",
            new ModArmorFrost(ModArmorMaterials.FROST_MATERIAL, ArmorItem.Type.BOOTS,
                    new FabricItemSettings()));

    public static final Item ARCANE_HELMET = registerItem("arcane_helmet",
            new ModArmorArcane(ModArmorMaterials.ARCANE_MATERIAL, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item ARCANE_CHESTPLATE = registerItem("arcane_chestplate",
            new ModArmorArcane(ModArmorMaterials.ARCANE_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item ARCANE_LEGGINGS = registerItem("arcane_leggings",
            new ModArmorArcane(ModArmorMaterials.ARCANE_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings()));
    public static final Item ARCANE_BOOTS = registerItem("arcane_boots",
            new ModArmorArcane(ModArmorMaterials.ARCANE_MATERIAL, ArmorItem.Type.BOOTS,
                    new FabricItemSettings()));

    public static final Item HEALING_HELMET = registerItem("healing_helmet",
            new ModArmorHealing(ModArmorMaterials.HEALING_MATERIAL, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item HEALING_CHESTPLATE = registerItem("healing_chestplate",
            new ModArmorHealing(ModArmorMaterials.HEALING_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item HEALING_LEGGINGS = registerItem("healing_leggings",
            new ModArmorHealing(ModArmorMaterials.HEALING_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings()));
    public static final Item HEALING_BOOTS = registerItem("healing_boots",
            new ModArmorHealing(ModArmorMaterials.HEALING_MATERIAL, ArmorItem.Type.BOOTS,
                    new FabricItemSettings()));

    public static final Item RANGED_HELMET = registerItem("ranged_helmet",
            new ModArmorRanged(ModArmorMaterials.RANGED_MATERIAL, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item RANGED_CHESTPLATE = registerItem("ranged_chestplate",
            new ModArmorRanged(ModArmorMaterials.RANGED_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item RANGED_LEGGINGS = registerItem("ranged_leggings",
            new ModArmorRanged(ModArmorMaterials.RANGED_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings()));
    public static final Item RANGED_BOOTS = registerItem("ranged_boots",
            new ModArmorRanged(ModArmorMaterials.RANGED_MATERIAL, ArmorItem.Type.BOOTS,
                    new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MagusArmors.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MagusArmors.LOGGER.info("Registering Mod Items for " + MagusArmors.MOD_ID);

    }
}
