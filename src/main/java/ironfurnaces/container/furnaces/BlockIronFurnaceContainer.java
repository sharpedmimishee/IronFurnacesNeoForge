package ironfurnaces.container.furnaces;

import ironfurnaces.init.Registration;
import ironfurnaces.tileentity.furnaces.BlockIronFurnaceTile;
import ironfurnaces.tileentity.furnaces.BlockIronFurnaceTileBase;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BlockIronFurnaceContainer extends BlockIronFurnaceContainerBase {
    // Client
    public BlockIronFurnaceContainer(int containerId, Inventory playerInventory) {
        this(containerId, Minecraft.getInstance().level, BlockPos.ZERO, playerInventory, playerInventory.player);
    }

    // Server
    public BlockIronFurnaceContainer(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
        super(Registration.IRON_FURNACE_CONTAINER.get(), windowId, world, pos, playerInventory, player);
        this.te = (BlockIronFurnaceTile) world.getBlockEntity(pos);
    }


}
