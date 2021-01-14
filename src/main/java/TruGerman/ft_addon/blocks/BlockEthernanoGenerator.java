package TruGerman.ft_addon.blocks;

import java.util.Random;

import TruGerman.ft_addon.FT_Addon;
import TruGerman.ft_addon.init.BlockInit;
import TruGerman.ft_addon.tileentities.TileEntityEthernanoGenerator;
import TruGerman.ft_addon.util.RefStrings;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockEthernanoGenerator extends BlockBase 
{

	
	public BlockEthernanoGenerator(String name) 
	{
		super(Material.IRON, name);
		setHarvestLevel("ItemPickaxe", 2);
		setHardness(5F);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) 
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityEthernanoGenerator();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote)
		{
			playerIn.openGui(FT_Addon.instance, RefStrings.GUI_ETHERNANO_GEN, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		//return Item.getItemFromBlock(BlockInit.ETHERNANO_GENERATOR);
		return null;
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() 
	{
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) 
	{
		super.onBlockHarvested(worldIn, pos, state, player);

	}
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te, ItemStack stack) 
	{
		NBTTagCompound tag = new NBTTagCompound();

		ItemStack item = new ItemStack(Item.getItemFromBlock(BlockInit.ETHERNANO_GENERATOR), 1, 0, ((TileEntityEthernanoGenerator) te).getTagForItem());
		spawnAsEntity(worldIn, pos, item);
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
	{
		if(stack.hasTagCompound())
		{
			if(!stack.getTagCompound().hasNoTags())
			{
				((TileEntityEthernanoGenerator)worldIn.getTileEntity(pos)).readFromNBT(stack.getTagCompound());
			} 
		}
	}
	

}
