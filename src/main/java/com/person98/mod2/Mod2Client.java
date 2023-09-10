package com.person98.mod2;


import com.person98.mod2.client.model.CoalOreMobModel;
import com.person98.mod2.client.renderer.CoalOreMobRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class Mod2Client implements ClientModInitializer {

    public static final EntityModelLayer MODEL_COAL_ORE_MOB_LAYER = new EntityModelLayer(new Identifier("mod2", "coal_ore_mob"), "main");

    @Override
    public void onInitializeClient() {
        net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.register(Mod2.COAL_ORE_MOB, CoalOreMobRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_COAL_ORE_MOB_LAYER, CoalOreMobModel::getTexturedModelData);
    }
}
