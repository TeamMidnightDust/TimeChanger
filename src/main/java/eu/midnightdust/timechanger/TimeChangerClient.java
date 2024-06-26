package eu.midnightdust.timechanger;

import eu.midnightdust.timechanger.command.CTimeCommand;
import eu.midnightdust.timechanger.command.CWeatherCommand;
import eu.midnightdust.timechanger.config.TimeChangerConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;

public class TimeChangerClient implements ClientModInitializer {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    @Override
    public void onInitializeClient() {
        TimeChangerConfig.init("timechanger", TimeChangerConfig.class);
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(CTimeCommand.command()));
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(CWeatherCommand.command()));
    }
    public static boolean isEnabledOnWorld() {
        if (client.getCurrentServerEntry() != null) {
            if (TimeChangerConfig.allowlist.isEmpty()) {
                return true;
            } else if (client.getCurrentServerEntry().address != null) {
                if (!TimeChangerConfig.blocklist && TimeChangerConfig.allowlist.contains(client.getCurrentServerEntry().address)) {
                    return true;
                } else return TimeChangerConfig.blocklist && !TimeChangerConfig.allowlist.contains(client.getCurrentServerEntry().address);
            }
            return false;
        }
        return TimeChangerConfig.enableInSingleplayer;
    }
}
