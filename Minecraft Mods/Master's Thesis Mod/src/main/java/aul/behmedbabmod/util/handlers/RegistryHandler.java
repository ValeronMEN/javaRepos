package aul.behmedbabmod.util.handlers;

import java.util.List;

import aul.behmedbabmod.init.ModBlocks;
import aul.behmedbabmod.init.ModItems;
import aul.behmedbabmod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ModItems.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
	}
	
	@SubscribeEvent
	public static void onBlockDestroyed(BlockEvent.HarvestDropsEvent event) {
		EntityPlayer player = event.getHarvester();
		List<ItemStack> itemStacks = event.getDrops();
		if(!itemStacks.isEmpty() && player != null) {
			for (ItemStack itemStack : itemStacks) {
				if(itemStack.getItem().getRegistryName() == (Item.getItemFromBlock(Blocks.DIRT)).getRegistryName() && player.getHeldItemMainhand().getItem().getRegistryName() == ModItems.ARMY_SPADE.getRegistryName()) {
					itemStacks.clear();
					itemStacks.add(new ItemStack(ModItems.CRAP));
					//System.out.println("Army spade bonus!");
				}
			}
		}
	}
	
	@SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event){
		if(event.getEntityLiving() instanceof EntityZombie) {
			event.getEntityLiving().dropItem(ModItems.CALLING_UP_PAPER, 1);
		}
		if(event.getSource() != null) {
			DamageSource ds = event.getSource();
			if(ds != null) {
				Entity entity = ds.getTrueSource();
				if(entity != null && entity instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer)entity;
					if(player.getHeldItemMainhand().getItem().getRegistryName() == ModItems.ARMY_HOE.getRegistryName()) {
						event.getEntityLiving().dropItem(ModItems.DICK, 1);
					}
				}
			}
		}
    }
}
