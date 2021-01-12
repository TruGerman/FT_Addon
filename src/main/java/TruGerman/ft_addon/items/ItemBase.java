package TruGerman.ft_addon.items;

import TruGerman.ft_addon.FT_Addon;
import TruGerman.ft_addon.init.ItemInit;
import TruGerman.ft_addon.interfaces.IHasModel;
import TruGerman.ft_addon.util.RefStrings;
import TruGerman.ft_addon.util.UtilPackage;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{

	public ItemBase(String name) 
	{
		
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(UtilPackage.mainTab);
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		FT_Addon.proxy.registerModel(this, 0);
	}
	
}
