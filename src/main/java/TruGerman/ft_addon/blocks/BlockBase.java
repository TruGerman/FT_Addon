package TruGerman.ft_addon.blocks;

import TruGerman.ft_addon.FT_Addon;
import TruGerman.ft_addon.init.BlockInit;
import TruGerman.ft_addon.init.ItemInit;
import TruGerman.ft_addon.interfaces.IHasModel;
import TruGerman.ft_addon.util.UtilPackage;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public abstract class BlockBase extends Block implements IHasModel
{
	public BlockBase(Material material, String name) 
	{
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(UtilPackage.mainTab);
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() 
	{
		FT_Addon.proxy.registerModel(Item.getItemFromBlock(this), 0);
	}

}
