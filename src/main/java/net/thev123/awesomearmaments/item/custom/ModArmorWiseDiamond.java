package net.thev123.awesomearmaments.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.entity.ExperienceOrbEntity;

import java.util.List;
import java.util.Random;

public class ModArmorWiseDiamond extends ArmorItem {

    private static final int REPAIR_TICKS = 200;  // Number of ticks between repairs
    private static final int REPAIR_AMOUNT = 3;   // Amount of durability to repair per tick
    private static final double HEAL_CHANCE = 0.05; // Chance to heal when collecting experience orb
    public ModArmorWiseDiamond(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (!world.isClient && world.getTime() % REPAIR_TICKS == 0) {
            if (stack.getDamage() > 0) {
                stack.setDamage(stack.getDamage() - REPAIR_AMOUNT);
            }
        }

        if (!world.isClient && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;

            List<ExperienceBottleEntity> experienceBottles = world.getEntitiesByClass(ExperienceBottleEntity.class,
                    player.getBoundingBox().expand(5.0), test -> true);

            for (ExperienceBottleEntity experienceBottle : experienceBottles) {
                if (experienceBottle.getOwner() == player) {
                    Random random = (Random) world.getRandom();
                    if (random.nextDouble() < HEAL_CHANCE) {
                        player = (PlayerEntity) entity;
                        if (player.getHealth() < player.getMaxHealth()) {
                            player.heal(0.5f);
                        }
                        break;
                    }
                }
            }
        }
    }
}
