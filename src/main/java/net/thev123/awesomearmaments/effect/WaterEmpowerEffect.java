package net.thev123.awesomearmaments.effect;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class WaterEmpowerEffect extends StatusEffect {
    private int healingCooldown = 0;
    private static final int MAX_COOLDOWN = 100; // 100 ticks (5 second) between heals

    protected WaterEmpowerEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            PlayerEntity player = (PlayerEntity) pLivingEntity;
            if(player.isSubmergedInWater() || player.isSwimming()){
                if(healingCooldown <= 0){
                    player.heal(1.0f);
                    healingCooldown = MAX_COOLDOWN;
                }
                else{
                    healingCooldown --;
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier){
        return true;
    }
}
