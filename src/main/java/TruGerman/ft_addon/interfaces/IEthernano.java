package TruGerman.ft_addon.interfaces;

import net.minecraft.nbt.NBTTagCompound;

public interface IEthernano 
{
	//returns the current amount of Ethernano stored
public int getEthernano();
	//returns the max Ethernano Capacity
public int getMaxEthernano();
	//add Ethernano
public int receiveEthernano(int amount);
	//retrieve Ethernano
public int extractEthernano(int amount);

public boolean canReceive();

public boolean canExtract();

public void writeToNBT(NBTTagCompound compound);

public void readFromNBT(NBTTagCompound compound);

}
