package com.person98.mod2.datagen;

import com.person98.mod2.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


        itemModelGenerator.register(ModItems.COAL_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAPIS_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDSTONE_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEEP_COAL_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEEP_IRON_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEEP_GOLD_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEEP_DIAMOND_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEEP_EMERALD_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEEP_LAPIS_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEEP_REDSTONE_MOB_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEEP_COPPER_MOB_EGG, Models.GENERATED);

    }
}