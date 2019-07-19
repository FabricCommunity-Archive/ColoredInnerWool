package com.github.fabriccommunity.coloredinnerwool;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class SheepInnerWoolRenderer extends FeatureRenderer<SheepEntity, SheepEntityModel<SheepEntity>> {
    private static final Identifier SKIN = new Identifier("coloredinnerwool", "textures/entity/sheep/sheep_inner_fur.png");

    public SheepInnerWoolRenderer(FeatureRendererContext<SheepEntity, SheepEntityModel<SheepEntity>> context) {
        super(context);
    }

    @Override
    public void render(SheepEntity sheep, float f1, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (!sheep.isInvisible()) {
            bindTexture(SKIN);

            if (sheep.hasCustomName() && "jeb_".equals(sheep.getName().asString())) {
//                int i = sheep.age / 25 + sheep.getEntityId();
//
//                int numColors = DyeColor.values().length;
//
//                int colorIdx1 = i % numColors;
//                int colorIdx2 = (i + 1) % numColors;
//
//                float progress = (sheep.age % 25 + f3) / 25.0F;
//
//                float[] rgb1 = SheepEntity.getRgbColor(DyeColor.byId(colorIdx1));
//                float[] rgb2 = SheepEntity.getRgbColor(DyeColor.byId(colorIdx2));
//
//                float red = rgb1[0] * (1.0F - progress) + rgb2[0] * progress;
//                float blue = rgb1[1] * (1.0F - progress) + rgb2[1] * progress;
//                float green = rgb1[2] * (1.0F - progress) + rgb2[2] * progress;
//
//                GlStateManager.color3f(red, blue, green);

                float[] rgb = SheepEntity.getRgbColor(sheep.getColor());
                GlStateManager.color3f(rgb[0], rgb[1], rgb[2]);
            } else {
                float[] rgb = SheepEntity.getRgbColor(sheep.getColor());
                GlStateManager.color3f(rgb[0], rgb[1], rgb[2]);
            }

            getModel().render(sheep, f1, f2, f4, f5, f6, f7);
        }
    }

    @Override
    public boolean hasHurtOverlay() {
        return true;
    }
}
