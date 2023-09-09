package com.person98.mod2.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(Entity.class)
public abstract class BounceMixin {

    @Shadow
    public World world;

    @Shadow
    public abstract Vec3d getVelocity();

    @Shadow
    public abstract void setVelocity(Vec3d velocity);

    private static final Random RANDOM = new Random();
    private static final float BOUNCE_CHANCE = 0.001F; // Adjust this for frequency
    private static final float BOUNCE_VELOCITY = 1.5F; // Adjust for bounce height

    @Inject(at = @At("HEAD"), method = "tick")
    private void onTick(CallbackInfo info) {
        if (!this.world.isClient && (Object) this instanceof LivingEntity) { // Check for server side & if entity is a living entity
            if (RANDOM.nextFloat() < BOUNCE_CHANCE) {
                this.setVelocity(this.getVelocity().add(0, BOUNCE_VELOCITY, 0));
            }
        }
    }
}
