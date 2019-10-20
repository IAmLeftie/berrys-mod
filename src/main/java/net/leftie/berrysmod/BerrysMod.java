package net.leftie.berrysmod;

import io.github.indicode.fabric.tinyconfig.ModConfig;
import net.fabricmc.api.ModInitializer;
import net.leftie.berrysmod.block.ModBlocks;
import net.leftie.berrysmod.item.ModItems;

public class BerrysMod implements ModInitializer {

	//establish mod id
	public static final String MOD_ID = "berrysmod";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//register items
		ModItems.registerItems();
        ModBlocks.registerBlocks();

		System.out.println("Berry's Mod loaded successfully!");
	}

}
