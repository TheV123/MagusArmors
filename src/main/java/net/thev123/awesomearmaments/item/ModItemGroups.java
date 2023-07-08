package net.thev123.awesomearmaments.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.thev123.awesomearmaments.AwesomeArmaments;
import net.minecraft.registry.Registry;

public class ModItemGroups {
    public static final ItemGroup UPGRADE = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AwesomeArmaments.MOD_ID, "upgrade"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.upgrade"))
                    .icon(() -> new ItemStack(ModItems.PLATED_IRON_UPGRADE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.PLATED_IRON_UPGRADE);
                        entries.add(ModItems.PLATED_DIAMOND_UPGRADE);
                        entries.add(ModItems.PLATED_NETHERITE_UPGRADE);
                    }).build());

    public static void registerItemGroups() {
        AwesomeArmaments.LOGGER.info("Registering Item Groups for " + AwesomeArmaments.MOD_ID);
    }
}
