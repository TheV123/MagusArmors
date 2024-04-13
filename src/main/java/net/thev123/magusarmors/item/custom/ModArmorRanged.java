package net.thev123.magusarmors.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.fabric_extras.ranged_weapon.api.EntityAttributes_RangedWeapon;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.spell_power.api.SpellSchools;
import net.thev123.magusarmors.item.ModArmorMaterials;

import java.util.UUID;

public class ModArmorRanged extends ArmorItem {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public ModArmorRanged(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);

        float rangedWeaponDamage = 0.08F;
        float rangedWeaponHaste = 0.05F;

        int protection = ModArmorMaterials.RANGED_MATERIAL.getProtection(type);
        float toughness = ModArmorMaterials.RANGED_MATERIAL.getToughness();

        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes_RangedWeapon.DAMAGE.attribute,
                new EntityAttributeModifier(
                        UUID.randomUUID(),
                        "Ranged Damage",
                        rangedWeaponDamage,
                        EntityAttributeModifier.Operation.MULTIPLY_BASE
                )
        );
        builder.put(EntityAttributes_RangedWeapon.HASTE.attribute,
                new EntityAttributeModifier(
                        UUID.randomUUID(),
                        "Ranged Haste",
                        rangedWeaponHaste,
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
