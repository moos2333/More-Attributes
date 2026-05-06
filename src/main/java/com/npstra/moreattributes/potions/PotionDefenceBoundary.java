package com.npstra.moreattributes.potions;

import com.npstra.moreattributes.ModAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import java.util.UUID;

public class PotionDefenceBoundary extends Potion {
    private static final UUID UUID_DEFENCE = UUID.fromString("a1b2c3d4-0003-0003-0003-000000000003");

    public PotionDefenceBoundary() {
        super(false, 0x888888);
        setPotionName("effect.moreattributes.physicaldefence");
        setRegistryName("moreattributes:physicaldefence");
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            AttributeModifier mod = new AttributeModifier(UUID_DEFENCE, "DefenceBoundary", 0.01 * (amplifier + 1), 1);
            player.getEntityAttribute(ModAttributes.PHYSICAL_RESISTANCE).applyModifier(mod);
        }
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            player.getEntityAttribute(ModAttributes.PHYSICAL_RESISTANCE).removeModifier(UUID_DEFENCE);
        }
    }
}