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
            new Identifier(AwesomeArmaments.MOD_ID, "awesome_armaments"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.awesomearmaments"))
                    .icon(() -> new ItemStack(ModItems.PLATED_IRON_HELMET)).entries((displayContext, entries) -> {
                        entries.add(ModItems.PLATED_IRON_UPGRADE);
                        entries.add(ModItems.PLATED_DIAMOND_UPGRADE);
                        entries.add(ModItems.PLATED_NETHERITE_UPGRADE);
                        entries.add(ModItems.PLATED_IRON_HELMET);
                        entries.add(ModItems.PLATED_IRON_CHESTPLATE);
                        entries.add(ModItems.PLATED_IRON_LEGGINGS);
                        entries.add(ModItems.PLATED_IRON_BOOTS);
                        entries.add(ModItems.PLATED_DIAMOND_HELMET);
                        entries.add(ModItems.PLATED_DIAMOND_CHESTPLATE);
                        entries.add(ModItems.PLATED_DIAMOND_LEGGINGS);
                        entries.add(ModItems.PLATED_DIAMOND_BOOTS);
                        entries.add(ModItems.PLATED_NETHERITE_HELMET);
                        entries.add(ModItems.PLATED_NETHERITE_CHESTPLATE);
                        entries.add(ModItems.PLATED_NETHERITE_LEGGINGS);
                        entries.add(ModItems.PLATED_NETHERITE_BOOTS);

                        entries.add(ModItems.WISE_IRON);
                        entries.add(ModItems.WISE_IRON_HELMET);
                        entries.add(ModItems.WISE_IRON_CHESTPLATE);
                        entries.add(ModItems.WISE_IRON_LEGGINGS);
                        entries.add(ModItems.WISE_IRON_BOOTS);
                        entries.add(ModItems.WISE_DIAMOND);
                        entries.add(ModItems.WISE_DIAMOND_UPGRADE);
                        entries.add(ModItems.WISE_DIAMOND_HELMET);
                        entries.add(ModItems.WISE_DIAMOND_CHESTPLATE);
                        entries.add(ModItems.WISE_DIAMOND_LEGGINGS);
                        entries.add(ModItems.WISE_DIAMOND_BOOTS);
                        entries.add(ModItems.WISE_NETHERITE);
                        entries.add(ModItems.WISE_NETHERITE_UPGRADE);
                        entries.add(ModItems.WISE_NETHERITE_HELMET);
                        entries.add(ModItems.WISE_NETHERITE_CHESTPLATE);
                        entries.add(ModItems.WISE_NETHERITE_LEGGINGS);
                        entries.add(ModItems.WISE_NETHERITE_BOOTS);

                        entries.add(ModItems.AQUA_DIAMOND);
                        entries.add(ModItems.AQUA_DIAMOND_HELMET);
                        entries.add(ModItems.AQUA_DIAMOND_CHESTPLATE);
                        entries.add(ModItems.AQUA_DIAMOND_LEGGINGS);
                        entries.add(ModItems.AQUA_DIAMOND_BOOTS);
                        entries.add(ModItems.AQUA_NETHERITE);

                        entries.add(ModItems.BULWARK_HELMET);
                        entries.add(ModItems.BULWARK_CHESTPLATE);
                        entries.add(ModItems.BULWARK_LEGGINGS);
                        entries.add(ModItems.BULWARK_BOOTS);


                    }).build());

    public static void registerItemGroups() {
        AwesomeArmaments.LOGGER.info("Registering Item Groups for " + AwesomeArmaments.MOD_ID);
    }
}
