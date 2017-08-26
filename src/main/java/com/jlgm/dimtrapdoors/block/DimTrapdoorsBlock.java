package com.jlgm.dimtrapdoors.block;

import com.jlgm.dimtrapdoors.lib.DimTrapdoorsConstants;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class DimTrapdoorsBlock{
	
	public static Block dimensionalTrapdoor_Block;
	public static ItemBlock dimensionalTrapdoor_ItemBlock;
	
	public static void registerBlocks(RegistryEvent.Register<Block> event){
		dimensionalTrapdoor_Block = new BlockDimensionalTrapdoor(Material.ROCK).setUnlocalizedName("dimensionaltrapdoor").setHardness(0.7F).setResistance(0.5F).setCreativeTab(CreativeTabs.REDSTONE);
		event.getRegistry().register(dimensionalTrapdoor_Block.setRegistryName("dimensionaltrapdoor"));
	}

	public static void registerItemBlocks(RegistryEvent.Register<Item> event){
		dimensionalTrapdoor_ItemBlock = new ItemBlock(dimensionalTrapdoor_Block);
		event.getRegistry().register(dimensionalTrapdoor_ItemBlock.setRegistryName(dimensionalTrapdoor_Block.getRegistryName()));
	}
	
	public static void renderBlock(){
		ModelLoader.setCustomModelResourceLocation(dimensionalTrapdoor_ItemBlock, 0,
				new ModelResourceLocation(DimTrapdoorsConstants.MODID + ":" + "dimensionaltrapdoor", "inventory"));
	}
}
