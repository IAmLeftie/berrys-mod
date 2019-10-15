package net.leftie.berrysmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class BerrysMod implements ModInitializer {

	//establish mod id
	public static final String MOD_ID = "berrysmod";

	//establish initializer
	public static Identifier getID(String path) {return new Identifier(MOD_ID, path);}
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
	}
}
