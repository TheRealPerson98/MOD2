package com.person98.mod2.mixin;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public class MixinSheepEntity {

    private int colorIndex = -1;

    @Inject(at = @At("TAIL"), method = "initialize(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/world/LocalDifficulty;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/entity/EntityData;Lnet/minecraft/nbt/NbtCompound;)Lnet/minecraft/entity/EntityData;")
    public void onInitialize(CallbackInfoReturnable ci) {
        SheepEntity self = (SheepEntity)(Object)this;

        DyeColor[] colors = DyeColor.values();
        colorIndex = self.getWorld().getRandom().nextInt(colors.length);
        self.setColor(colors[colorIndex]);
    }

    @Inject(at = @At("TAIL"), method = "mobTick()V", cancellable = true)
    public void onTick(CallbackInfo ci) {
        if ((Object) this instanceof SheepEntity) {
            SheepEntity self = (SheepEntity) (Object) this;

            if (self.age % 20 == 0) { // Change color every 60 ticks or 3 seconds
                DyeColor[] colors = DyeColor.values();
                colorIndex = (colorIndex + 1) % colors.length;
                self.setColor(colors[colorIndex]);
            }
        }
    }

}
