package com.jlgm.dimtrapdoors.main;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod.EventBusSubscriber
public class DimTrapdoorsServerProxy extends DimTrapdoorsCommonProxy{

	@Override
	public void preInit(FMLPreInitializationEvent preInitEvent){
		super.preInit(preInitEvent);
	}

	@Override
	public void init(FMLInitializationEvent initEvent){
		super.init(initEvent);
	}

	@Override
	public void postInit(FMLPostInitializationEvent postInitEvent){
		super.postInit(postInitEvent);
	}
}
