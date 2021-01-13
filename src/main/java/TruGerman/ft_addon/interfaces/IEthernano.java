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
	//allowed to receive
	public boolean canReceive();
	//allowed to extract
	public boolean canExtract();
	//write to NBT
	public void writeToNBT(NBTTagCompound compound);
	//read from NBT
	public void readFromNBT(NBTTagCompound compound);

}
