package ironfurnaces.gui.furnaces.other;

import ironfurnaces.container.furnaces.other.BlockVibraniumFurnaceContainer;
import ironfurnaces.gui.furnaces.BlockIronFurnaceScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


public class BlockVibraniumFurnaceScreen extends BlockIronFurnaceScreenBase<BlockVibraniumFurnaceContainer> {


    public BlockVibraniumFurnaceScreen(BlockVibraniumFurnaceContainer container, Inventory inv, Component name) {
        super(container, inv, name);
        GUI = GUI_VIB;
    }
}
