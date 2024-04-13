package net.thev123.magusarmors.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.thev123.magusarmors.MagusArmors;
import net.minecraft.registry.Registry;

public class ModItemGroups {
    public static final ItemGroup UPGRADE = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MagusArmors.MOD_ID, "magus_armors"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.awesomearmaments"))
                    .icon(() -> new ItemStack(Items.DIAMOND)).entries((displayContext, entries) -> {

                    }).build());

    public static void registerItemGroups() {
        MagusArmors.LOGGER.info("Registering Item Groups for " + MagusArmors.MOD_ID);
    }
}