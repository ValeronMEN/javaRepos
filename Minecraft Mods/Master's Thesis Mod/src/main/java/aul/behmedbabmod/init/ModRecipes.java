package aul.behmedbabmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_ORE_BLOCK, new ItemStack(ModItems.HARDSTONE_INGOT, 1), 1.5f);
	}
}
