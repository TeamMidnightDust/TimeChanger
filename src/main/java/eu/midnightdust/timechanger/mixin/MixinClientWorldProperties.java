package eu.midnightdust.timechanger.mixin;

import eu.midnightdust.timechanger.TimeChangerClient;
import eu.midnightdust.timechanger.config.TimeChangerConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientWorld.Properties.class)

public abstract class MixinClientWorldProperties {

    @Inject(at = @At("RETURN"), method = "getTimeOfDay", cancellable = true)
    @Environment(EnvType.CLIENT)
    public void getTimeOfDay(CallbackInfoReturnable<Long> cir) {
        if (TimeChangerClient.isEnabledOnWorld() && TimeChangerConfig.custom_time >= 0) {
            cir.setReturnValue((long) TimeChangerConfig.custom_time);
        }
        else cir.cancel();
    }
}
