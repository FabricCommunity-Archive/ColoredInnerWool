package com.github.fabriccommunity.coloredinnerwool.mixin;

import com.github.fabriccommunity.coloredinnerwool.SheepInnerWoolRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.SheepEntityRenderer;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.entity.passive.SheepEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SheepEntityRenderer.class)
public abstract class SheepRendererMixin extends MobEntityRenderer<SheepEntity, SheepEntityModel<SheepEntity>> {
	public SheepRendererMixin(EntityRenderDispatcher dispatcher, SheepEntityModel<SheepEntity> model, float f) {
		super(dispatcher, model, f);
	}

	@Inject(at = @At("RETURN"), method = "<init>")
	private void init(CallbackInfo info) {
		addFeature(new SheepInnerWoolRenderer((SheepEntityRenderer) (Object) this));
	}
}
