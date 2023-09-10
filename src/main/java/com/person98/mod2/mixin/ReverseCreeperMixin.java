package com.person98.mod2.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Mixin(CreeperEntity.class)
public class ReverseCreeperMixin {

    @Inject(method = "explode", at = @At("HEAD"), cancellable = true)
    private void onExplode(CallbackInfo ci) {
        CreeperEntity creeper = (CreeperEntity) (Object) this;
        World world = creeper.getWorld();

        if (!world.isClient) {  // Ensure we are on the server-side
            BlockPos creeperPos = creeper.getBlockPos();
            Random random = new Random();

            // Despawn the creeper
            creeper.remove(Entity.RemovalReason.DISCARDED);

            // Create a 3x3 smoothed hill
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    int height = 2 - Math.abs(x) - Math.abs(z);  // This gives a smoothed hill shape (3, 2, 3 in height)
                    for (int y = 0; y < height; y++) {
                        BlockPos blockPos = creeperPos.add(x, y, z);
                        Block randomBlock = getRandomBlock(random);
                        world.setBlockState(blockPos, randomBlock.getDefaultState());
                    }
                }
            }

            // Cancel the original explosion
            ci.cancel();
        }
    }

    private Block getRandomBlock(Random random) {
        Block[] blocks = {
                Blocks.STONE,
                Blocks.DIRT,
                Blocks.GRASS_BLOCK,
                Blocks.COBBLESTONE,
                Blocks.OAK_LOG,
                Blocks.OAK_PLANKS,
                Blocks.SAND,
                Blocks.GRAVEL,
                Blocks.BRICKS,
                Blocks.MOSSY_COBBLESTONE,
                Blocks.OBSIDIAN,
                Blocks.SNOW_BLOCK,
                Blocks.CLAY,
                Blocks.PUMPKIN,
                Blocks.MELON,
                Blocks.MYCELIUM,
                Blocks.NETHERRACK,
                Blocks.SOUL_SAND,
                Blocks.GLOWSTONE,
                Blocks.NETHER_BRICKS,
                Blocks.END_STONE,
                Blocks.PURPUR_BLOCK,
                Blocks.MAGMA_BLOCK,

                // ... add more blocks as desired
        };

        return blocks[random.nextInt(blocks.length)];
    }
}
