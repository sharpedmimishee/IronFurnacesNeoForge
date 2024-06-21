package ironfurnaces.container.furnaces.other;

import ironfurnaces.container.furnaces.BlockIronFurnaceContainerBase;
import ironfurnaces.init.Registration;
import ironfurnaces.tileentity.furnaces.BlockCopperFurnaceTile;
import ironfurnaces.tileentity.furnaces.other.BlockAllthemodiumFurnaceTile;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BlockAllthemodiumFurnaceContainer extends BlockIronFurnaceContainerBase {


    // Client
    public BlockAllthemodiumFurnaceContainer(int containerId, Inventory playerInventory) {
        this(containerId, Minecraft.getInstance().level, BlockPos.ZERO, playerInventory, playerInventory.player);
    }

    // Server
    public BlockAllthemodiumFurnaceContainer(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
        super(Registration.ALLTHEMODIUM_FURNACE_CONTAINER.get(), windowId, world, pos, playerInventory, player);
        this.te = (BlockAllthemodiumFurnaceTile) world.getBlockEntity(pos);
    }


}
