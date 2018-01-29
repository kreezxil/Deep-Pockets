package com.kreezcraft.deeppocketsreloaded;

import com.kreezcraft.deeppocketsreloaded.Items.DeepPocketsItems;
import com.kreezcraft.deeppocketsreloaded.Items.ItemMiningPack;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;

public class PackModel implements ItemMeshDefinition  {

	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) 
	{
		if(stack.getItem() == DeepPocketsItems.miningPack)
		{
			ItemMiningPack pack = (ItemMiningPack)stack.getItem();
			
			int items = pack.getTotalItems(stack);
			int i = Math.min(1+items/128, 4);
			return new ModelResourceLocation("deeppockets:miningpack" + i, "inventory");
		}

		if(stack.getItem() == DeepPocketsItems.advancedMiningPack)
		{
			ItemMiningPack pack = (ItemMiningPack)stack.getItem();
			
			int items = pack.getTotalItems(stack);
			int i = Math.min(1+items/128, 4);
			return new ModelResourceLocation("deeppockets:advancedminingpack" + i, "inventory");
		}
		
		return null;
	}

}
