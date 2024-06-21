package ironfurnaces.gui.furnaces;

import ironfurnaces.container.furnaces.BlockGoldFurnaceContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


public class BlockGoldFurnaceScreen extends BlockIronFurnaceScreenBase<BlockGoldFurnaceContainer> {


    public BlockGoldFurnaceScreen(BlockGoldFurnaceContainer container, Inventory inv, Component name) {
        super(container, inv, name);

    }
}
