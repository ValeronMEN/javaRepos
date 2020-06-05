package aul.behmedbabmod.world;

import java.util.Random;

import aul.behmedbabmod.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {
	private int CHUNK_SIZE = 16;
	private int OVERWORLD_WORLD = 0;
	//private int NETHER_WORLD = -1;
	//private int END_WORLD = 1;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.getDimension() == OVERWORLD_WORLD) {
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}
	
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		int hardstone_y_min = 6;
		int hardstone_y_max = 26; // up to 64
		int hardstone_size_min = 1;
		int hardstone_size_max = 4;
		int hardstone_size = random.nextInt(hardstone_size_max - hardstone_size_min) + hardstone_size_min;
		int hardstone_chances = 12; // 18
		
		generateOre(ModBlocks.HARDSTONE_ORE_BLOCK.getDefaultState(), world, random, chunkX * CHUNK_SIZE, chunkZ * CHUNK_SIZE, hardstone_y_min, hardstone_y_max, hardstone_size, hardstone_chances);
	}
	
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
		int deltaY = maxY - minY;
		for(int i=0; i<chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(CHUNK_SIZE), minY + random.nextInt(deltaY), z + random.nextInt(CHUNK_SIZE));
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
		}
	}
}
