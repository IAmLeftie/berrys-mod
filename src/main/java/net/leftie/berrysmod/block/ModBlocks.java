package net.leftie.berrysmod.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

    //define blocks
    public static final Block BERRY_BLOCK = new Block(FabricBlockSettings.of(Material.ORGANIC).hardness(1.0F).resistance(5.0F).sounds(BlockSoundGroup.NETHER_WART).breakByHand(true).build());
    public static final Block GOLDEN_BERRY_BLOCK = new Block(FabricBlockSettings.of(Material.ORGANIC).hardness(1.2F).resistance(6.0F).sounds(BlockSoundGroup.NETHER_WART).breakByHand(true).build());

}
