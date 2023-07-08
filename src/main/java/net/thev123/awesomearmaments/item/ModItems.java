package net.thev123.awesomearmaments.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thev123.awesomearmaments.AwesomeArmaments;
import net.thev123.awesomearmaments.item.custom.ModArmorPlatedIron;

public class ModItems {
    public static final Item PLATED_IRON_HELMET = registerItem("plated_iron_helmet",
            new ModArmorPlatedIron(ModArmorMaterials.PLATED_IRON, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PLATED_IRON_CHESTPLATE = registerItem("plated_iron_chestplate",
            new ModArmorPlatedIron(ModArmorMaterials.PLATED_IRON, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PLATED_IRON_LEGGINGS = registerItem("plated_iron_leggings",
            new ModArmorPlatedIron(ModArmorMaterials.PLATED_IRON, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item PLATED_IRON_BOOTS = registerItem("plated_iron_boots",
            new ModArmorPlatedIron(ModArmorMaterials.PLATED_IRON, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AwesomeArmaments.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AwesomeArmaments.LOGGER.info("Registering Mod Items for " + AwesomeArmaments.MOD_ID);
    }
}
