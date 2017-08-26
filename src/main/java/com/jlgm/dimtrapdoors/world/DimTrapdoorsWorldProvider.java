package com.jlgm.dimtrapdoors.world;

import com.jlgm.dimtrapdoors.world.gen.DimTrapdoorsChunkGenerator;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class DimTrapdoorsWorldProvider extends WorldProvider{

	@Override
	public DimensionType getDimensionType() {
		return DimTrapdoorsDimension.dimTrapdoorsDimension;
	}
	
	@Override
	public String getSaveFolder() {
		return "TEST";
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new DimTrapdoorsChunkGenerator(world);
	}
}
