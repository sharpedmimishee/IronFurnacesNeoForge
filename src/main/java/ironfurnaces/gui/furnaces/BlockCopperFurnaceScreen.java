package ironfurnaces.gui.furnaces;

import ironfurnaces.container.furnaces.BlockCopperFurnaceContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;


public class BlockCopperFurnaceScreen extends BlockIronFurnaceScreenBase<BlockCopperFurnaceContainer> {


    public BlockCopperFurnaceScreen(BlockCopperFurnaceContainer container, Inventory inv, Component name) {
        super(container, inv, name);
    }
}
