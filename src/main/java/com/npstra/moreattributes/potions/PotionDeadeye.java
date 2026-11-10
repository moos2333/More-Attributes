package com.npstra.moreattributes.potions;

import com.npstra.moreattributes.ModAttributes;
import com.npstra.moreattributes.MoreAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Potion;

import java.util.UUID;

public class PotionDeadeye extends Potion {
    private static final UUID UUID_DEADEYE = UUID.fromString("a1b2c3d4-0005-0005-0005-000000000005");

    public PotionDeadeye() {
        super(false, 0x8B0000);
        setPotionName("effect.moreattributes.deadeye");
        setRegistryName("moreattributes:deadeye");
        setBeneficial();
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.RANGE_DAMAGE);
        if (inst == null) return;
        inst.removeModifier(UUID_DEADEYE);
        inst.applyModifier(new AttributeModifier(UUID_DEADEYE, "Deadeye",
                MoreAttributes.deadeyeBonus * (amplifier + 1), 1));
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.RANGE_DAMAGE);
        if (inst == null) return;
        inst.removeModifier(UUID_DEADEYE);
    }
}