package com.jlgm.dimtrapdoors.world.gen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;

public class FlatTerrainGenerator {
	private World world;
	private Random random;
	
	private final double[] heightMap;
	
	public FlatTerrainGenerator() {
		this.heightMap = new double[825];
	}
	
	public void setup(World world, Random ran) {
		this.world = world;
		this.random = ran;
	}
	
	public void generate(int chunkX, int chunkZ, ChunkPrimer primer) {
		for(int x = 0; x < 16; x++) {
			for(int z = 0; z < 16; z++) {
				primer.setBlockState(x, 0, z, Blocks.BEDROCK.getDefaultState());
			}
		}
	}
}
