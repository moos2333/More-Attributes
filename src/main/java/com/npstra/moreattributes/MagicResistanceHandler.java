package com.npstra.moreattributes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MagicResistanceHandler {
    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (!event.getSource().isMagicDamage()) return;
        if (!(event.getSource().getTrueSource() instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
        double attrValue = player.getEntityAttribute(ModAttributes.MAGIC_RESISTANCE).getAttributeValue();
        if (attrValue == 1.0) return;

        float multiplier = getResistanceMultiplier(attrValue);
        if (multiplier != 1.0F)
            event.setAmount(event.getAmount() * multiplier);
    }

    private static float getResistanceMultiplier(double value) {
        if (value > 1.0) {
            double excess = value - 1.0;
            int n = (int)(excess / 0.5);
            double r = excess - 0.5 * n;
            double pow = Math.pow(0.5, n);
            return (float)(pow - r * pow);
        } else {
            double deficit = 1.0 - value;
            int m = (int)(deficit / 0.5);
            double s = deficit - 0.5 * m;
            double pow = Math.pow(1.5, m);
            return (float)((1.0 + s) * pow);
        }
    }
}