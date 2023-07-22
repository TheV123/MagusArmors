package net.thev123.awesomearmaments.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thev123.awesomearmaments.AwesomeArmaments;

public class ModEffects {
    public static StatusEffect EXPERIENCE_EMPOWER;
    public static StatusEffect WATER_EMPOWER;


    public static StatusEffect registerExperienceEmpower(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(AwesomeArmaments.MOD_ID, name),
                new ExperienceEmpowerEffect(StatusEffectCategory.BENEFICIAL, 0xb2d95f));
    }
    public static StatusEffect registerWaterEmpower(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(AwesomeArmaments.MOD_ID, name),
                new WaterEmpowerEffect(StatusEffectCategory.BENEFICIAL, 0x5fb2d9));
    }
    public static void registerEffects() {
        EXPERIENCE_EMPOWER = registerExperienceEmpower("experience_empower");
        WATER_EMPOWER = registerWaterEmpower("water_empower");
    }
}
