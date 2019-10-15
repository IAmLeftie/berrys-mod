package net.leftie.berrysmod.item;

import net.leftie.berrysmod.BerrysMod;
import net.leftie.berrysmod.block.ModBlocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //define items
    public static final Item GOLDEN_BERRIES = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60), 1.0F).build()));
    public static final Item BERRY_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.3F).build()));
    public static final Item GOLDEN_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.4F).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 160), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 900), 1.0F).build()));
    public static final Item JAM = new Jam();
    public static final Item GOLDEN_JAM = new GoldenJam();

    //register items
    public static void registerItems() {

        //normal items
        Registry.register(Registry.ITEM, new Identifier(BerrysMod.MOD_ID, "golden_berries"), GOLDEN_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(BerrysMod.MOD_ID, "berry_pie"), BERRY_PIE);
        Registry.register(Registry.ITEM, new Identifier(BerrysMod.MOD_ID, "golden_pie"), GOLDEN_PIE);
        Registry.register(Registry.ITEM, new Identifier(BerrysMod.MOD_ID, "jam"), JAM);
        Registry.register(Registry.ITEM, new Identifier(BerrysMod.MOD_ID, "golden_jam"), GOLDEN_JAM);

        //register and categorize block items
        Registry.register(Registry.ITEM, new Identifier(BerrysMod.MOD_ID, "berry_block"), new BlockItem(ModBlocks.BERRY_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(BerrysMod.MOD_ID, "golden_berry_block"), new BlockItem(ModBlocks.GOLDEN_BERRY_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

    }
}
