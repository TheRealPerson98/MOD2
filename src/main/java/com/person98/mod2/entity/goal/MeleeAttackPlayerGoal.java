package com.person98.mod2.entity.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;

public class MeleeAttackPlayerGoal extends MeleeAttackGoal {
    private final MobEntity mob;

    public MeleeAttackPlayerGoal(MobEntity mob, double speed, boolean pauseWhenMobIdle) {
        super((PathAwareEntity) mob, speed, pauseWhenMobIdle);
        this.mob = mob;
    }

    @Override
    public boolean canStart() {
        LivingEntity target = this.mob.getTarget();

        if (target == null || !(target instanceof PlayerEntity)) {
            PlayerEntity nearestPlayer = this.mob.getWorld().getClosestPlayer(this.mob, 10); // 10 is the detection range
            if (nearestPlayer != null) {
                this.mob.setTarget(nearestPlayer);
                return true;
            }
            return false;
        }

        return super.canStart();
    }
}
