package ironfurnaces.gui.furnaces;

import ironfurnaces.container.furnaces.BlockIronFurnaceContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


public class BlockIronFurnaceScreen extends BlockIronFurnaceScreenBase<BlockIronFurnaceContainer> {


    public BlockIronFurnaceScreen(BlockIronFurnaceContainer container, Inventory inv, Component name) {
        super(container, inv, name);

    }
}
