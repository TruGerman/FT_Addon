package TruGerman.ft_addon.tileentities;

import TruGerman.ft_addon.util.CustomEnergyStorage;
import TruGerman.ft_addon.util.EthernanoStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class TileEntityEthernanoGenerator extends TileEntity implements ITickable
{
	private EthernanoStorage EStorage = new EthernanoStorage(5000);
	private CustomEnergyStorage Storage = new CustomEnergyStorage(50000);
	private String customName;


	
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		this.EStorage.writeToNBT(compound);
		this.Storage.writeToNBT(compound);
		compound.setString("Name", this.getDisplayName().toString());
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		this.customName = compound.getString("Name");
		this.EStorage.readFromNBT(compound);
		this.Storage.readFromNBT(compound);
	}
	@Override
	public void update() 
	{
		if (hasDiaBlock())
		{
			EStorage.receiveEthernano(20);
			markDirty();
		}
		if(hasGoldBlock())
		{
			Storage.receiveEnergy(100, false);
			markDirty();
		}
		produceEthernano();
	}
	
	protected boolean produceEthernano()
	{
		if(this.getValue(1)>=10)
		{
			if(this.getValue(3)<this.getValue(4))
			{
				this.Storage.extractEnergy(10, false);
				this.EStorage.receiveEthernano(1);
				markDirty();
				return true;
			}
		} return false;
	}
	
	protected boolean hasDiaBlock() 
	{
		return world.getBlockState(getPos().offset(EnumFacing.UP)).getBlock()==Blocks.DIAMOND_BLOCK;
	}
	
	protected boolean hasGoldBlock()
	{
		return world.getBlockState(getPos().offset(EnumFacing.UP)).getBlock()==Blocks.GOLD_BLOCK;
	}
	
	/**
	 * Returns values contained in the respective storages
	 * @param ID 1-4
	 * @return Energy, MaxEnergy, Ethernano, MaxEthernano
	 */
	
	public int getValue(int ID)
	{
		switch(ID) 
		{
		case 1: 
			return this.Storage.getEnergyStored();
		case 2: 
			return this.Storage.getMaxEnergyStored();
		case 3: 
			return this.EStorage.getEthernano();
		case 4: 
			return this.EStorage.getMaxEthernano();
		default: 
			return 0;
		}

	}
	//this probably doesn't work as intended
	/**
	 * Set the specified container's value
	 * @param ID 1-2, Ethernano and Energy
	 * @param value new value
	 */
	public void setValue(int ID, int value) 
	{
		switch(ID)
		{
		case 1: this.EStorage.setEthernano(Math.min(value, this.EStorage.getMaxEthernano()));
		markDirty();
		break;
		case 2: this.Storage.setEnergy(Math.min(value, this.Storage.getMaxEnergyStored()));
		markDirty();
		break;
		}
		
	}
	
	public boolean usableByPlayer(EntityPlayer player)
	{
		return this.world.getTileEntity(pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64D;
	}
	
	@Override
	public ITextComponent getDisplayName() 
	{
		return new TextComponentTranslation("container.ethernano_generator");
	}
	
	

	//why is this here anyway
	public TileEntityEthernanoGenerator getTileEntity()
	{
		return this;
	}
	
	public NBTTagCompound getNBT()
	{
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public NBTTagCompound getUpdateTag() 
	{
		return this.getNBT();
	}
	
	public NBTTagCompound getTagForItem()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.EStorage.writeToNBT(tag);
		this.Storage.writeToNBT(tag);
		tag.setString("Name", this.getDisplayName().toString());
		return tag;
	}
	@Override
	public void handleUpdateTag(NBTTagCompound tag) 
	{
		this.readFromNBT(tag);
	}
	
	
	
 
	

}
