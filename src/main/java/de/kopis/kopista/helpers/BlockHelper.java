package de.kopis.kopista.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import de.kopis.kopista.KopistaMod;
import de.kopis.kopista.blocks.GenericBlock;


public class BlockHelper {
	public static void registerBlock(GenericBlock b) {
		GameRegistry.registerBlock(b, b.getName());
		Item block = GameRegistry.findItem(KopistaMod.MODID, b.getName());
		ModelResourceLocation modelLocation = new ModelResourceLocation(
				b.getTexture(), "inventory");
		final int DEFAULT_ITEM_SUBTYPE = 0;
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(block, DEFAULT_ITEM_SUBTYPE, modelLocation);
	}
}