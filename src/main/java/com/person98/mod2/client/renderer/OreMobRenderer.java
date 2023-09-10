package com.person98.mod2.client.renderer;

import com.person98.mod2.Mod2Client;
import com.person98.mod2.client.model.OreMobModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;

public class OreMobRenderer<T extends PathAwareEntity> extends MobEntityRenderer<T, OreMobModel<T>> {  // Specify the generic type for OreMobModel
    private final String texturePath;

    public OreMobRenderer(EntityRendererFactory.Context context, String texturePath) {
        super(context, new OreMobModel<>(context.getPart(Mod2Client.MODEL_COAL_ORE_MOB_LAYER)), 0.5f); // Add the generic type here
        this.texturePath = texturePath;
    }

    @Override
    public Identifier getTexture(T entity) {
        return new Identifier("mod2", texturePath);
    }
}
