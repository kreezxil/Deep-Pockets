package com.kreezcraft.deeppocketsreloaded.Items;

import java.util.ArrayList;
import java.util.List;

import com.kreezcraft.deeppocketsreloaded.DeepPockets;
import com.kreezcraft.deeppocketsreloaded.PackModel;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DeepPocketsItems 
{
	public static ItemMiningPack miningPack;
	public static ItemMiningPack advancedMiningPack;
	
	public static void init()
	{
		miningPack = (ItemMiningPack) new ItemMiningPack(5).setUnlocalizedName("miningpack").setRegistryName("miningpack").setCreativeTab(CreativeTabs.TOOLS);
		advancedMiningPack = (ItemMiningPack) new ItemMiningPack(10).setUnlocalizedName("advancedminingpack").setRegistryName("advancedminingpack").setCreativeTab(CreativeTabs.TOOLS);
	}
	
	public static void registerItems()
	{
		miningPack.registerModels();
		advancedMiningPack.registerModels();
//		GameRegistry.register(miningPack);
//		GameRegistry.register(advancedMiningPack);
	}
	
   
	public static void registeryRenderers()
	{
		List<ModelResourceLocation> packModels = new ArrayList<ModelResourceLocation>();
		List<ModelResourceLocation> advancedPackModels = new ArrayList<ModelResourceLocation>();
		for(int i = 1; i <= 4; i++)
		{
			packModels.add(new ModelResourceLocation("deeppockets:miningpack" + i, "inventory"));
			advancedPackModels.add(new ModelResourceLocation("deeppockets:advancedminingpack" + i, "inventory"));
		}
		
		ModelLoader.registerItemVariants(miningPack, packModels.toArray(new ModelResourceLocation[packModels.size()]));
		ModelLoader.registerItemVariants(advancedMiningPack, advancedPackModels.toArray(new ModelResourceLocation[advancedPackModels.size()]));
		ModelLoader.setCustomMeshDefinition(miningPack, new PackModel());
		ModelLoader.setCustomMeshDefinition(advancedMiningPack, new PackModel());
	}
}
