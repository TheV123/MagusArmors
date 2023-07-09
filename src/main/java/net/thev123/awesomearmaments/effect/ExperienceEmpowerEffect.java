package net.thev123.awesomearmaments.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

public class ExperienceEmpowerEffect extends StatusEffect {
    private static final float HEAL_CHANCE = 0.1f;  // 10% chance to heal
    private static final int HEAL_AMOUNT = 1;
    protected ExperienceEmpowerEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            /*Vec3d vec3d = pLivingEntity.getVelocity();*/
            if (isNearExperienceOrb(pLivingEntity)){
             pLivingEntity.heal(HEAL_AMOUNT);
            }
        }

        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }
    public boolean isNearExperienceOrb(LivingEntity entity){
//        if (entity.getAttacker() == EntityType.EXPERIENCE_ORB) {
//            return true;
//        }
        return false;
    }
}
