package com.kreezcraft.deeppocketsreloaded.event;

import java.util.Random;

import com.kreezcraft.deeppocketsreloaded.DeepPocketsConfig;
import com.kreezcraft.deeppocketsreloaded.Items.ItemMiningPack;
import com.kreezcraft.deeppocketsreloaded.Items.ItemMiningPack.StoredOre;
import com.kreezcraft.deeppocketsreloaded.proxy.compatability.Compatability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemPickupEvent 
{
	@SubscribeEvent
	public void pickupItemEvent(EntityItemPickupEvent event)
	{
		if(event.getEntityPlayer() != null)
		{
			String oreName = DeepPocketsConfig.isOre(event.getItem().getEntityItem());
			if(oreName != null)
			{
				EntityPlayer player = event.getEntityPlayer();
				for(ItemStack stack : Compatability.getInventory(player.inventory))
				{
					if(stack.getItem() instanceof ItemMiningPack)
					{		
						ItemMiningPack pack = (ItemMiningPack)stack.getItem();

						if(pack.numStoredOres(stack) < pack.getMaxSlots() || pack.containsOre(stack, oreName))
						{
							StoredOre ore = pack.getOre(stack, oreName);
							ore.amount += Compatability.getStackCount(event.getItem().getEntityItem());
							ore.displayName = event.getItem().getEntityItem().getDisplayName();
							if(ore.registryName == null)
							{
								ore.registryName = event.getItem().getEntityItem().getItem().getRegistryName().toString();
								ore.meta = event.getItem().getEntityItem().getItemDamage();
							}
							pack.setOre(stack, oreName, ore);

							Random rand = new Random();
							float f = ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F;
							player.world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.AMBIENT, 0.2f, f);
							
							Compatability.setCount(event.getItem().getEntityItem(), 0);
							event.setCanceled(true);
							return;
						}
					}
				}
			}
		}
	}
}
