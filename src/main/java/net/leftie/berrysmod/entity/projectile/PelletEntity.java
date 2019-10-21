package net.leftie.berrysmod.entity.projectile;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.leftie.berrysmod.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class PelletEntity extends ThrownItemEntity {
   public PelletEntity(EntityType<? extends PelletEntity> entityType_1, World world_1) {
      super(entityType_1, world_1);
   }

   public PelletEntity(World world_1, LivingEntity livingEntity_1) {
      super(EntityType.SNOWBALL, livingEntity_1, world_1);
   }

   public PelletEntity(World world_1, double double_1, double double_2, double double_3) {
      super(EntityType.SNOWBALL, double_1, double_2, double_3, world_1);
   }

   protected Item getDefaultItem() {
      return ModItems.PELLET;
   }

   protected void onCollision(HitResult hitResult_1) {
      if (hitResult_1.getType() == HitResult.Type.ENTITY) {
         Entity entity_1 = ((EntityHitResult)hitResult_1).getEntity();
         int int_1 = entity_1 instanceof BlazeEntity ? 3 : 0;
         entity_1.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float)int_1);
      }
   }

   public void initFromStack(ItemStack itemStack_1) {
   }
}
