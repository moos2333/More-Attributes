package com.npstra.moreattributes;

import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.player.EntityPlayer;

public class ModAttributes {
    public static final IAttribute RANGE_DAMAGE = new RangedAttribute(
            null, "moreattributes.rangeDamage", 1.0, 0.0, 1024.0
    ).setShouldWatch(true);

    public static final IAttribute MAGIC_DAMAGE = new RangedAttribute(
            null, "moreattributes.magicDamage", 1.0, 0.0, 1024.0
    ).setShouldWatch(true);

    public static final IAttribute CLOSE_RANGE_DAMAGE = new RangedAttribute(
            null, "moreattributes.shortRangeDamage", 1.0, 0.0, 1024.0
    ).setShouldWatch(true);

    public static final IAttribute LONG_RANGE_DAMAGE = new RangedAttribute(
            null, "moreattributes.longRangeDamage", 1.0, 0.0, 1024.0
    ).setShouldWatch(true);

    public static final IAttribute PHYSICAL_RESISTANCE = new RangedAttribute(
            null, "moreattributes.physicalResistance", 1.0, -1024.0, 1024.0
    ).setShouldWatch(true);

    public static final IAttribute MAGIC_RESISTANCE = new RangedAttribute(
            null, "moreattributes.magicResistance", 1.0, -1024.0, 1024.0
    ).setShouldWatch(true);

    public static void ensureAttribute(EntityPlayer player, IAttribute attribute) {
        if (player.getAttributeMap().getAttributeInstance(attribute) == null) {
            player.getAttributeMap().registerAttribute(attribute);
        }
    }
}