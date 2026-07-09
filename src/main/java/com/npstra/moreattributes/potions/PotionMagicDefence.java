package com.npstra.moreattributes.potions;

import com.npstra.moreattributes.ModAttributes;
import com.npstra.moreattributes.MoreAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import java.util.UUID;

public class PotionMagicDefence extends Potion {
    private static final UUID UUID_MAGIC_DEFENCE = UUID.fromString("a1b2c3d4-0004-0004-0004-000000000004");

    public PotionMagicDefence() {
        super(false, 0x800080);
        setPotionName("effect.moreattributes.magicdefence");
        setRegistryName("moreattributes:magicdefence");
        registerPotionAttributeModifier(ModAttributes.MAGIC_RESISTANCE, UUID_MAGIC_DEFENCE.toString(), 0.0, 1);
        setBeneficial();
    }

    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            AttributeModifier mod = new AttributeModifier(UUID_MAGIC_DEFENCE, "MagicDefence", MoreAttributes.magicDefenceBonus * (amplifier + 1), 1);
            player.getEntityAttribute(ModAttributes.MAGIC_RESISTANCE).applyModifier(mod);
        }
    }

    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMap, int amplifier) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            player.getEntityAttribute(ModAttributes.MAGIC_RESISTANCE).removeModifier(UUID_MAGIC_DEFENCE);
        }
    }
}