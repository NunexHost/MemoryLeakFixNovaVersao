package ca.fxco.memoryleakfix.mixin.entityMemoriesLeak;

import ca.fxco.memoryleakfix.config.MinecraftRequirement;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Group;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@MinecraftRequirement(maxVersion = "1.19.3")
@Mixin(Entity.class)
public abstract class Entity_clearMemoriesMixin {

    @Group(name = "memoryLeakFix$onEntityRemoved", min = 1, max = 1)
    // method_5650 is the intermediary name which is needed because in older Minecraft versions the parameters of the method were different
    // we require 0 because using the intermediary name will probably cause issues on older minecraft versions with forge, and we simply don't care enough atm ¯\_(ツ)_/¯
    @Inject(method = "remove", at = @At("TAIL"))
    protected void memoryLeakFix$OnEntityRemoved(CallbackInfo ci) {
    }

    @Group(name = "memoryLeakFix$onEntityRemoved", min = 1, max = 1)
    @SuppressWarnings({"UnresolvedMixinReference", "MixinAnnotationTarget"})
    @Inject(method = "method_5650", at = @At("TAIL"), remap = false)
    protected void memoryLeakFix$OnEntityRemoved_inOlderVersions(CallbackInfo ci) {
        this.memoryLeakFix$OnEntityRemoved(ci);
    }
}
