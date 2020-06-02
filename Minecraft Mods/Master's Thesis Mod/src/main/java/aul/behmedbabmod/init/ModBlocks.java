package aul.behmedbabmod.init;

import java.util.ArrayList;
import java.util.List;

import aul.behmedbabmod.blocks.BlockBase;
import aul.behmedbabmod.blocks.HardstoneOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block HARDSTONE_ORE_BLOCK = new HardstoneOre("hardstone_ore_block", Material.IRON);
}
