package com.jlgm.dimtrapdoors.world.gen;

import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

public class DimTrapdoorsChunkGenerator implements IChunkGenerator{
	
	private final World worldObj;
	private Random random;
	private Biome[] biomesForGeneration;
	
	private FlatTerrainGenerator terrainGen = new FlatTerrainGenerator();
	
	public DimTrapdoorsChunkGenerator(World worldObj) {
		this.worldObj = worldObj;
		long seed = worldObj.getSeed();
		this.random = new Random((seed + 516) * 314);
		terrainGen.setup(worldObj, random);
	}
	
	@Override
	public Chunk generateChunk(int x, int z) {
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		
		terrainGen.generate(x, z, chunkPrimer);
		Chunk chunk = new Chunk(this.worldObj, chunkPrimer, x, z);
		chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public void populate(int x, int z) {
		
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		return ImmutableList.of();
	}

	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position,
			boolean findUnexplored) {
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
		
	}

	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		return false;
	}

}
