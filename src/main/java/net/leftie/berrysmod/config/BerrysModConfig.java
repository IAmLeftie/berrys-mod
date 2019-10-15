package net.leftie.berrysmod.config;

import io.github.indicode.fabric.tinyconfig.ModConfig;
import net.leftie.berrysmod.BerrysMod;

public class BerrysModConfig {
    //get config
    public static ModConfig berrysModConfig = new ModConfig(BerrysMod.MOD_ID);
    //config settings
    public static boolean oldPieTexture = false;

    public static void init() {
        berrysModConfig.configure(config -> {
            oldPieTexture = config.getBool("oldPieTexture", oldPieTexture, null);
        });
    }
}
