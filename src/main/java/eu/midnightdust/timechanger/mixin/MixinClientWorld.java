package eu.midnightdust.timechanger.mixin;

import eu.midnightdust.timechanger.TimeChangerClient;
import eu.midnightdust.timechanger.config.TimeChangerConfig;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Supplier;

@Mixin(ClientWorld.class)

public abstract class MixinClientWorld extends World {

    protected MixinClientWorld(MutableWorldProperties properties, RegistryKey<World> registryRef, DynamicRegistryManager registryManager, RegistryEntry<DimensionType> dimensionEntry, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long biomeAccess, int maxChainedNeighborUpdates) {
        super(properties, registryRef, registryManager, dimensionEntry, profiler, isClient, debugWorld, biomeAccess, maxChainedNeighborUpdates);
    }
    @Override
    public float getRainGradient(float delta) {
        if (TimeChangerClient.isEnabledOnWorld() && !TimeChangerConfig.custom_weather.equals(TimeChangerConfig.Weather.UNSET)) {
            if (TimeChangerConfig.custom_weather.equals(TimeChangerConfig.Weather.CLEAR)) {
                return 0f;
            } else return 1f;
        }
        return super.getRainGradient(delta);
    }

    @Override
    public float getThunderGradient(float delta) {
        if (TimeChangerClient.isEnabledOnWorld() && !TimeChangerConfig.custom_weather.equals(TimeChangerConfig.Weather.UNSET)) {
            if (TimeChangerConfig.custom_weather.equals(TimeChangerConfig.Weather.THUNDER)) {
                return 1f;
            } else return 0f;
        }
        return super.getRainGradient(delta);
    }
}
