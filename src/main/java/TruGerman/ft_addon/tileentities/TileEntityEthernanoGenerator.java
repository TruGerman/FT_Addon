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
	protected EthernanoStorage EStorage = new EthernanoStorage(5000, 1000);
	protected CustomEnergyStorage Storage = new CustomEnergyStorage(50000);
	public String customName;


	
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		
		this.EStorage.writeToNBT(compound);
		this.Storage.writeToNBT(compound);
		compound.setString("Name", getDisplayName().toString());
		super.writeToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		customName = compound.getString("Name");
		this.EStorage.readFromNBT(compound);
		this.Storage.readFromNBT(compound);
		

	}
	@Override
	public void update() 
	{
		if (hasDiaBlock())
		{
<<<<<<< Upstream, based on branch 'beta' of https://github.com/TruGerman/FT_Addon
<<<<<<< Upstream, based on branch 'beta' of https://github.com/TruGerman/FT_Addon
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
		case 1: return this.Storage.getEnergyStored();
		case 2: return this.Storage.getMaxEnergyStored();
		case 3: return this.EStorage.getEthernano();
		case 4: return this.EStorage.getMaxEthernano();
		default: return 0;
		}

	}
	//this probably doesn't work as intended
	public void setValue(int ID, int value) 
	{
		switch(ID)
		{
		case 1: this.EStorage.setEthernano(Math.min(value, this.EStorage.getMaxEthernano()));
		break;
		case 2: this.Storage.setEnergy(Math.min(value, this.Storage.getMaxEnergyStored()));
=======
			EStorage.receiveEthernano(50);
=======
			EStorage.receiveEthernano(20);
>>>>>>> c01adbc Small stuff
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
		if(this.getValue(1)>10)
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
		case 1: return this.Storage.getEnergyStored();
		case 2: return this.Storage.getMaxEnergyStored();
		case 3: return this.EStorage.getEthernano();
		case 4: return this.EStorage.getMaxEthernano();
		default: return 0;
		}

	}
	//this probably doesn't work as intended
	public void setValue(int ID, int value) 
	{
		switch(ID)
		{
		case 1: this.EStorage.setEthernano(Math.min(value, this.EStorage.getMaxEthernano()));
		break;
		case 2: this.Storage.setEnergy(Math.min(value, this.EStorage.getMaxEthernano()));
>>>>>>> 50e1f23 removed unused imports
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
	
	
	public NBTTagCompound getNBT()
	{
		return this.writeToNBT(getTileData());
	}
	
	public TileEntityEthernanoGenerator getTileEntity()
	{
		return this;
	}
	
	
 
	

}
