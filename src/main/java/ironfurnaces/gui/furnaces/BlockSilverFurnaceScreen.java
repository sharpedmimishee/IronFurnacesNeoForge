package ironfurnaces.gui.furnaces;

import ironfurnaces.container.furnaces.BlockSilverFurnaceContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


public class BlockSilverFurnaceScreen extends BlockIronFurnaceScreenBase<BlockSilverFurnaceContainer> {

    public BlockSilverFurnaceScreen(BlockSilverFurnaceContainer container, Inventory inv, Component name) {
        super(container, inv, name);
    }

}
