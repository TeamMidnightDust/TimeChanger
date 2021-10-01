package eu.midnightdust.timechanger.command;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import eu.midnightdust.timechanger.TimeChangerClient;
import eu.midnightdust.timechanger.config.TimeChangerConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;
import net.minecraft.text.TranslatableText;

import static net.fabricmc.fabric.api.client.command.v1.ClientCommandManager.argument;

public class CTimeCommand {

    public static LiteralArgumentBuilder<FabricClientCommandSource> command() {
        return ClientCommandManager.literal("set").then(
                argument("time", IntegerArgumentType.integer(0))
                        .executes(ctx -> setTime(ctx.getSource(), IntegerArgumentType.getInteger(ctx, "time")))
        );
    }

    private static int setTime(FabricClientCommandSource source, int time) {
        TimeChangerClient.TC_CONFIG.custom_time = time;
        AutoConfig.getConfigHolder(TimeChangerConfig.class).save();

        source.sendFeedback(new TranslatableText("command.timechanger.ctime.success").append(String.valueOf(time)));
        return 1;
    }

}