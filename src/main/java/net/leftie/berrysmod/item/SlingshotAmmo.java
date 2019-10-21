package net.leftie.berrysmod.item;

import net.leftie.berrysmod.entity.projectile.PelletEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SlingshotAmmo extends ArrowItem {
    public SlingshotAmmo(Settings item$Settings_1) {
        super(item$Settings_1);
    }

    public PelletEntity createPellet(World world_1, ItemStack itemStack_1, LivingEntity livingEntity_1) {
        PelletEntity pelletEntity_1 = new PelletEntity(world_1, livingEntity_1) {

        };
        pelletEntity_1.initFromStack(itemStack_1);
        return pelletEntity_1;
    }
}
