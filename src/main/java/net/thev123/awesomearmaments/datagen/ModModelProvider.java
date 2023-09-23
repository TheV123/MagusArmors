package net.thev123.awesomearmaments.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.thev123.awesomearmaments.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.WINDCALLER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STORMCALLER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VENOMOUS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHERING_SWORD, Models.HANDHELD);
    }
}
