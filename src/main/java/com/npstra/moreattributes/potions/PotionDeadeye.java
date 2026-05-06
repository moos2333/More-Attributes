package com.npstra.moreattributes.potions;

import com.npstra.moreattributes.ModAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import java.util.UUID;

public class PotionDeadeye extends Potion {
    private static final UUID UUID_DEADEYE = UUID.fromString("a1b2c3d4-0005-0005-0005-000000000005");

    public PotionDeadeye() {
        super(false, 0x8B0000);
        setPotionName("effect.moreattributes.deadeye");
        setRegistryName("moreattributes:deadeye");
        registerPotionAttributeModifier(ModAttributes.RANGE_DAMAGE, UUID_DEADEYE.toString(), 0.0, 1);
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            AttributeModifier mod = new AttributeModifier(UUID_DEADEYE, "Deadeye", 0.01 * (amplifier + 1), 1);
            player.getEntityAttribute(ModAttributes.RANGE_DAMAGE).applyModifier(mod);
        }
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            player.getEntityAttribute(ModAttributes.RANGE_DAMAGE).removeModifier(UUID_DEADEYE);
        }
    }
}