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
    private static boolean alreadyOn = false;
    protected WaterEmpowerEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            PlayerEntity player = (PlayerEntity) pLivingEntity;
            ItemStack boots = player.getInventory().getArmorStack(0);
            ItemStack leggings = player.getInventory().getArmorStack(1);
            ItemStack chestplate = player.getInventory().getArmorStack(2);
            ItemStack helmet = player.getInventory().getArmorStack(3);
            if(player.isSubmergedInWater() || player.isSwimming() || player.isInsideWaterOrBubbleColumn() || player.isWet()){

            }
            else{

            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier){
        return true;
    }
}
