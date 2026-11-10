package com.npstra.moreattributes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class DistanceDamageHandler {
    private static final double RANGE_THRESHOLD = 7.0;

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        Entity trueSource = event.getSource().getTrueSource();
        if (!(trueSource instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) trueSource;
        IAttributeInstance closeInst = ModAttributes.ensureAttribute(player, ModAttributes.CLOSE_RANGE_DAMAGE);
        IAttributeInstance longInst = ModAttributes.ensureAttribute(player, ModAttributes.LONG_RANGE_DAMAGE);
        double closeVal = closeInst.getAttributeValue();
        double longVal = longInst.getAttributeValue();

        if (closeVal == 1.0 && longVal == 1.0) return;

        double distance = player.getDistance(event.getEntity());
        float multiplier = (float) (distance <= RANGE_THRESHOLD ? closeVal : longVal);

        if (multiplier != 1.0F)
            event.setAmount(event.getAmount() * multiplier);
    }
}