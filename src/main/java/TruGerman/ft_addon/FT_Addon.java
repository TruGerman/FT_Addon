package TruGerman.ft_addon;

import TruGerman.ft_addon.proxy.CommonProxy;
import TruGerman.ft_addon.util.RefStrings;
import TruGerman.ft_addon.util.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION, acceptedMinecraftVersions = RefStrings.MCVERSION)

//if I had to guess I'd say 20% of the code is mine, but you gotta start somewhere, right?
public class FT_Addon 
{
	@Instance
	public static FT_Addon instance;
	
	@SidedProxy(clientSide = RefStrings.CLIENT_PROXY_CLASS, serverSide = RefStrings.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) 
	{
		RegistryHandler.preInitRegistries();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) 
	{
		RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) 
	{
		RegistryHandler.postInitRegistries();
	}
	
}
