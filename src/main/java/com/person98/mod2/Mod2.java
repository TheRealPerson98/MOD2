package com.person98.mod2;

import com.person98.mod2.entity.*;
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

	public static final EntityType<CoalOreMob> COAL_ORE_MOB = createOreMob("coal_ore_mob", CoalOreMob::new);
	public static final EntityType<IronOreMob> IRON_ORE_MOB = createOreMob("iron_ore_mob", IronOreMob::new);
	public static final EntityType<GoldOreMob> GOLD_ORE_MOB = createOreMob("gold_ore_mob", GoldOreMob::new);
	public static final EntityType<DiamondOreMob> DIAMOND_ORE_MOB = createOreMob("diamond_ore_mob", DiamondOreMob::new);
	public static final EntityType<EmeraldOreMob> EMERALD_ORE_MOB = createOreMob("emerald_ore_mob", EmeraldOreMob::new);
	public static final EntityType<LapisOreMob> LAPIS_ORE_MOB = createOreMob("lapis_ore_mob", LapisOreMob::new);
	public static final EntityType<RedstoneOreMob> REDSTONE_ORE_MOB = createOreMob("redstone_ore_mob", RedstoneOreMob::new);
	public static final EntityType<CopperOreMob> COPPER_ORE_MOB = createOreMob("copper_ore_mob", CopperOreMob::new);


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

		FabricDefaultAttributeRegistry.register(COAL_ORE_MOB, CoalOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(IRON_ORE_MOB, IronOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(GOLD_ORE_MOB, GoldOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(DIAMOND_ORE_MOB, DiamondOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(EMERALD_ORE_MOB, EmeraldOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(LAPIS_ORE_MOB, LapisOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(REDSTONE_ORE_MOB, RedstoneOreMob.createMobAttributes());
		FabricDefaultAttributeRegistry.register(COPPER_ORE_MOB, CopperOreMob.createMobAttributes());


		// Continue for other ores...
	}
}