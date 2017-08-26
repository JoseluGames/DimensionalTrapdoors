package com.jlgm.dimtrapdoors.main;

import com.jlgm.dimtrapdoors.lib.DimTrapdoorsConstants;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = DimTrapdoorsConstants.MODID,
	name = DimTrapdoorsConstants.NAME,
	version = DimTrapdoorsConstants.VERSION,
	acceptedMinecraftVersions = DimTrapdoorsConstants.ACCEPTEDMINECRAFTVERSIONS,
	updateJSON = DimTrapdoorsConstants.UPDATEJSON)

public class DimTrapdoorsMain{

	@SidedProxy(clientSide = DimTrapdoorsConstants.CLIENT_PROXY, serverSide = DimTrapdoorsConstants.SERVER_PROXY)
	public static DimTrapdoorsCommonProxy proxy;
	@Mod.Instance(DimTrapdoorsConstants.MODID)
	public static DimTrapdoorsMain instance;

	@Mod.EventHandler
	public static void PreInit(FMLPreInitializationEvent preInitEvent){
		proxy.preInit(preInitEvent);
	}

	@Mod.EventHandler
	public static void Init(FMLInitializationEvent initEvent){
		proxy.init(initEvent);
	}

	@Mod.EventHandler
	public static void PostInit(FMLPostInitializationEvent postInitEvent){
		proxy.postInit(postInitEvent);
	}
}
