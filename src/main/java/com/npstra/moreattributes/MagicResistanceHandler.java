package com.npstra.moreattributes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class MagicResistanceHandler {
    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (!(event.getEntity() instanceof EntityPlayer)) return;
        if (!event.getSource().isMagicDamage()) return;

        EntityPlayer player = (EntityPlayer) event.getEntity();
        ModAttributes.ensureAttribute(player, ModAttributes.MAGIC_RESISTANCE);
        double value = player.getEntityAttribute(ModAttributes.MAGIC_RESISTANCE).getAttributeValue();
        if (value == 1.0) return;

        float multiplier = ResistanceMath.multiplier(value);
        if (multiplier != 1.0F)
            event.setAmount(event.getAmount() * multiplier);
    }
}