package eu.midnightdust.timechanger.config;

import eu.midnightdust.lib.config.MidnightConfig;

import java.util.ArrayList;
import java.util.List;

public class TimeChangerConfig extends MidnightConfig {
    @Entry public static int custom_time = -1;
    @Entry public static List<String> allowlist = new ArrayList<>();
    @Entry public static boolean blocklist = false;
}
