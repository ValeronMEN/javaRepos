package aul.behmedbabmod.init;

import java.util.ArrayList;
import java.util.List;

import aul.behmedbabmod.Main;
import aul.behmedbabmod.items.ItemBase;
import aul.behmedbabmod.items.armor.ArmorBase;
import aul.behmedbabmod.items.tools.ToolAxe;
import aul.behmedbabmod.items.tools.ToolHoe;
import aul.behmedbabmod.items.tools.ToolPickaxe;
import aul.behmedbabmod.items.tools.ToolSpade;
import aul.behmedbabmod.items.tools.ToolSword;
import aul.behmedbabmod.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

//where recipes can be formed:
//https://crafting.thedestruc7i0n.ca/
public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Items
	public static final Item CRAP = new ItemBase("crap", Main.MASTERS_THESIS_TAB);
	public static final Item DICK = new ItemBase("dick", Main.MASTERS_THESIS_TAB);
	public static final Item NOODLES = new ItemBase("noodles", Main.MASTERS_THESIS_TAB);
	public static final Item HARDSTONE_INGOT = new ItemBase("hardstone_ingot", Main.MASTERS_THESIS_TAB);
	public static final Item CALLING_UP_PAPER = new ItemBase("calling_up_paper", Main.MASTERS_THESIS_TAB);
	
	public static final Item BOTTLE_OF_BEER = new ItemBase("bottle_of_beer", Main.MASTERS_THESIS_TAB);
	public static final Item BOTTLE_EMPTY = new ItemBase("bottle_empty", Main.MASTERS_THESIS_TAB);
	
	public static final Item CHAPTER_PAPER1 = new ItemBase("chapter_paper1", Main.MASTERS_THESIS_TAB);
	public static final Item CHAPTER_PAPER2 = new ItemBase("chapter_paper2", Main.MASTERS_THESIS_TAB);
	public static final Item CHAPTER_PAPER3 = new ItemBase("chapter_paper3", Main.MASTERS_THESIS_TAB);
	public static final Item CHAPTER_PAPER4 = new ItemBase("chapter_paper4", Main.MASTERS_THESIS_TAB);
	public static final Item CHAPTER_PAPER5 = new ItemBase("chapter_paper5", Main.MASTERS_THESIS_TAB);
	
	public static final Item MASTERS_THESIS_NORMAL_PROTOTYPE = new ItemBase("masters_thesis_normal_prototype", Main.MASTERS_THESIS_TAB);
	public static final Item MASTERS_THESIS_NORMAL_TO_FUCK_OFF = new ItemBase("masters_thesis_normal_to_fuck_off", Main.MASTERS_THESIS_TAB);
	public static final Item MASTERS_THESIS_NORMAL_FULL = new ItemBase("masters_thesis_normal_full", Main.MASTERS_THESIS_TAB);
	
	public static final Item MASTERS_THESIS_ANOTHERS = new ItemBase("masters_thesis_anothers", Main.MASTERS_THESIS_TAB);
	public static final Item MASTERS_THESIS_SHITTY = new ItemBase("masters_thesis_shitty", Main.MASTERS_THESIS_TAB);
	public static final Item MASTERS_THESIS_SNATCHED = new ItemBase("masters_thesis_snatched", Main.MASTERS_THESIS_TAB);
	
	// Materials
	//WOOD(0, 59, 2.0F, 0.0F, 15),
    //STONE(1, 131, 4.0F, 1.0F, 5),
    //IRON(2, 250, 6.0F, 2.0F, 14),
    //DIAMOND(3, 1561, 8.0F, 3.0F, 10),
    //GOLD(0, 32, 12.0F, 0.0F, 22);
	public static final ToolMaterial TOOL_MATERIAL_ARMY = EnumHelper.addToolMaterial("tool_material_army", 2, 250, 6.0F, 3.0F, 10);
	public static final ArmorMaterial ARMOR_MATERIAL_ARMY = EnumHelper.addArmorMaterial("armor_material_army", Reference.MOD_ID + ":army", 10, new int [] {1,1,1,1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);
	
	// Tools
	public static final ItemSword ARMY_BREAD_KNIFE = new ToolSword("army_bread_knife", TOOL_MATERIAL_ARMY, Main.MASTERS_THESIS_TAB);
	public static final ItemSpade ARMY_SPADE = new ToolSpade("army_spade", TOOL_MATERIAL_ARMY, Main.MASTERS_THESIS_TAB);
	public static final ItemAxe ARMY_AXE = new ToolAxe("army_axe", TOOL_MATERIAL_ARMY, Main.MASTERS_THESIS_TAB);
	public static final ItemPickaxe ARMY_PICKAXE = new ToolPickaxe("army_pickaxe", TOOL_MATERIAL_ARMY, Main.MASTERS_THESIS_TAB);
	public static final ItemHoe ARMY_HOE = new ToolHoe("army_hoe", TOOL_MATERIAL_ARMY, Main.MASTERS_THESIS_TAB);
	
	// Armor
	public static final Item ARMY_HELMET = new ArmorBase("army_helmet", ARMOR_MATERIAL_ARMY, 1, EntityEquipmentSlot.HEAD, Main.MASTERS_THESIS_TAB);
	public static final Item ARMY_CHESTPLATE = new ArmorBase("army_chestplate", ARMOR_MATERIAL_ARMY, 1, EntityEquipmentSlot.CHEST, Main.MASTERS_THESIS_TAB);
	public static final Item ARMY_LEGGINGS = new ArmorBase("army_leggings", ARMOR_MATERIAL_ARMY, 2, EntityEquipmentSlot.LEGS, Main.MASTERS_THESIS_TAB);
	public static final Item ARMY_BOOTS = new ArmorBase("army_boots", ARMOR_MATERIAL_ARMY, 1, EntityEquipmentSlot.FEET, Main.MASTERS_THESIS_TAB);
}
