package de.kopis.kopista.recipes;

import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.ShapedOreRecipe;
import de.kopis.kopista.KopistaMod;

public class ProcessedAsphaltOreRecipe extends ShapedOreRecipe {

	public ProcessedAsphaltOreRecipe() {
		super(KopistaMod.PROCESSED_ASPHALTORE, new Object[] {"###", "XXX", "###", '#', KopistaMod.ASPHALTORE, 'X', Blocks.sand});
	}
	
}
