package aul.behmedbabmod.items.food;

import aul.behmedbabmod.Main;
import aul.behmedbabmod.init.ModItems;
import aul.behmedbabmod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class FoodBase extends ItemFood implements IHasModel {
	public FoodBase(String name, int amount, float saturation, boolean isAnimalFood, CreativeTabs tab) {
		super(amount, saturation, isAnimalFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
