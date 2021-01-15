package eu.midnightdust.timechanger.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

import java.util.ArrayList;
import java.util.List;

@Config(name = "timechanger")
public class TimeChangerConfig implements ConfigData {

    @Comment(value = "Set the Custom Time (-1 to disable)")
    public int custom_time = -1;
    @Comment(value = "Whitelist/Blacklist servers")
    public List<String> whitelist = new ArrayList<>();
    public boolean blacklist = false;
}
