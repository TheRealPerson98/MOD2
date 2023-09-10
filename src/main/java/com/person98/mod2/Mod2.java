package com.person98.mod2;

import com.person98.mod2.entity.CoalOreMob;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod2 implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("mod2");

	public static final EntityType<CoalOreMob> COAL_ORE_MOB = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier("mod2", "coal_ore_mob"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CoalOreMob::new).dimensions(EntityDimensions.fixed(1f, 1f)).build()
	);
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		FabricDefaultAttributeRegistry.register(COAL_ORE_MOB, CoalOreMob.createMobAttributes());

	}
}