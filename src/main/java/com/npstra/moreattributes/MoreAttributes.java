package com.npstra.moreattributes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class MoreAttributes {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new AttributeInjector());
        MinecraftForge.EVENT_BUS.register(new RangeDamageHandler());
        MinecraftForge.EVENT_BUS.register(new MagicDamageHandler());
        MinecraftForge.EVENT_BUS.register(new DistanceDamageHandler());
    }
}