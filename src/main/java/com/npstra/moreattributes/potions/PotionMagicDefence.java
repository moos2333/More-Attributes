package com.npstra.moreattributes.potions;

import com.npstra.moreattributes.ModAttributes;
import com.npstra.moreattributes.MoreAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Potion;

import java.util.UUID;

public class PotionMagicDefence extends Potion {
    private static final UUID UUID_MAGIC_DEFENCE = UUID.fromString("a1b2c3d4-0004-0004-0004-000000000004");

    public PotionMagicDefence() {
        super(false, 0x800080);
        setPotionName("effect.moreattributes.magicdefence");
        setRegistryName("moreattributes:magicdefence");
        setBeneficial();
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.MAGIC_RESISTANCE);
        if (inst == null) return;
        inst.removeModifier(UUID_MAGIC_DEFENCE);
        inst.applyModifier(new AttributeModifier(UUID_MAGIC_DEFENCE, "MagicDefence",
                MoreAttributes.magicDefenceBonus * (amplifier + 1), 1));
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        IAttributeInstance inst = attributeMap.getAttributeInstance(ModAttributes.MAGIC_RESISTANCE);
        if (inst == null) return;
        inst.removeModifier(UUID_MAGIC_DEFENCE);
    }
}