package net.thev123.magusarmors.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thev123.magusarmors.MagusArmors;

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

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MagusArmors.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MagusArmors.LOGGER.info("Registering Mod Items for " + MagusArmors.MOD_ID);

    }
}
