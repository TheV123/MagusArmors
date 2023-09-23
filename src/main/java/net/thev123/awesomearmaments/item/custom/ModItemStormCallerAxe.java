package net.thev123.awesomearmaments.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class ModItemStormCallerAxe extends AxeItem {
    private final float EFFECT_CHANCE =  0.25f;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public ModItemStormCallerAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        float damage = 9.0f;
        float speed = 1.2f;

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier("Attack modifier", damage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier("Attack speed modifier", speed, EntityAttributeModifier.Operation.ADDITION));

        this.attributeModifiers = builder.build();
    }
    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
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
