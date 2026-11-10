package com.npstra.moreattributes.potions;

import com.npstra.moreattributes.ModAttributes;
import com.npstra.moreattributes.MoreAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Potion;

import java.util.UUID;

public class PotionArcane extends Potion {
    private static final UUID UUID_ARCANE = UUID.fromString("a1b2c3d4-0006-0006-0006-000000000006");

    public PotionArcane() {
        super(false, 0x4B0082);
        setPotionName("effect.moreattributes.arcane");
        setRegistryName("moreattributes:arcane");
        setBeneficial();
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.MAGIC_DAMAGE);
        if (inst == null) return;
        inst.removeModifier(UUID_ARCANE);
        inst.applyModifier(new AttributeModifier(UUID_ARCANE, "Arcane",
                MoreAttributes.arcaneBonus * (amplifier + 1), 1));
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.MAGIC_DAMAGE);
        if (inst == null) return;
        inst.removeModifier(UUID_ARCANE);
    }
}