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
    private static final int COOLDOWN = 600;
    protected InfiniteSightEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.getWorld().isClient()){
            PlayerEntity player = (PlayerEntity) pLivingEntity;
            //600 ticks between each effect
            World world = player.getWorld();
            if (player.hasStatusEffect(this)) {
                if (!world.isClient && world.getTime() % COOLDOWN == 0) {
                    int effect = player.getWorld().random.nextInt(6);
                    //effect lasts for 600 ticks
                    int duration = 600;
                    switch (effect) {
                        case 0:
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, duration, 1));
                            break;
                        case 1:
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, duration, 1));
                            break;
                        case 2:
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, duration, 0));
                            break;
                        case 3:
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, duration, 1));
                            break;
                        case 4:
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, duration, 1));
                            break;
                        case 5:
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, duration, 1));
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
