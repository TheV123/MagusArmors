package net.thev123.awesomearmaments.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thev123.awesomearmaments.AwesomeArmaments;

public class ModEffects {
    public static StatusEffect EXPERIENCE_EMPOWER;
    public static StatusEffect EXPERIENCE_EMPOWER2;
    public static StatusEffect INFINITE_SIGHT;
    public static StatusEffect WATERBORN;

    public static StatusEffect BLOODLUST;


    public static StatusEffect registerExperienceEmpower(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(AwesomeArmaments.MOD_ID, name),
                new ExperienceEmpowerEffect(StatusEffectCategory.BENEFICIAL, 0xb2d95f));
    }
    public static StatusEffect registerExperienceEmpower2(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(AwesomeArmaments.MOD_ID, name),
                new ExperienceEmpowerEffect2(StatusEffectCategory.BENEFICIAL, 0xb2d95f));
    }

    public static StatusEffect registerInfiniteSight(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(AwesomeArmaments.MOD_ID, name),
                new InfiniteSightEffect(StatusEffectCategory.NEUTRAL, 0xb2d95f));
    }
    public static StatusEffect registerWaterborn(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(AwesomeArmaments.MOD_ID, name),
                new Waterborn(StatusEffectCategory.BENEFICIAL, 0x00ffff));
    }
    public static StatusEffect registerBloodlust(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(AwesomeArmaments.MOD_ID, name),
                new BloodlustEffect(StatusEffectCategory.BENEFICIAL, 0xff0000));
    }
    public static void registerEffects() {
        EXPERIENCE_EMPOWER = registerExperienceEmpower("experience_empower");
        EXPERIENCE_EMPOWER2 = registerExperienceEmpower2("experience_empower2");
        INFINITE_SIGHT = registerInfiniteSight("infinite_sight");
        WATERBORN = registerWaterborn("waterborn");
        BLOODLUST = registerBloodlust("bloodlust");
    }
}
