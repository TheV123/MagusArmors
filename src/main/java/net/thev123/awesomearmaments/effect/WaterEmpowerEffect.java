package net.thev123.awesomearmaments.effect;

import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;
import java.util.List;

public class WaterEmpowerEffect extends StatusEffect {
    protected WaterEmpowerEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            PlayerEntity player = (PlayerEntity) pLivingEntity;
            if(player.isSubmergedInWater() || player.isSwimming()){
                ItemStack boots = player.getInventory().getArmorStack(0);
                ItemStack leggings = player.getInventory().getArmorStack(1);
                ItemStack chestplate = player.getInventory().getArmorStack(2);
                ItemStack helmet = player.getInventory().getArmorStack(3);
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier){
        return true;
    }
}
