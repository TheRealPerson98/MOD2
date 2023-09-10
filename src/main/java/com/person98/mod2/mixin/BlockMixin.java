package com.person98.mod2.mixin;

import com.person98.mod2.entity.*;
import com.person98.mod2.util.OreMob;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

import static com.person98.mod2.Mod2.*;

@Mixin(Block.class)
public class BlockMixin {

    @Unique
    private static Map<Block, EntityType<?>> ORE_ENTITY_MAPPING;

    @Unique
    private static Map<Block, EntityType<?>> getOreEntityMapping() {
        if (ORE_ENTITY_MAPPING == null) {
            ORE_ENTITY_MAPPING = new HashMap<>();
            ORE_ENTITY_MAPPING.put(Blocks.COAL_ORE, COAL_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.IRON_ORE, IRON_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.GOLD_ORE, GOLD_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.REDSTONE_ORE, REDSTONE_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.LAPIS_ORE, LAPIS_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.DIAMOND_ORE, DIAMOND_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.EMERALD_ORE, EMERALD_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.COPPER_ORE, COPPER_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.DEEPSLATE_COAL_ORE, DEEP_COAL_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.DEEPSLATE_IRON_ORE, DEEP_IRON_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.DEEPSLATE_GOLD_ORE, DEEP_GOLD_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.DEEPSLATE_REDSTONE_ORE, DEEP_REDSTONE_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.DEEPSLATE_LAPIS_ORE, DEEP_LAPIS_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.DEEPSLATE_DIAMOND_ORE, DEEP_DIAMOND_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.DEEPSLATE_EMERALD_ORE, DEEP_EMERALD_ORE_MOB);
            ORE_ENTITY_MAPPING.put(Blocks.DEEPSLATE_COPPER_ORE, DEEP_COPPER_ORE_MOB);

        }
        return ORE_ENTITY_MAPPING;
    }

    @Inject(at = @At("HEAD"), method = "onBroken", cancellable = true)
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state, CallbackInfo ci) {
        EntityType<?> entityType = getOreEntityMapping().get(state.getBlock());

        // Initial logging to confirm entityType detection
        if (entityType != null) {
            System.out.println("Found entityType for block!");
        }

        if (entityType != null && world instanceof World realWorld && !world.isClient()) {
            Entity oreMobEntity = entityType.create(realWorld);
            if (oreMobEntity instanceof OreMob oreMob) {
                oreMob.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
                realWorld.spawnEntity(oreMobEntity);
                oreMob.setShouldTransformBack(true);
                realWorld.setBlockState(pos, Blocks.AIR.getDefaultState());
                ci.cancel();
            }
        }
    }

}
