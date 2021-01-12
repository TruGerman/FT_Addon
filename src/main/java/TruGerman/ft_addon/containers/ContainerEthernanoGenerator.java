package TruGerman.ft_addon.containers;

import TruGerman.ft_addon.guis.GuiEthernanoGenerator;
import TruGerman.ft_addon.tileentities.TileEntityEthernanoGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.item.ItemStack;

public class ContainerEthernanoGenerator extends BaseContainer 
{
	private final TileEntityEthernanoGenerator tileentity;
	private int Ethernano;
	private int Energy;
	
	
	
	public ContainerEthernanoGenerator(InventoryPlayer inventory, TileEntityEthernanoGenerator tileentity) 
	{
		this.tileentity = tileentity;
		addPlayerInventory(inventory, 8, 64);
	}
	
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) 
	{
		return ItemStack.EMPTY;
	}
	
	@Override
	public void updateProgressBar(int id, int data) 
	{
		this.tileentity.setValue(id, data);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return tileentity.usableByPlayer(playerIn);
	}
	
	@Override
	public void detectAndSendChanges() 
	{
		super.detectAndSendChanges();
		for(int i = 0; i < this.listeners.size(); ++i)
		{
			IContainerListener listener = (IContainerListener)this.listeners.get(i);
			if(this.Ethernano != this.tileentity.getValue(3)) 
			{
				listener.sendWindowProperty(this, 1, tileentity.getValue(3));
				
			}
			if(this.Energy != this.tileentity.getValue(1))
			{
				listener.sendWindowProperty(this, 2, tileentity.getValue(1));
			}
		}
		this.Energy = this.tileentity.getValue(1);
		this.Ethernano = this.tileentity.getValue(3);
	}
	//I swear to god, it's probably this pile of shit that doesn't work
	
	
}
