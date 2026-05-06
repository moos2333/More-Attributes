package com.npstra.moreattributes.potions;

import com.npstra.moreattributes.ModAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import java.util.UUID;

public class PotionSnipe extends Potion {
    private static final UUID UUID_SNIPE = UUID.fromString("a1b2c3d4-0002-0002-0002-000000000002");

    public PotionSnipe() {
        super(false, 0x00AA00);
        setPotionName("effect.moreattributes.snipe");
        setRegistryName("moreattributes:snipe");
        registerPotionAttributeModifier(ModAttributes.LONG_RANGE_DAMAGE, UUID_SNIPE.toString(), 0.0, 1);
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            AttributeModifier mod = new AttributeModifier(UUID_SNIPE, "Snipe", 0.01 * (amplifier + 1), 1);
            player.getEntityAttribute(ModAttributes.LONG_RANGE_DAMAGE).applyModifier(mod);
        }
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            player.getEntityAttribute(ModAttributes.LONG_RANGE_DAMAGE).removeModifier(UUID_SNIPE);
        }
    }
}