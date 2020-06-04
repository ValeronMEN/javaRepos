package aul.behmedbabmod.tabs;

import aul.behmedbabmod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MastersThesisTab extends CreativeTabs {

	public MastersThesisTab(String name) {
		super(name);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.MASTERS_THESIS_NORMAL_FULL);
	}
}
