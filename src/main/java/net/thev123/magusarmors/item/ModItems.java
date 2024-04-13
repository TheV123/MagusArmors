package net.thev123.magusarmors.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thev123.magusarmors.MagusArmors;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MagusArmors.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MagusArmors.LOGGER.info("Registering Mod Items for " + MagusArmors.MOD_ID);

    }
}
