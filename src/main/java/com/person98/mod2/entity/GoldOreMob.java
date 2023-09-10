package com.person98.mod2.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class GoldOreMob extends PathAwareEntity {
    private boolean shouldTransformBack = false;

    public GoldOreMob(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D);
    }
    @Override
    protected void initGoals() {
        super.initGoals();

        this.targetSelector.add(1, new RevengeGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, true));

    }
    @Override
    public void tick() {
        super.tick();

        if (this.shouldTransformBack && this.age >= 100) {  // Check age for 5 seconds
            // Turn back to coal ore
            this.getWorld().setBlockState(this.getBlockPos(), Blocks.GOLD_ORE.getDefaultState());
            this.remove(RemovalReason.DISCARDED);  // or other appropriate removal reason
        }
    }

    public void setShouldTransformBack(boolean shouldTransformBack) {
        this.shouldTransformBack = shouldTransformBack;
    }
}