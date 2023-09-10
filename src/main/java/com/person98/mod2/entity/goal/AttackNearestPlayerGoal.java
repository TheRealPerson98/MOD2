package com.person98.mod2.entity.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;

import java.util.EnumSet;

public class AttackNearestPlayerGoal extends Goal {
    private final MobEntity mob;
    private LivingEntity target;
    private final double speed;

    public AttackNearestPlayerGoal(MobEntity mob, double speed) {
        this.mob = mob;
        this.speed = speed;
        setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK, Goal.Control.JUMP));
    }

    @Override
    public boolean canStart() {
        this.target = this.mob.getWorld().getClosestPlayer(this.mob, 10); // 10 is the detection range, you can adjust as needed
        if (this.target == null) {
            return false;
        } else {
            return this.mob.canTarget(this.target);
        }
    }

    @Override
    public boolean shouldContinue() {
        return canStart() && !this.mob.getNavigation().isIdle();
    }

    @Override
    public void start() {
        this.mob.setTarget(this.target);
        super.start();
    }

    @Override
    public void stop() {
        this.mob.setTarget(null);
        super.stop();
    }

    @Override
    public void tick() {
        this.mob.getLookControl().lookAt(this.target, 10.0F, 10.0F);
        this.mob.getNavigation().startMovingTo(this.target, this.speed);
    }
}
