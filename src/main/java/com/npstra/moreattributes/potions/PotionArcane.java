package com.npstra.moreattributes.potions;

import com.npstra.moreattributes.ModAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import java.util.UUID;

public class PotionArcane extends Potion {
    private static final UUID UUID_ARCANE = UUID.fromString("a1b2c3d4-0006-0006-0006-000000000006");

    public PotionArcane() {
        super(false, 0x4B0082);
        setPotionName("effect.moreattributes.arcane");
        setRegistryName("moreattributes:arcane");
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            AttributeModifier mod = new AttributeModifier(UUID_ARCANE, "Arcane", 0.01 * (amplifier + 1), 1);
            player.getEntityAttribute(ModAttributes.MAGIC_DAMAGE).applyModifier(mod);
        }
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            player.getEntityAttribute(ModAttributes.MAGIC_DAMAGE).removeModifier(UUID_ARCANE);
        }
    }
}