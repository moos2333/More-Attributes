package com.npstra.moreattributes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class RangeDamageHandler {
    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        if (!source.isProjectile()) return;
        if (!(source.getTrueSource() instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) source.getTrueSource();
        IAttributeInstance inst = ModAttributes.ensureAttribute(player, ModAttributes.RANGE_DAMAGE);
        float multiplier = (float) inst.getAttributeValue();
        if (multiplier != 1.0F)
            event.setAmount(event.getAmount() * multiplier);
    }
}