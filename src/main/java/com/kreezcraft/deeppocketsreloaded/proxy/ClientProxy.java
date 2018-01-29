package com.kreezcraft.deeppocketsreloaded.proxy;

import com.kreezcraft.deeppocketsreloaded.Items.DeepPocketsItems;

public class ClientProxy extends CommonProxy
{
	public void registerRenderers()
	{
		DeepPocketsItems.registeryRenderers();
	}
}
