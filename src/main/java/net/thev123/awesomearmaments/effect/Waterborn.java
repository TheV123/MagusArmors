package net.thev123.awesomearmaments.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

import java.util.UUID;

public class Waterborn extends StatusEffect {
    private int healingCooldown = 0;
    private static final int MAX_COOLDOWN = 20; // 20 ticks (1 seconds) between heals

    private static final UUID HEALTH_MODIFIER_ID = UUID.fromString("f669e5a0-df49-11eb-ba80-0242ac130004");
    private static final double HEALTH_INCREASE_AMOUNT = 4.0; // 2 hearts increase (each heart is 2 health points)

    private static final UUID DAMAGE_REDUCTION_MODIFIER_ID = UUID.fromString("f669e5a1-df49-11eb-ba80-0242ac130004");
    private static final double DAMAGE_REDUCTION_AMOUNT = -3; //3 damage decrease while out of water

    protected Waterborn(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            PlayerEntity player = (PlayerEntity) pLivingEntity;
            EntityAttributeInstance attributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
            EntityAttributeModifier healthModifier = new EntityAttributeModifier(
                    HEALTH_MODIFIER_ID,
                    "Underwater Health Increase",
                    HEALTH_INCREASE_AMOUNT,
                    EntityAttributeModifier.Operation.ADDITION
            );
            EntityAttributeInstance attributeInstance2 = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);

            EntityAttributeModifier damageNerf = new EntityAttributeModifier(
                    DAMAGE_REDUCTION_MODIFIER_ID,
                    "Out of water Damage Nerf",
                    DAMAGE_REDUCTION_AMOUNT,
                    EntityAttributeModifier.Operation.ADDITION
            );
            if(player.isSubmergedInWater() || player.isSwimming() || player.isTouchingWater()){
                if (attributeInstance != null && !attributeInstance.hasModifier(healthModifier)) {
                    attributeInstance.addTemporaryModifier(healthModifier);
                }
                if(attributeInstance2 != null  && attributeInstance2.hasModifier(damageNerf)){
                    attributeInstance2.removeModifier(damageNerf);
                    attributeInstance2.removeModifier(DAMAGE_REDUCTION_MODIFIER_ID);
                }
                if(healingCooldown <= 0){
                    player.heal(1.0f);
                    healingCooldown = MAX_COOLDOWN;
                }
                else{
                    healingCooldown --;
                }
            }
            else{
                if (attributeInstance != null && attributeInstance.hasModifier(healthModifier)) {
                    attributeInstance.removeModifier(healthModifier);
                    attributeInstance.removeModifier(HEALTH_MODIFIER_ID);
                }
                if(attributeInstance2 != null && !attributeInstance2.hasModifier(damageNerf)){
                    attributeInstance2.addTemporaryModifier(damageNerf);
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier){
        return true;
    }
}
