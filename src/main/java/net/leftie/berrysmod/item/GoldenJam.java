package net.leftie.berrysmod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class GoldenJam extends Item {
    public GoldenJam() {
        super(new Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(1.5F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100), 1.0F).alwaysEdible().build()).maxCount(1).group(ItemGroup.FOOD));
    }
    @Override
    public ItemStack finishUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1) {
        super.finishUsing(itemStack_1, world_1, livingEntity_1);
        return new ItemStack(Items.GLASS_BOTTLE);
    }
}
