package net.leftie.berrysmod.item;

import net.leftie.berrysmod.entity.projectile.PelletEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Slingshot extends RangedWeaponItem {
    public Slingshot(Settings item$Settings_1) {
        super(item$Settings_1);
    }
    public void onStoppedUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1, int int_1) {
        if (livingEntity_1 instanceof PlayerEntity) {
            PlayerEntity playerEntity_1 = (PlayerEntity)livingEntity_1;
            boolean boolean_1 = playerEntity_1.abilities.creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, itemStack_1) > 0;
            ItemStack itemStack_2 = playerEntity_1.getArrowType(itemStack_1);
            if (!itemStack_2.isEmpty() || boolean_1) {
                if (itemStack_2.isEmpty()) {
                    itemStack_2 = new ItemStack(ModItems.PELLET);
                }
                boolean boolean_2 = boolean_1 && itemStack_2.getItem() == ModItems.PELLET;
                if (!world_1.isClient) {
                    SlingshotAmmo slingshotAmmo_1 = (SlingshotAmmo) (itemStack_2.getItem() instanceof SlingshotAmmo ? itemStack_2.getItem() : ModItems.PELLET);
                    PelletEntity pelletEntity_1 = slingshotAmmo_1.createPellet(world_1, itemStack_2, playerEntity_1);
                    pelletEntity_1.setProperties(playerEntity_1, playerEntity_1.pitch, playerEntity_1.yaw, 0.0F, 3.0F, 1.0F);

                    itemStack_1.damage(1, (LivingEntity)playerEntity_1, (Consumer<LivingEntity>)((playerEntity_2) -> {
                        playerEntity_2.sendToolBreakStatus(playerEntity_1.getActiveHand());
                    }));

                    world_1.spawnEntity(pelletEntity_1);
                }
                world_1.playSound((PlayerEntity)null, playerEntity_1.x, playerEntity_1.y, playerEntity_1.z, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (RANDOM.nextFloat() * 0.4F + 1.2F));
                if (!boolean_2 && !playerEntity_1.abilities.creativeMode) {
                    itemStack_2.decrement(1);
                    if (itemStack_2.isEmpty()) {
                        playerEntity_1.inventory.removeOne(itemStack_2);
                    }
                }
            }
        }
    }

    @Override
    public TypedActionResult use(World world_1, PlayerEntity playerEntity_1, Hand hand_1) {
        ItemStack itemStack_1 = playerEntity_1.getStackInHand(hand_1);
        boolean boolean_1 = !playerEntity_1.getArrowType(itemStack_1).isEmpty();
        if (!playerEntity_1.abilities.creativeMode && !boolean_1) {
            return boolean_1 ? new TypedActionResult<>(ActionResult.PASS, itemStack_1) : new TypedActionResult<>(ActionResult.FAIL, itemStack_1);
        } else {
            playerEntity_1.setCurrentHand(hand_1);
            return new TypedActionResult<>(ActionResult.SUCCESS, itemStack_1);
        }
    }

    public Predicate<ItemStack> getProjectiles() {
        return BOW_PROJECTILES;
    }
}