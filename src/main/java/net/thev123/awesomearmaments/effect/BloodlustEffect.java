package net.thev123.awesomearmaments.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

import java.util.UUID;

public class BloodlustEffect extends StatusEffect {
    private static final UUID ATTACK_DAMAGE_MODIFIER_ID = UUID.fromString("f669e5a0-df49-11eb-ba80-0242ac130004");
    private static final double DAMAGE_INCREASE_AMOUNT = 4.0;
    protected BloodlustEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            PlayerEntity player = (PlayerEntity) pLivingEntity;
            EntityAttributeInstance attributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
            EntityAttributeModifier damageModifier = new EntityAttributeModifier(
                    ATTACK_DAMAGE_MODIFIER_ID,
                    "Damage Increase On Low Health",
                    DAMAGE_INCREASE_AMOUNT,
                    EntityAttributeModifier.Operation.ADDITION
            );
            if(player.getHealth() <= 4){
                if (attributeInstance != null && !attributeInstance.hasModifier(damageModifier)) {
                    attributeInstance.addTemporaryModifier(damageModifier);
                }
            }
            else{
                if (attributeInstance != null) {
                    attributeInstance.removeModifier(damageModifier);
                    attributeInstance.removeModifier(ATTACK_DAMAGE_MODIFIER_ID);
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier){
        return true;
    }
}
