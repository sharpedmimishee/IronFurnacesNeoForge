package ironfurnaces.container.furnaces;

import ironfurnaces.init.Registration;
import ironfurnaces.tileentity.furnaces.BlockDiamondFurnaceTile;
import ironfurnaces.tileentity.furnaces.BlockEmeraldFurnaceTile;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BlockDiamondFurnaceContainer extends BlockIronFurnaceContainerBase {
    // Client
    public BlockDiamondFurnaceContainer(int containerId, Inventory playerInventory) {
        this(containerId, Minecraft.getInstance().level, BlockPos.ZERO, playerInventory, playerInventory.player);
    }

    // Server
    public BlockDiamondFurnaceContainer(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
        super(Registration.DIAMOND_FURNACE_CONTAINER.get(), windowId, world, pos, playerInventory, player);
        this.te = (BlockDiamondFurnaceTile) world.getBlockEntity(pos);
    }




}
