package aul.behmedbabmod.init;

import java.util.ArrayList;
import java.util.List;

import aul.behmedbabmod.items.ItemBase;
import aul.behmedbabmod.items.tools.ToolAxe;
import aul.behmedbabmod.items.tools.ToolHoe;
import aul.behmedbabmod.items.tools.ToolPickaxe;
import aul.behmedbabmod.items.tools.ToolSpade;
import aul.behmedbabmod.items.tools.ToolSword;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

//where recipes can be formed:
//https://crafting.thedestruc7i0n.ca/
public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Items
	public static final Item CRAP = new ItemBase("crap");
	public static final Item DICK = new ItemBase("dick");
	public static final Item NOODLES = new ItemBase("noodles");
	public static final Item HARDSTONE_INGOT = new ItemBase("hardstone_ingot");
	public static final Item CALLING_UP_PAPER = new ItemBase("calling_up_paper");
	
	public static final Item CHAPTER_PAPER1 = new ItemBase("chapter_paper1");
	public static final Item CHAPTER_PAPER2 = new ItemBase("chapter_paper2");
	public static final Item CHAPTER_PAPER3 = new ItemBase("chapter_paper3");
	public static final Item CHAPTER_PAPER4 = new ItemBase("chapter_paper4");
	public static final Item CHAPTER_PAPER5 = new ItemBase("chapter_paper5");
	
	public static final Item MASTERS_THESIS_NORMAL_PROTOTYPE = new ItemBase("masters_thesis_normal_prototype");
	public static final Item MASTERS_THESIS_NORMAL_TO_FUCK_OFF = new ItemBase("masters_thesis_normal_to_fuck_off");
	public static final Item MASTERS_THESIS_NORMAL_FULL = new ItemBase("masters_thesis_normal_full");
	
	public static final Item MASTERS_THESIS_ANOTHERS = new ItemBase("masters_thesis_anothers");
	public static final Item MASTERS_THESIS_SHITTY = new ItemBase("masters_thesis_shitty");
	public static final Item MASTERS_THESIS_SNATCHED = new ItemBase("masters_thesis_snatched");
	
	// Materials
	//WOOD(0, 59, 2.0F, 0.0F, 15),
    //STONE(1, 131, 4.0F, 1.0F, 5),
    //IRON(2, 250, 6.0F, 2.0F, 14),
    //DIAMOND(3, 1561, 8.0F, 3.0F, 10),
    //GOLD(0, 32, 12.0F, 0.0F, 22);
	public static final ToolMaterial MATERIAL_ARMY = EnumHelper.addToolMaterial("material_army", 2, 250, 6.0F, 3.0F, 10);
	
	// Tools
	public static final ItemSword ARMY_BREAD_KNIFE = new ToolSword("army_bread_knife", MATERIAL_ARMY);
	public static final ItemSpade ARMY_SPADE = new ToolSpade("army_spade", MATERIAL_ARMY);
	public static final ItemAxe ARMY_AXE = new ToolAxe("army_axe", MATERIAL_ARMY);
	public static final ItemPickaxe ARMY_PICKAXE = new ToolPickaxe("army_pickaxe", MATERIAL_ARMY);
	public static final ItemHoe ARMY_HOE = new ToolHoe("army_hoe", MATERIAL_ARMY);
	
}
