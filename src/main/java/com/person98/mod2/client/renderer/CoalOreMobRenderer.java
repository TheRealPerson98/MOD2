package com.person98.mod2.client.renderer;

import com.person98.mod2.Mod2Client;
import com.person98.mod2.client.model.CoalOreMobModel;
import com.person98.mod2.entity.CoalOreMob;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CoalOreMobRenderer extends MobEntityRenderer<CoalOreMob, CoalOreMobModel> {
    public CoalOreMobRenderer(EntityRendererFactory.Context context) {
        super(context, new CoalOreMobModel(context.getPart(Mod2Client.MODEL_COAL_ORE_MOB_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(CoalOreMob entity) {
        return new Identifier("mod2", "textures/entity/cube.png");
    }
}

