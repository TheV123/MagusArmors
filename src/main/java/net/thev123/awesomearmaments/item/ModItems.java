package net.thev123.awesomearmaments.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thev123.awesomearmaments.AwesomeArmaments;
import net.thev123.awesomearmaments.item.custom.ModArmorBulwark;
import net.thev123.awesomearmaments.item.custom.ModArmorPlatedDiamond;
import net.thev123.awesomearmaments.item.custom.ModArmorPlatedIron;
import net.thev123.awesomearmaments.item.custom.ModArmorPlatedNetherite;

public class ModItems {
    public static final Item PLATED_IRON_UPGRADE = registerItem("plated_iron_upgrade",
            new Item(new FabricItemSettings()));
    public static final Item PLATED_DIAMOND_UPGRADE = registerItem("plated_diamond_upgrade",
            new Item(new FabricItemSettings()));
    public static final Item PLATED_NETHERITE_UPGRADE = registerItem("plated_netherite_upgrade",
            new Item(new FabricItemSettings()));

    public static final Item PLATED_IRON_HELMET = registerItem("plated_iron_helmet",
            new ModArmorPlatedIron(ModArmorMaterials.PLATED_IRON, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item PLATED_IRON_CHESTPLATE = registerItem("plated_iron_chestplate",
            new ModArmorPlatedIron(ModArmorMaterials.PLATED_IRON, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item PLATED_IRON_LEGGINGS = registerItem("plated_iron_leggings",
            new ModArmorPlatedIron(ModArmorMaterials.PLATED_IRON, ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings()));
    public static final Item PLATED_IRON_BOOTS = registerItem("plated_iron_boots",
            new ModArmorPlatedIron(ModArmorMaterials.PLATED_IRON, ArmorItem.Type.BOOTS,
                    new FabricItemSettings()));

    //temporary textures from https://www.planetminecraft.com/texture-pack/spryzeen-s-knight-armor/
    public static final Item PLATED_DIAMOND_HELMET = registerItem("plated_diamond_helmet",
            new ModArmorPlatedDiamond(ModArmorMaterials.PLATED_DIAMOND, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));
    public static final Item PLATED_DIAMOND_CHESTPLATE = registerItem("plated_diamond_chestplate",
            new ModArmorPlatedDiamond(ModArmorMaterials.PLATED_DIAMOND, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));
    public static final Item PLATED_DIAMOND_LEGGINGS = registerItem("plated_diamond_leggings",
            new ModArmorPlatedDiamond(ModArmorMaterials.PLATED_DIAMOND, ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings()));
    public static final Item PLATED_DIAMOND_BOOTS = registerItem("plated_diamond_boots",
            new ModArmorPlatedDiamond(ModArmorMaterials.PLATED_DIAMOND, ArmorItem.Type.BOOTS,
                    new FabricItemSettings()));



    //temporary textures from https://www.planetminecraft.com/texture-pack/spryzeen-s-knight-armor/
    public static final Item PLATED_NETHERITE_HELMET = registerItem("plated_netherite_helmet",
            new ModArmorPlatedNetherite(ModArmorMaterials.PLATED_NETHERITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PLATED_NETHERITE_CHESTPLATE = registerItem("plated_netherite_chestplate",
            new ModArmorPlatedNetherite(ModArmorMaterials.PLATED_NETHERITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PLATED_NETHERITE_LEGGINGS = registerItem("plated_netherite_leggings",
            new ModArmorPlatedNetherite(ModArmorMaterials.PLATED_NETHERITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item PLATED_NETHERITE_BOOTS = registerItem("plated_netherite_boots",
            new ModArmorPlatedNetherite(ModArmorMaterials.PLATED_NETHERITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //temporary textures from https://www.planetminecraft.com/texture-pack/improved-netherite-by-toxteer/
    public static final Item BULWARK_HELMET = registerItem("bulwark_helmet",
            new ModArmorBulwark(ModArmorMaterials.BULWARK, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BULWARK_CHESTPLATE = registerItem("bulwark_chestplate",
            new ModArmorBulwark(ModArmorMaterials.BULWARK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BULWARK_LEGGINGS = registerItem("bulwark_leggings",
            new ModArmorBulwark(ModArmorMaterials.BULWARK, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item BULWARK_BOOTS = registerItem("bulwark_boots",
            new ModArmorBulwark(ModArmorMaterials.BULWARK, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    private static void addItemsToIngredientTab(FabricItemGroupEntries entries) {
        entries.add(PLATED_IRON_UPGRADE);
        entries.add(PLATED_DIAMOND_UPGRADE);
        entries.add(PLATED_NETHERITE_UPGRADE);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AwesomeArmaments.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AwesomeArmaments.LOGGER.info("Registering Mod Items for " + AwesomeArmaments.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(
                ModItems::addItemsToIngredientTab);
    }
}
