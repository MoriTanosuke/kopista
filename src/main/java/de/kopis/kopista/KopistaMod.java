package de.kopis.kopista;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import de.kopis.kopista.blocks.AsphaltOre;
import de.kopis.kopista.blocks.ProcessedAsphaltOre;
import de.kopis.kopista.recipes.ProcessedAsphaltOreRecipe;
import de.kopis.kopista.world.KopistaWorldGeneration;

@Mod(modid = KopistaMod.MODID, version = KopistaMod.VERSION)
public class KopistaMod {
	@Instance(value = KopistaMod.MODID)
	public static KopistaMod instance;

	public static final String MODID = "kopista";
	public static final String VERSION = "0.0.1";

	public static AsphaltOre ASPHALTORE;
	public static ProcessedAsphaltOre PROCESSED_ASPHALTORE;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		FMLLog.info("init called");
		// create & register blocks
		ASPHALTORE = new AsphaltOre();
		PROCESSED_ASPHALTORE = new ProcessedAsphaltOre();

		// register recipes
		//TODO automatically get all recipes and register them
		GameRegistry.addRecipe(new ProcessedAsphaltOreRecipe());
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		FMLLog.info("preInit called");
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		FMLLog.info("load called");

		// register world generator
		int generationWeight = 1;
		GameRegistry.registerWorldGenerator(new KopistaWorldGeneration(),
				generationWeight);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		FMLLog.info("postInit called");
	}
}
