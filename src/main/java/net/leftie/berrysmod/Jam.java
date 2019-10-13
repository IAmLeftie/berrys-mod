package net.leftie.berrysmod;

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
        super(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(3.5F).build()).group(ItemGroup.FOOD));
    }
        public ItemStack finishUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1) {
        if (itemStack_1.isEmpty()) return new ItemStack(Items.GLASS_BOTTLE);
        if (livingEntity_1 instanceof PlayerEntity && !((PlayerEntity) livingEntity_1).abilities.creativeMode) {
            livingEntity_1.eatFood(world_1, itemStack_1);
            return itemStack_1;
        }
       else return itemStack_1;
    }
}
