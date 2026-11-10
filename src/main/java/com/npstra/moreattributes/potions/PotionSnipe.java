package com.npstra.moreattributes.potions;

import com.npstra.moreattributes.ModAttributes;
import com.npstra.moreattributes.MoreAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Potion;

import java.util.UUID;

public class PotionSnipe extends Potion {
    private static final UUID UUID_SNIPE = UUID.fromString("a1b2c3d4-0002-0002-0002-000000000002");

    public PotionSnipe() {
        super(false, 0x00AA00);
        setPotionName("effect.moreattributes.snipe");
        setRegistryName("moreattributes:snipe");
        setBeneficial();
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.LONG_RANGE_DAMAGE);
        if (inst == null) return;
        inst.removeModifier(UUID_SNIPE);
        inst.applyModifier(new AttributeModifier(UUID_SNIPE, "Snipe",
                MoreAttributes.snipeBonus * (amplifier + 1), 1));
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.LONG_RANGE_DAMAGE);
        if (inst == null) return;
        inst.removeModifier(UUID_SNIPE);
    }
}