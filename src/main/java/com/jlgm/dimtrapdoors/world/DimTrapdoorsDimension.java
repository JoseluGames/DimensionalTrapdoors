package com.jlgm.dimtrapdoors.world;

import com.jlgm.dimtrapdoors.lib.DimTrapdoorsConstants;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimTrapdoorsDimension {
	public static DimensionType dimTrapdoorsDimension;
	
	public static void register() {
		registerDimensionTypes();
		registerDimensions();
	}
	
	private static void registerDimensionTypes() {
		dimTrapdoorsDimension = DimensionType.register(DimTrapdoorsConstants.MODID, "_test", 15, DimTrapdoorsWorldProvider.class, false);
	}
	
	private static void registerDimensions() {
		DimensionManager.registerDimension(15, dimTrapdoorsDimension);
	}
}
