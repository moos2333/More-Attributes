package com.npstra.moreattributes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AttributeInjector {
    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof EntityPlayer)) return;
        EntityPlayer player = (EntityPlayer) event.getEntity();
        if (player.getAttributeMap().getAttributeInstance(ModAttributes.RANGE_DAMAGE) == null)
            player.getAttributeMap().registerAttribute(ModAttributes.RANGE_DAMAGE);
        if (player.getAttributeMap().getAttributeInstance(ModAttributes.MAGIC_DAMAGE) == null)
            player.getAttributeMap().registerAttribute(ModAttributes.MAGIC_DAMAGE);
        if (player.getAttributeMap().getAttributeInstance(ModAttributes.CLOSE_RANGE_DAMAGE) == null)
            player.getAttributeMap().registerAttribute(ModAttributes.CLOSE_RANGE_DAMAGE);
        if (player.getAttributeMap().getAttributeInstance(ModAttributes.LONG_RANGE_DAMAGE) == null)
            player.getAttributeMap().registerAttribute(ModAttributes.LONG_RANGE_DAMAGE);
        if (player.getAttributeMap().getAttributeInstance(ModAttributes.PHYSICAL_RESISTANCE) == null)
            player.getAttributeMap().registerAttribute(ModAttributes.PHYSICAL_RESISTANCE);
        if (player.getAttributeMap().getAttributeInstance(ModAttributes.MAGIC_RESISTANCE) == null)
            player.getAttributeMap().registerAttribute(ModAttributes.MAGIC_RESISTANCE);
    }
}