package net.thev123.awesomearmaments.item.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thev123.awesomearmaments.effect.ModEffects;
import net.thev123.awesomearmaments.item.ModArmorMaterials;

import java.util.Map;

public class ModArmorBloodlust extends ArmorItem{
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public static final int effectDuration = 200;
    public ModArmorBloodlust(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);

        //attributes
        int protection = ModArmorMaterials.BLOODLUST.getProtection(type);
        float toughness = ModArmorMaterials.BLOODLUST.getToughness();
        float knockbackResistance = ModArmorMaterials.BLOODLUST.getKnockbackResistance();

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Armor  modifier", protection, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier("Armor  toughness", toughness, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier("Armor knockback resistance", knockbackResistance, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier("Attack  modifier", 1, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier("Health  modifier", -1, EntityAttributeModifier.Operation.ADDITION));

        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == this.type.getEquipmentSlot()) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }

    //effects
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(ModArmorMaterials.BLOODLUST, new StatusEffectInstance(StatusEffects.SPEED, effectDuration, 1))
                    .build();
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP2 =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.WISE_DIAMOND,
                            new StatusEffectInstance(StatusEffects.LUCK, effectDuration, 0)).build();
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity)entity;

                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = ModArmorMaterials.BLOODLUST;
            StatusEffectInstance mapStatusEffect = new StatusEffectInstance(StatusEffects.SPEED,
                    effectDuration, 1, false, false, false);

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
        for(Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP2.entrySet()) {
            ArmorMaterial mapArmorMaterial = ModArmorMaterials.BLOODLUST;
            StatusEffectInstance mapStatusEffect = new StatusEffectInstance(ModEffects.BLOODLUST,
                    effectDuration, 0, false, false, false);

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(ModEffects.BLOODLUST,
                    effectDuration, 0, false, false, false));
        }
        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,
                    effectDuration, 1, false, false, false));
        }

        // effect repeat issue fix
        if (player.getActiveStatusEffects().containsKey(ModEffects.BLOODLUST)) {
            if (player.getActiveStatusEffects().get(mapStatusEffect.getEffectType()).getDuration() < 100) {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.BLOODLUST,
                        effectDuration, 0, false, false, false));
            }
        }
        if (player.getActiveStatusEffects().containsKey(StatusEffects.SPEED)) {
            if (player.getActiveStatusEffects().get(mapStatusEffect.getEffectType()).getDuration() < 100) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,
                        effectDuration, 1, false, false, false));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean doesArmorHaveMaterial(ArmorMaterial material, PlayerEntity player) {
        for (int i=0; i<4; i++) {
            try{
                ((ArmorItem)player.getInventory().getArmorStack(i).getItem()).getMaterial();
            }catch(Exception e){
                return false;
            }
        }

        return true;
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        if (!doesArmorHaveMaterial(material, player)) {
            return false;
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
