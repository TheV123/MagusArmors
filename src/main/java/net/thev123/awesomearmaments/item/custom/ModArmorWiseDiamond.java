package net.thev123.awesomearmaments.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModArmorWiseDiamond extends ArmorItem {

    private static final int REPAIR_TICKS = 200;  // Number of ticks between repairs
    private static final int REPAIR_AMOUNT = 3;   // Amount of durability to repair per tick
    public ModArmorWiseDiamond(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (!world.isClient && world.getTime() % REPAIR_TICKS == 0) {
            if (stack.getDamage() > 0) {
                stack.setDamage(stack.getDamage() - REPAIR_AMOUNT);
            }
        }
    }
}
