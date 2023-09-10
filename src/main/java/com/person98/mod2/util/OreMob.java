package com.person98.mod2.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;

public interface OreMob {
    void setShouldTransformBack(boolean shouldTransformBack);
    void refreshPositionAndAngles(double x, double y, double z, float yaw, float pitch);

}
