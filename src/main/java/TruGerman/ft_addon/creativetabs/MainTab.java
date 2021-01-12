package TruGerman.ft_addon.creativetabs;

import TruGerman.ft_addon.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MainTab extends CreativeTabs
{

	public MainTab(String label) 
	{
		super(label);	
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(BlockInit.ETHERNANO_GENERATOR);
	}

}
