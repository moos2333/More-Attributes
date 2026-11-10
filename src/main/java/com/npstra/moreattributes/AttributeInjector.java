package com.npstra.moreattributes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class AttributeInjector {
    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof EntityPlayer)) return;
        EntityPlayer player = (EntityPlayer) event.getEntity();
        ModAttributes.ensureAttribute(player, ModAttributes.RANGE_DAMAGE);
        ModAttributes.ensureAttribute(player, ModAttributes.MAGIC_DAMAGE);
        ModAttributes.ensureAttribute(player, ModAttributes.CLOSE_RANGE_DAMAGE);
        ModAttributes.ensureAttribute(player, ModAttributes.LONG_RANGE_DAMAGE);
        ModAttributes.ensureAttribute(player, ModAttributes.PHYSICAL_RESISTANCE);
        ModAttributes.ensureAttribute(player, ModAttributes.MAGIC_RESISTANCE);
    }
}