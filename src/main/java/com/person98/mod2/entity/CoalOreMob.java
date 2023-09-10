package com.person98.mod2.entity;

import com.person98.mod2.entity.goal.MeleeAttackPlayerGoal;
import com.person98.mod2.util.OreMob;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
public class CoalOreMob extends PathAwareEntity implements OreMob {
    private boolean shouldTransformBack = false;


    public CoalOreMob(EntityType<? extends PathAwareEntity> entityType, World world) {

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

        this.goalSelector.add(1, new MeleeAttackPlayerGoal(this, 1.0D, false)); // 1.0D is the speed, adjust as needed

    }


    @Override
    public void tick() {
        super.tick();

        if (this.shouldTransformBack && this.age >= 100) {  // Check age for 5 seconds
            // Turn back to coal ore
            this.getWorld().setBlockState(this.getBlockPos(), Blocks.COAL_ORE.getDefaultState());
            this.remove(RemovalReason.DISCARDED);  // or other appropriate removal reason
        }
    }
    public void setShouldTransformBack(boolean shouldTransformBack) {
        this.shouldTransformBack = shouldTransformBack;
    }

}