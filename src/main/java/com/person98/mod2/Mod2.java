package com.person98.mod2;

import com.person98.mod2.entity.*;
import com.person98.mod2.item.ModItemGroups;
import com.person98.mod2.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod2 implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("mod2");
	public static final String MOD_ID = "mod2";

	public static final EntityType<CoalOreMob> COAL_ORE_MOB = createOreMob("coal_ore_mob", CoalOreMob::new);
	public static final EntityType<IronOreMob> IRON_ORE_MOB = createOreMob("iron_ore_mob", IronOreMob::new);
	public static final EntityType<GoldOreMob> GOLD_ORE_MOB = createOreMob("gold_ore_mob", GoldOreMob::new);
	public static final EntityType<DiamondOreMob> DIAMOND_ORE_MOB = createOreMob("diamond_ore_mob", DiamondOreMob::new);
	public static final EntityType<EmeraldOreMob> EMERALD_ORE_MOB = createOreMob("emerald_ore_mob", EmeraldOreMob::new);
	public static final EntityType<LapisOreMob> LAPIS_ORE_MOB = createOreMob("lapis_ore_mob", LapisOreMob::new);
	public static final EntityType<RedstoneOreMob> REDSTONE_ORE_MOB = createOreMob("redstone_ore_mob", RedstoneOreMob::new);
	public static final EntityType<CopperOreMob> COPPER_ORE_MOB = createOreMob("copper_ore_mob", CopperOreMob::new);

	public static final EntityType<CoalDeepSlateOreMob> DEEP_COAL_ORE_MOB = createOreMob("deep_coal_ore_mob", CoalDeepSlateOreMob::new);
	public static final EntityType<IronDeepSlateOreMob> DEEP_IRON_ORE_MOB = createOreMob("deep_iron_ore_mob", IronDeepSlateOreMob::new);
	public static final EntityType<GoldDeepSlateOreMob> DEEP_GOLD_ORE_MOB = createOreMob("deep_gold_ore_mob", GoldDeepSlateOreMob::new);
	public static final EntityType<DiamondDeepSlateOreMob> DEEP_DIAMOND_ORE_MOB = createOreMob("deep_diamond_ore_mob", DiamondDeepSlateOreMob::new);
	public static final EntityType<EmeraldDeepSlateOreMob> DEEP_EMERALD_ORE_MOB = createOreMob("deep_emerald_ore_mob", EmeraldDeepSlateOreMob::new);
	public static final EntityType<LapisDeepSlateOreMob> DEEP_LAPIS_ORE_MOB = createOreMob("deep_lapis_ore_mob", LapisDeepSlateOreMob::new);
	public static final EntityType<RedstoneDeepSlateOreMob> DEEP_REDSTONE_ORE_MOB = createOreMob("deep_redstone_ore_mob", RedstoneDeepSlateOreMob::new);
	public static final EntityType<CopperDeepSlateOreMob> DEEP_COPPER_ORE_MOB = createOreMob("deep_copper_ore_mob", CopperDeepSlateOreMob::new);




	private static <T extends Entity> EntityType<T> createOreMob(String id, EntityType.EntityFactory<T> factory) {
		return Registry.register(
				Registries.ENTITY_TYPE,
				new Identifier("mod2", id),
				FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, factory).dimensions(EntityDimensions.fixed(1f, 1f)).build()
		);
	}



	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		FabricDefaultAttributeRegistry.register(COAL_ORE_MOB, CoalOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(IRON_ORE_MOB, IronOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(GOLD_ORE_MOB, GoldOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(DIAMOND_ORE_MOB, DiamondOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(EMERALD_ORE_MOB, EmeraldOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(LAPIS_ORE_MOB, LapisOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(REDSTONE_ORE_MOB, RedstoneOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(COPPER_ORE_MOB, CopperOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(DEEP_COAL_ORE_MOB, CopperDeepSlateOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(DEEP_IRON_ORE_MOB, CopperDeepSlateOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(DEEP_GOLD_ORE_MOB, CopperDeepSlateOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(DEEP_DIAMOND_ORE_MOB, CopperDeepSlateOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(DEEP_EMERALD_ORE_MOB, CopperDeepSlateOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(DEEP_LAPIS_ORE_MOB, CopperDeepSlateOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(DEEP_REDSTONE_ORE_MOB, CopperDeepSlateOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(DEEP_COPPER_ORE_MOB, CopperDeepSlateOreMob.createMobAttributes());




		// Continue for other ores...
	}
}