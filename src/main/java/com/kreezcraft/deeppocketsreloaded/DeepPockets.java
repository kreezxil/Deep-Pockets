package com.kreezcraft.deeppocketsreloaded;

import com.kreezcraft.deeppocketsreloaded.Items.DeepPocketsItems;
import com.kreezcraft.deeppocketsreloaded.event.ItemPickupEvent;
import com.kreezcraft.deeppocketsreloaded.proxy.CommonProxy;
import com.kreezcraft.deeppocketsreloaded.proxy.compatability.Compatability;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = DeepPockets.MODID, version = DeepPockets.VERSION, name = DeepPockets.NAME)
public class DeepPockets
{
    public static final String MODID = "deeppockets";
    public static final String NAME = "Deep Pockets Reloaded";
    public static final String VERSION = "@VERSION@";

	@Mod.Instance(MODID)
	public static DeepPockets instance;
	
	@SidedProxy(serverSide = "com.kreezcraft.deeppocketsreloaded.proxy.CommonProxy", clientSide = "com.kreezcraft.deeppocketsreloaded.proxy.ClientProxy")
	public static CommonProxy proxy;
	
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	Compatability.init();
    	
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		DeepPocketsConfig.init(config);
		
    	DeepPocketsItems.init();
    	DeepPocketsItems.registerItems();
    	DeepPocketsItems.registeryRenderers();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//Recipes.registerRecipies();
    	
    	MinecraftForge.EVENT_BUS.register(new ItemPickupEvent());
    }
}
