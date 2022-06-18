package eu.midnightdust.timechanger;

import eu.midnightdust.timechanger.command.CTimeCommand;
import eu.midnightdust.timechanger.config.TimeChangerConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;

public class TimeChangerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        TimeChangerConfig.init("timechanger", TimeChangerConfig.class);
        if (ClientCommandManager.getActiveDispatcher() != null)
            ClientCommandManager.getActiveDispatcher().register(ClientCommandManager.literal("ctime")
                    .then(CTimeCommand.command())
            );
    }
}
