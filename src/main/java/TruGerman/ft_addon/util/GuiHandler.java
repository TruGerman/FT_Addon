package TruGerman.ft_addon.util;

import TruGerman.ft_addon.containers.ContainerEthernanoGenerator;
import TruGerman.ft_addon.guis.GuiEthernanoGenerator;
import TruGerman.ft_addon.tileentities.TileEntityEthernanoGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler 
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(ID) 
		{
			case RefStrings.GUI_ETHERNANO_GEN: 
			{
				return new ContainerEthernanoGenerator(player.inventory, (TileEntityEthernanoGenerator)world.getTileEntity(new BlockPos(x, y, z)));
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{

		switch(ID) 
		{
			case RefStrings.GUI_ETHERNANO_GEN: 
			{
			return new GuiEthernanoGenerator(player.inventory, (TileEntityEthernanoGenerator)world.getTileEntity(new BlockPos(x, y, z)));
			}
		}
		return null;
	}

}
