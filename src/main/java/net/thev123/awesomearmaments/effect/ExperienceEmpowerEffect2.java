package net.thev123.awesomearmaments.effect;

import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExperienceEmpowerEffect2 extends StatusEffect {
    private static boolean flag = true;
    private final float HEAL_CHANCE =  0.10f; // 10% chance to heal
    private final float HEAL_AMOUNT = 2;  //heals 1 heart
    protected ExperienceEmpowerEffect2(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            PlayerEntity player = (PlayerEntity) pLivingEntity;
            Box box = player.hasVehicle() && !Objects.requireNonNull(player.getVehicle()).isRemoved() ? player.getBoundingBox().union(player.getVehicle().getBoundingBox()).expand(1.0, 0.0, 1.0) : player.getBoundingBox().expand(1.0, 0.5, 1.0);
            List<Entity> list = player.getWorld().getOtherEntities(player, box);
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = list.get(i);
                if (entity.getType() == EntityType.EXPERIENCE_ORB) {
                    Random random = player.getWorld().random;
                    entity.onPlayerCollision(player);
                    if(flag){
                        if(random.nextDouble() < HEAL_CHANCE){
                            player.heal(HEAL_AMOUNT);
                            flag = false;
                        }
                    }
                    if(!flag){
                        if(random.nextDouble() < HEAL_CHANCE/3){
                            player.heal(HEAL_AMOUNT);
                        }
                        flag = true;
                    }
                }
            }
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier){
        return true;
    }
}
