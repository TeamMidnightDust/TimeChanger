package eu.midnightdust.timechanger;

import eu.midnightdust.timechanger.config.TimeChangerConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class TimeChangerClient implements ClientModInitializer {

    public static TimeChangerConfig TC_CONFIG;

    @Override
    public void onInitializeClient() {
        AutoConfig.register(TimeChangerConfig.class, JanksonConfigSerializer::new);
        TC_CONFIG = AutoConfig.getConfigHolder(TimeChangerConfig.class).getConfig();
    }
}
