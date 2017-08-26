package com.jlgm.dimtrapdoors.main;

import com.jlgm.dimtrapdoors.block.DimTrapdoorsBlock;
import com.jlgm.dimtrapdoors.item.DimTrapdoorsItem;
import com.jlgm.dimtrapdoors.world.DimTrapdoorsDimension;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class DimTrapdoorsCommonProxy{

	public void preInit(FMLPreInitializationEvent preInitEvent){
		DimTrapdoorsDimension.register();
	}
	
	public void init(FMLInitializationEvent initEvent){
		
	}

	public void postInit(FMLPostInitializationEvent postInitEvent){

	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event){
		DimTrapdoorsBlock.registerBlocks(event);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event){
		DimTrapdoorsBlock.registerItemBlocks(event);
		DimTrapdoorsItem.registerItems(event);
	}
}
