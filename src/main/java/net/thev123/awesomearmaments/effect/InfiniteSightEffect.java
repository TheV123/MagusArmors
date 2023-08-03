package net.thev123.awesomearmaments.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class InfiniteSightEffect extends StatusEffect {
    private static final int COOLDOWN = 400;  // Number of ticks between the effect add
    protected InfiniteSightEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.getWorld().isClient()){
            PlayerEntity player = (PlayerEntity) pLivingEntity;
            World world = player.getWorld();
            if (player.hasStatusEffect(this)) {
                if (!world.isClient && world.getTime() % COOLDOWN == 0) {
                    Random random = player.getWorld().random;
                    int effect = random.nextInt(3);
                    switch (effect) {
                        case 0:
                            // Apply Strength
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, pAmplifier));
                            break;
                        case 1:
                            // Apply Regeneration
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, pAmplifier));
                            break;
                        case 2:
                            // Apply Blindness
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, pAmplifier));
                            break;
                    }
                }
            }
        }
    }
    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier){
        return true;
    }
}
