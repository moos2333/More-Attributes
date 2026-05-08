package com.npstra.moreattributes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MagicDamageHandler {
    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (!event.getSource().isMagicDamage()) return;
        if (!(event.getSource().getTrueSource() instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
        ModAttributes.ensureAttribute(player, ModAttributes.MAGIC_DAMAGE);
        float multiplier = (float) player.getEntityAttribute(ModAttributes.MAGIC_DAMAGE).getAttributeValue();
        if (multiplier != 1.0F)
            event.setAmount(event.getAmount() * multiplier);
    }
}