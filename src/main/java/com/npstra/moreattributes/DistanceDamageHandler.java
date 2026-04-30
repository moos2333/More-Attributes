package com.npstra.moreattributes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DistanceDamageHandler {
    private static final double RANGE_THRESHOLD = 7.0;

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        Entity trueSource = event.getSource().getTrueSource();
        if (!(trueSource instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) trueSource;
        IAttributeInstance closeAttr = player.getEntityAttribute(ModAttributes.CLOSE_RANGE_DAMAGE);
        IAttributeInstance longAttr = player.getEntityAttribute(ModAttributes.LONG_RANGE_DAMAGE);
        double closeVal = closeAttr.getAttributeValue();
        double longVal = longAttr.getAttributeValue();

        if (closeVal == 1.0 && longVal == 1.0) return;

        Entity target = event.getEntity();
        double distance = player.getDistance(target);
        float multiplier = (float) (distance <= RANGE_THRESHOLD ? closeVal : longVal);

        if (multiplier != 1.0F)
            event.setAmount(event.getAmount() * multiplier);
    }
}