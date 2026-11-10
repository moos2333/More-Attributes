package com.npstra.moreattributes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class PhysicalResistanceHandler {
    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (!(event.getEntity() instanceof EntityPlayer)) return;
        DamageSource src = event.getSource();
        if (src.isMagicDamage() || src.getTrueSource() == null) return;

        EntityPlayer player = (EntityPlayer) event.getEntity();
        IAttributeInstance inst = ModAttributes.ensureAttribute(player, ModAttributes.PHYSICAL_RESISTANCE);
        double value = inst.getAttributeValue();
        if (value == 1.0) return;

        float multiplier = ResistanceMath.multiplier(value);
        if (multiplier != 1.0F)
            event.setAmount(event.getAmount() * multiplier);
    }
}