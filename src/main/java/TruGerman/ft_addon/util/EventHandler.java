package TruGerman.ft_addon.util;

import TruGerman.ft_addon.init.BlockInit;
import TruGerman.ft_addon.tileentities.TileEntityEthernanoGenerator;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandler 
{

public void onWorldLoad(ChunkEvent e) 
{

}


@SubscribeEvent
public void writeTileEntityNBTToItem(BreakEvent e) 
{
	World world = e.getWorld();
	if(!world.isRemote)
	{
		TileEntity te = e.getWorld().getTileEntity(e.getPos());
		if (te != null && te instanceof TileEntityEthernanoGenerator)
		{
			ItemStack teItem = new ItemStack(BlockInit.ETHERNANO_GENERATOR);
			NBTTagCompound tag = new NBTTagCompound();
			teItem.writeToNBT(tag);
			teItem.deserializeNBT(((TileEntityEthernanoGenerator) te).getNBT());
			e.getWorld().spawnEntity(new EntityItem(world, e.getPos().getX(), e.getPos().getY(), e.getPos().getZ(), new ItemStack(Item.getItemFromBlock(BlockInit.BLOCKS.get(0)))));
			
		}
	}
}
	
}
