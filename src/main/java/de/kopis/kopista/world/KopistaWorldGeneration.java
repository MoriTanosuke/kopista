package de.kopis.kopista.world;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.IWorldGenerator;
import de.kopis.kopista.KopistaMod;

public class KopistaWorldGeneration implements IWorldGenerator {
	private static final int MIN_HEIGHT_IN_WORLD = 32;
	// generate between 32 and 64
	private static final int MAX_HEIGHT_IN_WORLD = 64 - MIN_HEIGHT_IN_WORLD;
	private static final int MAX_GENERATED_BLOCKS = 10;
	private static final int MAX_VEINS_PER_CHUNK = 10;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (int i = 0; i < MAX_VEINS_PER_CHUNK; i++) {
			// transform chunk x, z
			int realX = chunkX * 16 + random.nextInt(16);
			int realZ = chunkZ * 16 + random.nextInt(16);
			int numberOfBlocks = random.nextInt(MAX_GENERATED_BLOCKS);

			// create a mineable for this ore
			WorldGenMinable mineable = new WorldGenMinable(
					KopistaMod.ASPHALTORE.getDefaultState(), numberOfBlocks);

			// set a random y for this block
			int y = MIN_HEIGHT_IN_WORLD + random.nextInt(MAX_HEIGHT_IN_WORLD);

			BlockPos blockPosition = new BlockPos(realX, y, realZ);
			if (mineable.generate(world, random, blockPosition)) {
				// TODO set log level finer
				FMLLog.info("Generated %d blocks of AsphaltOre at %d,%d,%d",
						numberOfBlocks, blockPosition.getX(),
						blockPosition.getY(), blockPosition.getZ());
			} else {
				FMLLog.info(
						"Could not generate %d blocks of AsphaltOre at %d,%d,%d",
						numberOfBlocks, blockPosition.getX(),
						blockPosition.getY(), blockPosition.getZ());
			}
		}
	}

}
