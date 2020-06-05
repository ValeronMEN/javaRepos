package aul.behmedbabmod.blocks;

import java.util.Random;

import aul.behmedbabmod.init.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HardstoneOre extends BlockBase {

	public HardstoneOre(String name, Material material, CreativeTabs tab) {
		super(name, material, tab);
		
		setSoundType(SoundType.STONE); // the sound you hear when you walk on it
		setHardness(3.0F); // check the hardness table on Internet
		setResistance(15.0F); // resistance to explosions 
		setHarvestLevel("pickaxe", 2); // 0 - Wood, 1 - Stone, 2 - Iron/Gold, 3 - Diamond
		setLightLevel(0.0F); // up to 15 to light as a torch
		//setLightOpacity(1); // it's for glass to not block the light
		//setBlockUnbreakable(); // like a bedrock
	}
	
	@Override 
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.HARDSTONE_ORE_BLOCK);
	}
	
	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}
}
