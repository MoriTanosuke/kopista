package de.kopis.kopista;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import de.kopis.kopista.blocks.AsphaltOre;

@Mod(modid = KopistaMod.MODID, version = KopistaMod.VERSION)
public class KopistaMod {
    @Instance(value = KopistaMod.MODID)
    // Tell Forge what instance to use.
    public static KopistaMod instance;

    public static final String MODID = "kopista";
    public static final String VERSION = "0.0.1";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        AsphaltOre asphaltOre = new AsphaltOre();
        GameRegistry.registerBlock(asphaltOre, asphaltOre.getUnlocalizedName());
        Minecraft.getMinecraft().renderEngine.bindTexture(asphaltOre.getTexture());
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLLog.info("preInit called");
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        FMLLog.info("load called");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        FMLLog.info("postInit called");
    }
}