package TruGerman.ft_addon.guis;

import TruGerman.ft_addon.containers.ContainerEthernanoGenerator;
import TruGerman.ft_addon.tileentities.TileEntityEthernanoGenerator;
import TruGerman.ft_addon.util.RefStrings;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;

public class GuiEthernanoGenerator extends GuiContainer
{
	private static final ResourceLocation texture = new ResourceLocation(RefStrings.MODID, "textures/gui/ethernano_generator.png");
	private final TileEntityEthernanoGenerator tileentity;
	private final InventoryPlayer playerInventory;
	
	public GuiEthernanoGenerator(InventoryPlayer inventory, TileEntityEthernanoGenerator tileEntity) 
	{
		super(new ContainerEthernanoGenerator(inventory, tileEntity));
		this.playerInventory = inventory;
		this.tileentity = tileEntity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		drawDefaultBackground();
		this.mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		int i = getEnergyStoredScaled(43);
		int j = getEthernanoStoredScaled(43);
		drawTexturedModalRect(this.guiLeft+13, this.guiTop+8, 184, 8, 8, 43-i);
		drawTexturedModalRect(this.guiLeft+155, this.guiTop+8, 176, 8, 8, 43-j);
			
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		//debugging purposes
		int e = this.tileentity.getValue(3);
		int E = this.tileentity.getValue(1);
		this.mc.player.sendMessage(new TextComponentString("e="+Integer.toString(e)));
		this.mc.player.sendMessage(new TextComponentString("E="+Integer.toString(E)));
		
		this.fontRenderer.drawString("Ethernano:"+Integer.toString(e), this.xSize/2+5, 54, 7777);
		this.fontRenderer.drawString("Energy:"+Integer.toString(E), this.xSize/2-80, 54, 7777);
	}
	
	private int getEnergyStoredScaled(int pixels)
	{
		int i = this.tileentity.getValue(1);
		int j = this.tileentity.getValue(2);
		return i != 0 && j != 0 ? i * pixels / j : 0; 
	}
	
	private int getEthernanoStoredScaled(int pixels)
	{
		int i = this.tileentity.getValue(3);
		int j = this.tileentity.getValue(4);
		return i != 0 && j != 0 ? i * pixels / j : 0; 
	}
	
}
