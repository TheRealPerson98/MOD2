package com.person98.mod2.mixin;

import com.person98.mod2.entity.CoalOreMob;
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

import static com.person98.mod2.Mod2.COAL_ORE_MOB;

@Mixin(Block.class)
public class BlockMixin {

    @Unique
    private static final Map<Block, EntityType<?>> ORE_ENTITY_MAPPING;

    static {
        ORE_ENTITY_MAPPING = new HashMap<>();
        ORE_ENTITY_MAPPING.put(Blocks.COAL_ORE, COAL_ORE_MOB);
//        ORE_ENTITY_MAPPING.put(Blocks.IRON_ORE, IRON_ORE_MOB);
        // ... Add the rest of the ore block to entity mappings ...
        // Make sure the entity type constants you use here are correctly imported and accessible.
    }

    @Inject(at = @At("HEAD"), method = "onBroken", cancellable = true)
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state, CallbackInfo ci) {
        EntityType<?> entityType = ORE_ENTITY_MAPPING.get(state.getBlock());

        if (entityType != null && world instanceof World realWorld && !world.isClient()) {

            Entity oreMobEntity = entityType.create(realWorld);
            if (oreMobEntity instanceof CoalOreMob oreMob) {
                oreMob.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);

                realWorld.spawnEntity(oreMob);
                oreMob.setShouldTransformBack(true);  // Setting the flag to transform back after 5 seconds

                realWorld.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
            ci.cancel();
        }
    }

}
