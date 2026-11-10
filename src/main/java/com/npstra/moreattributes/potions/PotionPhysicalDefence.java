package com.npstra.moreattributes.potions;

import com.npstra.moreattributes.ModAttributes;
import com.npstra.moreattributes.MoreAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Potion;

import java.util.UUID;

public class PotionPhysicalDefence extends Potion {
    private static final UUID UUID_PHYSICAL_DEFENCE = UUID.fromString("a1b2c3d4-0003-0003-0003-000000000003");

    public PotionPhysicalDefence() {
        super(false, 0x888888);
        setPotionName("effect.moreattributes.physicaldefence");
        setRegistryName("moreattributes:physicaldefence");
        setBeneficial();
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.PHYSICAL_RESISTANCE);
        if (inst == null) return;
        inst.removeModifier(UUID_PHYSICAL_DEFENCE);
        inst.applyModifier(new AttributeModifier(UUID_PHYSICAL_DEFENCE, "PhysicalDefence",
                MoreAttributes.physicalDefenceBonus * (amplifier + 1), 1));
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.PHYSICAL_RESISTANCE);
        if (inst == null) return;
        inst.removeModifier(UUID_PHYSICAL_DEFENCE);
    }
}