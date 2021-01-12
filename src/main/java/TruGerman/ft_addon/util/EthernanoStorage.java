package TruGerman.ft_addon.util;

import TruGerman.ft_addon.interfaces.IEthernano;
import net.minecraft.nbt.NBTTagCompound;

public class EthernanoStorage implements IEthernano
{
	protected int Ethernano;
	protected int maxEthernano;
	protected boolean canReceive;
	protected boolean canExtract;
	

	public EthernanoStorage(int Capacity) 
	{
		this(Capacity, 0, true, true);
	}
	
	public EthernanoStorage(int Capacity, int Ethernano) 
	{
		this(Capacity, Ethernano, true, true);
	}
	
	public EthernanoStorage(int Capacity, int Ethernano, boolean canReceive) 
	{
		this(Capacity, Ethernano, canReceive, true);
	}
	
	public EthernanoStorage(int Capacity, int Ethernano, boolean canReceive, boolean canExtract) 
	{
		this.Ethernano = Ethernano;
		this.maxEthernano = Capacity;
		this.canReceive = canReceive;
		this.canExtract = canExtract;
	}
	
	@Override
	public int getEthernano() 
	{
		return Ethernano;
	}

	@Override
	public int getMaxEthernano() 
	{
		return maxEthernano;
	}
	
	public void setEthernano(int value)
	{
		this.Ethernano = value;
	}

	public int receiveEthernanoReturnLeftover(int amount) 
	{
		if(canReceive)
		{
			if (amount+getEthernano() > getMaxEthernano()) 
			{
				int leftover = amount - (getMaxEthernano()-getEthernano());
				Ethernano = maxEthernano;
				return leftover;
			}
			if (amount+getEthernano() == getMaxEthernano()) 
			{
				Ethernano = maxEthernano;
					return 0;
			}
			else 
			{
				Ethernano =+ amount;
				return 0;
			}
		} else return 0;
		
	}
	
	@Override
	public int receiveEthernano(int amount) 
	{
		if(canReceive)
		{
			if (amount+getEthernano() > getMaxEthernano())
			{
				int accepted = getMaxEthernano() - getEthernano();
				Ethernano = maxEthernano;
				return accepted;
			}
			if (amount+getEthernano() == getMaxEthernano()) 
			{
				Ethernano = maxEthernano;
				return amount;
			}
			else 
			{
				Ethernano = Ethernano + amount;
				return amount;
			}
		} else return 0;
	}

	@Override
	public int extractEthernano(int amount) 
	{
		if(canExtract)
		{
			if (Ethernano<amount) 
			{
				int accepted = Ethernano - amount;
				Ethernano = 0;
				return accepted;
			}
			if (Ethernano == amount) 
			{
				Ethernano = 0;
				return amount;
			}
			else 
			{
				Ethernano -= amount;
				return amount;
			}
		} else return 0;
	}

	@Override
	public boolean canReceive() 
	{
		return canReceive;
	}

	@Override
	public boolean canExtract() 
	{
		return canExtract;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		compound.setInteger("Ethernano", Ethernano);
		compound.setInteger("MaxEthernano", maxEthernano);
		compound.setBoolean("canExtract", canExtract);
		compound.setBoolean("canReceive", canReceive);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		this.Ethernano = compound.getInteger("Ethernano");
		this.maxEthernano = compound.getInteger("MaxEthernano");
		this.canExtract = compound.getBoolean("canExtract");
		this.canReceive = compound.getBoolean("canReceive");
	}
	

}
