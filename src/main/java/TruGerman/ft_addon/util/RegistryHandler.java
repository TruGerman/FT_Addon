package TruGerman.ft_addon.util;

import TruGerman.ft_addon.FT_Addon;
import TruGerman.ft_addon.init.BlockInit;
import TruGerman.ft_addon.init.ItemInit;
import TruGerman.ft_addon.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) 
    {
    	event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
    	TileEntityHandler.registerTileEntities();
    }
    
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for(Item item : ItemInit.ITEMS)
        {
            if(item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
            }
        }
        
        for(Block block : BlockInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
    }
    
    
    
    
    
    public static void preInitRegistries()
    {
    	
        
    }
    
    public static void initRegistries()
    {
    	NetworkRegistry.INSTANCE.registerGuiHandler(FT_Addon.instance, new GuiHandler());
    }
    
    public static void postInitRegistries()
    {
        
    }
    
    public static void serverRegistries(FMLServerStartingEvent event)
    {
        
    }
}