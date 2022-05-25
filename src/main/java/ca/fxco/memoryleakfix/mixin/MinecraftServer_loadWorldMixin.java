package ca.fxco.memoryleakfix.mixin;

import ca.fxco.memoryleakfix.memoryLeakFix;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MinecraftServer_loadWorldMixin {


    @Inject(
            method = "loadWorld",
            at = @At("RETURN")
    )
    private void onFinishedLoadingWorlds(CallbackInfo ci) {
        memoryLeakFix.forceLoadAllMixinsAndClearSpongePoweredCache();
    }
}