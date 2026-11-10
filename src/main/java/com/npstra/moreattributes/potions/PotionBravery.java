package com.npstra.moreattributes.potions;

import com.npstra.moreattributes.ModAttributes;
import com.npstra.moreattributes.MoreAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Potion;

import java.util.UUID;

public class PotionBravery extends Potion {
    private static final UUID UUID_BRAVERY = UUID.fromString("a1b2c3d4-0001-0001-0001-000000000001");

    public PotionBravery() {
        super(false, 0xFF6600);
        setPotionName("effect.moreattributes.bravery");
        setRegistryName("moreattributes:bravery");
        setBeneficial();
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.CLOSE_RANGE_DAMAGE);
        if (inst == null) return;
        inst.removeModifier(UUID_BRAVERY);
        inst.applyModifier(new AttributeModifier(UUID_BRAVERY, "Bravery",
                MoreAttributes.braveryBonus * (amplifier + 1), 1));
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.CLOSE_RANGE_DAMAGE);
        if (inst == null) return;
        inst.removeModifier(UUID_BRAVERY);
    }
}