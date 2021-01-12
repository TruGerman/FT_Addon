package TruGerman.ft_addon.init;

import java.util.ArrayList;
import java.util.List;

import TruGerman.ft_addon.blocks.BlockEthernanoGenerator;
import net.minecraft.block.Block;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final Block ETHERNANO_GENERATOR = new BlockEthernanoGenerator("ethernano_generator");
}
