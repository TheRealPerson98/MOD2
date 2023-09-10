package com.person98.mod2.item;

import com.person98.mod2.Mod2;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MOD2GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mod2.MOD_ID, "mod2"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mod2"))
                    .icon(() -> new ItemStack(ModItems.COAL_MOB_EGG)).entries((displayContext, entries) -> {
                        entries.add(ModItems.COAL_MOB_EGG);
                        entries.add(ModItems.IRON_MOB_EGG);
                        entries.add(ModItems.GOLD_MOB_EGG);
                        entries.add(ModItems.DIAMOND_MOB_EGG);
                        entries.add(ModItems.EMERALD_MOB_EGG);
                        entries.add(ModItems.LAPIS_MOB_EGG);
                        entries.add(ModItems.REDSTONE_MOB_EGG);
                        entries.add(ModItems.COPPER_MOB_EGG);
                        entries.add(ModItems.DEEP_COAL_MOB_EGG);
                        entries.add(ModItems.DEEP_IRON_MOB_EGG);
                        entries.add(ModItems.DEEP_GOLD_MOB_EGG);
                        entries.add(ModItems.DEEP_DIAMOND_MOB_EGG);
                        entries.add(ModItems.DEEP_EMERALD_MOB_EGG);
                        entries.add(ModItems.DEEP_LAPIS_MOB_EGG);
                        entries.add(ModItems.DEEP_REDSTONE_MOB_EGG);
                        entries.add(ModItems.DEEP_COPPER_MOB_EGG);
                    }).build());


    public static void registerItemGroups() {
        Mod2.LOGGER.info("Registering Item Groups for " + Mod2.MOD_ID);
    }
}