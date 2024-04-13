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
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.magusarmors"))
                    .icon(() -> new ItemStack(ModItems.FIRE_HELMET)).entries((displayContext, entries) -> {
                        entries.add(ModItems.FIRE_HELMET);
                        entries.add(ModItems.FIRE_CHESTPLATE);
                        entries.add(ModItems.FIRE_LEGGINGS);
                        entries.add(ModItems.FIRE_BOOTS);

                        entries.add(ModItems.FROST_HELMET);
                        entries.add(ModItems.FROST_CHESTPLATE);
                        entries.add(ModItems.FROST_LEGGINGS);
                        entries.add(ModItems.FROST_BOOTS);

                        entries.add(ModItems.ARCANE_HELMET);
                        entries.add(ModItems.ARCANE_CHESTPLATE);
                        entries.add(ModItems.ARCANE_LEGGINGS);
                        entries.add(ModItems.ARCANE_BOOTS);

                        entries.add(ModItems.HEALING_HELMET);
                        entries.add(ModItems.HEALING_CHESTPLATE);
                        entries.add(ModItems.HEALING_LEGGINGS);
                        entries.add(ModItems.HEALING_BOOTS);

                        entries.add(ModItems.RANGED_HELMET);
                        entries.add(ModItems.RANGED_CHESTPLATE);
                        entries.add(ModItems.RANGED_LEGGINGS);
                        entries.add(ModItems.RANGED_BOOTS);
                    }).build());

    public static void registerItemGroups() {
        MagusArmors.LOGGER.info("Registering Item Groups for " + MagusArmors.MOD_ID);
    }
}
