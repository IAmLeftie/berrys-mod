package net.leftie.berrysmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BerrysMod implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//Register blocks
		Registry.register(Registry.BLOCK, new Identifier("berrysmod", "berry_block"), BERRY_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("berrysmod", "golden_berry_block"), GOLDEN_BERRY_BLOCK);
		//Register blockitems
		Registry.register(Registry.ITEM, new Identifier("berrysmod", "berry_block"), new BlockItem(BERRY_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("berrysmod", "golden_berry_block"), new BlockItem(GOLDEN_BERRY_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		//Register items
		Registry.register(Registry.ITEM, new Identifier("berrysmod", "berry_pie"), BERRY_PIE);
		Registry.register(Registry.ITEM, new Identifier("berrysmod", "golden_berries"), GOLDEN_BERRIES);
		Registry.register(Registry.ITEM, new Identifier("berrysmod", "golden_pie"), GOLDEN_PIE);
		//Registry.register(Registry.POTION, new Identifier("berrysmod", "jam"), JAM);
		//Registry.register(Registry.POTION, new Identifier("berrysmod", "golden_jam"), GOLDEN_JAM);
		Registry.register(Registry.ITEM, new Identifier("berrysmod", "jam"), JAM);
		Registry.register(Registry.ITEM, new Identifier("berrysmod", "golden_jam"), GOLDEN_JAM);
	}
	public static final Block BERRY_BLOCK = new Block(FabricBlockSettings.of(Material.ORGANIC).hardness(1.0F).resistance(5.0F).sounds(BlockSoundGroup.NETHER_WART).breakByHand(true).build());
	public static final Item BERRY_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(7).saturationModifier(4.0F).build()));
	public static final Item GOLDEN_BERRIES = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,60), 1.0f).build()));
	public static final Item GOLDEN_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(4.5F).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 160), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 900), 1.0F).build()));
	public static final Block GOLDEN_BERRY_BLOCK = new Block(FabricBlockSettings.of(Material.ORGANIC).hardness(1.2F).resistance(6.0F).sounds(BlockSoundGroup.NETHER_WART).breakByHand(true).build());
	//TODO try to get a bottle back to the player on eating
	//public static final Potion JAM = new Potion(new StatusEffectInstance(StatusEffects.SATURATION, 1, 1));
	//public static final Potion GOLDEN_JAM = new Potion(new StatusEffectInstance(StatusEffects.SATURATION, 1, 1), new StatusEffectInstance(StatusEffects.REGENERATION, 80));
	public static final Item JAM = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(3.5F).build()).maxCount(16).group(ItemGroup.FOOD));
	public static final Item GOLDEN_JAM = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(4.0F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100), 1.0F).alwaysEdible().build()).maxCount(16).group(ItemGroup.FOOD));
}