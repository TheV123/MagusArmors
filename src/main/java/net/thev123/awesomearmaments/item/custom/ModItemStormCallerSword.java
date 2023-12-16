package net.thev123.awesomearmaments.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class ModItemStormCallerSword extends SwordItem {
    private final float EFFECT_CHANCE =  0.15f;
    public ModItemStormCallerSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return super.getAttributeModifiers(slot);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random random = attacker.getWorld().random;
        if (random.nextDouble() < EFFECT_CHANCE){
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 70, 2), attacker);
        }
        if (random.nextDouble() < EFFECT_CHANCE){
            World world = target.getWorld();
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightning.refreshPositionAfterTeleport(target.getPos());
            world.spawnEntity(lightning);
        }
        return super.postHit(stack, target, attacker);
    }
}
