package com.npstra.moreattributes;

import com.npstra.moreattributes.potions.*;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class MoreAttributes {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    public static boolean enablePotionBravery = true;
    public static boolean enablePotionSnipe = true;
    public static boolean enablePotionDefenceBoundary = true;
    public static boolean enablePotionMagicShelter = true;
    public static boolean enablePotionDeadeye = true;
    public static boolean enablePotionArcane = true;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Hello From {}!", Tags.MOD_NAME);
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        enablePotionBravery = config.getBoolean("Bravery", "potions", true, "Enable Bravery potion effect");
        enablePotionSnipe = config.getBoolean("Snipe", "potions", true, "Enable Snipe potion effect");
        enablePotionDefenceBoundary = config.getBoolean("DefenceBoundary", "potions", true, "Enable Defence Boundary effect");
        enablePotionMagicShelter = config.getBoolean("MagicShelter", "potions", true, "Enable Magic Shelter effect");
        enablePotionDeadeye = config.getBoolean("Deadeye", "potions", true, "Enable Deadeye potion effect");
        enablePotionArcane = config.getBoolean("Arcane", "potions", true, "Enable Arcane potion effect");
        config.save();

        MinecraftForge.EVENT_BUS.register(new AttributeInjector());
        MinecraftForge.EVENT_BUS.register(new RangeDamageHandler());
        MinecraftForge.EVENT_BUS.register(new MagicDamageHandler());
        MinecraftForge.EVENT_BUS.register(new DistanceDamageHandler());
        MinecraftForge.EVENT_BUS.register(new PhysicalResistanceHandler());
        MinecraftForge.EVENT_BUS.register(new MagicResistanceHandler());
    }

    @Mod.EventBusSubscriber
    public static class PotionRegistry {
        @SubscribeEvent
        public static void registerPotions(RegistryEvent.Register<Potion> event) {
            if (MoreAttributes.enablePotionBravery)
                event.getRegistry().register(new PotionBravery());
            if (MoreAttributes.enablePotionSnipe)
                event.getRegistry().register(new PotionSnipe());
            if (MoreAttributes.enablePotionDefenceBoundary)
                event.getRegistry().register(new PotionDefenceBoundary());
            if (MoreAttributes.enablePotionMagicShelter)
                event.getRegistry().register(new PotionMagicShelter());
            if (MoreAttributes.enablePotionDeadeye)
                event.getRegistry().register(new PotionDeadeye());
            if (MoreAttributes.enablePotionArcane)
                event.getRegistry().register(new PotionArcane());
        }
    }
}