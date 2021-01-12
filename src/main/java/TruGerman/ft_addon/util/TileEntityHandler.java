package TruGerman.ft_addon.util;

import TruGerman.ft_addon.tileentities.TileEntityEthernanoGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{

	public static void registerTileEntities() 
	{
		GameRegistry.registerTileEntity(TileEntityEthernanoGenerator.class, new ResourceLocation(RefStrings.MODID+":ethernano_generator"));
	}
	
}
