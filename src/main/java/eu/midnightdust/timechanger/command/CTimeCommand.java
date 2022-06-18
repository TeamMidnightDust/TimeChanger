package eu.midnightdust.timechanger.command;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import eu.midnightdust.timechanger.config.TimeChangerConfig;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;

public class CTimeCommand {

    public static LiteralArgumentBuilder<FabricClientCommandSource> command() {
        return ClientCommandManager.literal("set").then(
                argument("time", IntegerArgumentType.integer(-1))
                        .executes(ctx -> setTime(ctx.getSource(), IntegerArgumentType.getInteger(ctx, "time")))
        );
    }

    private static int setTime(FabricClientCommandSource source, int time) {
        TimeChangerConfig.custom_time = time;
        TimeChangerConfig.write("timechanger");

        source.sendFeedback(Text.translatable("command.timechanger.ctime.success").append(String.valueOf(time)));
        return 1;
    }

}