package com.person98.mod2.item;

import com.person98.mod2.Mod2;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COAL_MOB_EGG = registerItem("coal_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item IRON_MOB_EGG = registerItem("iron_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item GOLD_MOB_EGG = registerItem("gold_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_MOB_EGG = registerItem("diamond_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item EMERALD_MOB_EGG = registerItem("emerald_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item LAPIS_MOB_EGG = registerItem("lapis_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item REDSTONE_MOB_EGG = registerItem("redstone_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item COPPER_MOB_EGG = registerItem("copper_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item DEEP_COAL_MOB_EGG = registerItem("deep_coal_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item DEEP_IRON_MOB_EGG = registerItem("deep_iron_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item DEEP_GOLD_MOB_EGG = registerItem("deep_gold_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item DEEP_DIAMOND_MOB_EGG = registerItem("deep_diamond_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item DEEP_EMERALD_MOB_EGG = registerItem("deep_emerald_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item DEEP_LAPIS_MOB_EGG = registerItem("deep_lapis_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item DEEP_REDSTONE_MOB_EGG = registerItem("deep_redstone_ore_mob_egg", new Item(new FabricItemSettings()));
    public static final Item DEEP_COPPER_MOB_EGG = registerItem("deep_copper_ore_mob_egg", new Item(new FabricItemSettings()));



    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(COAL_MOB_EGG);
        entries.add(IRON_MOB_EGG);
        entries.add(GOLD_MOB_EGG);
        entries.add(DIAMOND_MOB_EGG);
        entries.add(EMERALD_MOB_EGG);
        entries.add(LAPIS_MOB_EGG);
        entries.add(REDSTONE_MOB_EGG);
        entries.add(COPPER_MOB_EGG);
        entries.add(DEEP_COAL_MOB_EGG);
        entries.add(DEEP_IRON_MOB_EGG);
        entries.add(DEEP_GOLD_MOB_EGG);
        entries.add(DEEP_DIAMOND_MOB_EGG);
        entries.add(DEEP_EMERALD_MOB_EGG);
        entries.add(DEEP_LAPIS_MOB_EGG);
        entries.add(DEEP_REDSTONE_MOB_EGG);
        entries.add(DEEP_COPPER_MOB_EGG);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Mod2.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Mod2.LOGGER.info("Registering Mod Items for " + Mod2.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}