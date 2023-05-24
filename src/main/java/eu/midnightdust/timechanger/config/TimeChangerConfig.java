package eu.midnightdust.timechanger.config;

import eu.midnightdust.lib.config.MidnightConfig;

import java.util.ArrayList;
import java.util.List;

public class TimeChangerConfig extends MidnightConfig {
    @Entry(isSlider = true, min = -1, max = 24000) public static int custom_time = -1;
    @Entry public static Weather custom_weather = Weather.UNSET;
    @Entry public static List<String> allowlist = new ArrayList<>();
    @Entry public static boolean blocklist = false;
    @Entry public static boolean enableInSingleplayer = false;

    public enum Weather {
        UNSET, CLEAR, RAIN, THUNDER;
    }
}
