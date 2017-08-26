package com.jlgm.dimtrapdoors.item;

import com.jlgm.dimtrapdoors.lib.DimTrapdoorsConstants;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class DimTrapdoorsItem {
	
	//public static Item elemSlimesEgg_Item;
	
	public static void registerItems(RegistryEvent.Register<Item> event){
		/*elemSlimesEgg_Item = new ItemDimTrapdoorsEgg().setUnlocalizedName("dimtrapdoorsegg");
		event.getRegistry().register(elemSlimesEgg_Item.setRegistryName("dimtrapdoorsegg"));*/
	}
	
	public static void renderItem() {
		/*ModelLoader.setCustomModelResourceLocation(elemSlimesEgg_Item, i,
			new ModelResourceLocation(DimTrapdoorsConstants.MODID + ":" + "dimtrapdoorsegg", "inventory"));*/
	}
}
