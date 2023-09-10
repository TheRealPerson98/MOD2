package com.person98.mod2.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Mixin(Block.class)
public class BlockMixin {
    private static Set<Block> ORES = null;

    private static Set<Block> getOres() {
        if (ORES == null) {
            ORES = new HashSet<>(
                    Arrays.asList(
                            Blocks.COAL_ORE,
                            Blocks.IRON_ORE,
                            Blocks.GOLD_ORE,
                            Blocks.DIAMOND_ORE,
                            Blocks.REDSTONE_ORE,
                            Blocks.LAPIS_ORE,
                            Blocks.NETHER_QUARTZ_ORE,
                            Blocks.EMERALD_ORE
                            //... Add any other ores you consider
                    )
            );
        }
        return ORES;
    }

    @Inject(at = @At("HEAD"), method = "onBroken", cancellable = true)
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state, CallbackInfo ci) {
        if (world instanceof World && !world.isClient() && getOres().contains(state.getBlock())) {
            World realWorld = (World) world;


            EntityType<CowEntity> type = EntityType.COW;
            CowEntity fakeOreCow = type.create(realWorld);

            if (fakeOreCow != null) {
                fakeOreCow.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
                fakeOreCow.setAiDisabled(true);
                realWorld.spawnEntity(fakeOreCow);

                // Making the cow look like the ore block
                fakeOreCow.setCustomNameVisible(false);
                // Set the cow's texture or model to resemble the ore - this part is complex and might require further work

                // Triggering the cow's panic behavior without causing damage
                fakeOreCow.setOnFire(true);

                realWorld.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
            ci.cancel();
        }
    }

}
