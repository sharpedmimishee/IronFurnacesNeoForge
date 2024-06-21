package ironfurnaces.gui.furnaces;

import ironfurnaces.container.furnaces.BlockMillionFurnaceContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


public class BlockMillionFurnaceScreen extends BlockIronFurnaceScreenBase<BlockMillionFurnaceContainer> {


    public BlockMillionFurnaceScreen(BlockMillionFurnaceContainer container, Inventory inv, Component name) {
        super(container, inv, name);

    }
}
