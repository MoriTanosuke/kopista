package de.kopis.kopista.world;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.IWorldGenerator;
import de.kopis.kopista.blocks.AsphaltOre;

public class KopistaWorldGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		int x = chunkX + random.nextInt(16);
		int z = chunkZ + random.nextInt(16);
		int y = random.nextInt(55);
		int numberOfBlocks = new Random().nextInt(6);
		FMLLog.fine("Generated %d blocks of AsphaltOre at %d,%d,%d", numberOfBlocks, x, y, z);

		//TODO make sure this is actually placing blocks into the world...
		WorldGenMinable mineable = new WorldGenMinable(new AsphaltOre()
				.getBlockState().getBaseState(), numberOfBlocks);
		mineable.generate(world, random, new BlockPos(x, y, z));
	}

}
