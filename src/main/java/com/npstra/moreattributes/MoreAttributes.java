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
    public static boolean enablePotionPhysicalDefence = true;
    public static boolean enablePotionMagicDefence = true;
    public static boolean enablePotionDeadeye = true;
    public static boolean enablePotionArcane = true;

    public static double braveryBonus = 0.01;
    public static double snipeBonus = 0.01;
    public static double physicalDefenceBonus = 0.01;
    public static double magicDefenceBonus = 0.01;
    public static double deadeyeBonus = 0.01;
    public static double arcaneBonus = 0.01;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Hello From {}!", Tags.MOD_NAME);
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        enablePotionBravery = config.getBoolean("Bravery", "potions", true, "Enable Bravery potion effect");
        enablePotionSnipe = config.getBoolean("Snipe", "potions", true, "Enable Snipe potion effect");
        enablePotionPhysicalDefence = config.getBoolean("PhysicalDefence", "potions", true, "Enable Physical Defence effect");
        enablePotionMagicDefence = config.getBoolean("MagicDefence", "potions", true, "Enable Magic Defence effect");
        enablePotionDeadeye = config.getBoolean("Deadeye", "potions", true, "Enable Deadeye potion effect");
        enablePotionArcane = config.getBoolean("Arcane", "potions", true, "Enable Arcane potion effect");

        braveryBonus = config.getFloat("BraveryBonus", "potions", 0.01F, 0.0F, 100.0F, "Bravery bonus per level (1.0 = 100%)");
        snipeBonus = config.getFloat("SnipeBonus", "potions", 0.01F, 0.0F, 100.0F, "Snipe bonus per level");
        physicalDefenceBonus = config.getFloat("PhysicalDefenceBonus", "potions", 0.01F, 0.0F, 100.0F, "Physical Defence bonus per level");
        magicDefenceBonus = config.getFloat("MagicDefenceBonus", "potions", 0.01F, 0.0F, 100.0F, "Magic Defence bonus per level");
        deadeyeBonus = config.getFloat("DeadeyeBonus", "potions", 0.01F, 0.0F, 100.0F, "Deadeye bonus per level");
        arcaneBonus = config.getFloat("ArcaneBonus", "potions", 0.01F, 0.0F, 100.0F, "Arcane bonus per level");

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
            if (MoreAttributes.enablePotionPhysicalDefence)
                event.getRegistry().register(new PotionPhysicalDefence());
            if (MoreAttributes.enablePotionMagicDefence)
                event.getRegistry().register(new PotionMagicDefence());
            if (MoreAttributes.enablePotionDeadeye)
                event.getRegistry().register(new PotionDeadeye());
            if (MoreAttributes.enablePotionArcane)
                event.getRegistry().register(new PotionArcane());
        }
    }
}