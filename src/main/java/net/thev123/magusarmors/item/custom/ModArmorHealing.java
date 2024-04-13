package net.thev123.magusarmors.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.spell_power.api.SpellPowerMechanics;
import net.spell_power.api.SpellSchools;
import net.thev123.magusarmors.item.ModArmorMaterials;

import java.util.UUID;

public class ModArmorHealing extends ArmorItem {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public ModArmorHealing(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);

        float holySpellPower = 0.2F;
        float hastePower = 0.05F;
        float critDamagePower = 0.03F;
        float critChancePower = 0.02F;

        int protection = ModArmorMaterials.HEALING_MATERIAL.getProtection(type);
        float toughness = ModArmorMaterials.HEALING_MATERIAL.getToughness();

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(SpellSchools.HEALING.attribute,
                new EntityAttributeModifier(
                        UUID.randomUUID(),
                        "Spell Power",
                        holySpellPower,
                        EntityAttributeModifier.Operation.MULTIPLY_BASE
                )
        );
        builder.put(SpellPowerMechanics.HASTE.attribute,
                new EntityAttributeModifier(
                        UUID.randomUUID(),
                        "Spell Haste",
                        hastePower,
                        EntityAttributeModifier.Operation.MULTIPLY_BASE
                )
        );
        builder.put(SpellPowerMechanics.CRITICAL_CHANCE.attribute,
                new EntityAttributeModifier(
                        UUID.randomUUID(),
                        "Spell Crit Chance",
                        critChancePower,
                        EntityAttributeModifier.Operation.MULTIPLY_BASE
                )
        );
        builder.put(SpellPowerMechanics.CRITICAL_DAMAGE.attribute,
                new EntityAttributeModifier(
                        UUID.randomUUID(),
                        "Spell Crit Damage",
                        critDamagePower,
                        EntityAttributeModifier.Operation.MULTIPLY_BASE
                )
        );

        //base attributes
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Armor  modifier", protection, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier("Armor  toughness", toughness, EntityAttributeModifier.Operation.ADDITION));

        this.attributeModifiers = builder.build();
    }
    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == this.type.getEquipmentSlot()) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }

}
