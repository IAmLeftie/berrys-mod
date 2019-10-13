package net.leftie.berrysmod.item;

import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class Jam extends Item {
    public Jam() {
        super(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1.3F).build()).maxCount(1).group(ItemGroup.FOOD));
    }
    @Override
    public ItemStack finishUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1) {
        super.finishUsing(itemStack_1, world_1, livingEntity_1);
        return new ItemStack(Items.GLASS_BOTTLE);
    }
}
