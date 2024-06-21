package ironfurnaces.container.furnaces;

import ironfurnaces.init.Registration;
import ironfurnaces.tileentity.furnaces.BlockCrystalFurnaceTile;
import ironfurnaces.tileentity.furnaces.BlockEmeraldFurnaceTile;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BlockCrystalFurnaceContainer extends BlockIronFurnaceContainerBase {
    // Client
    public BlockCrystalFurnaceContainer(int containerId, Inventory playerInventory) {
        this(containerId, Minecraft.getInstance().level, BlockPos.ZERO, playerInventory, playerInventory.player);
    }

    // Server
    public BlockCrystalFurnaceContainer(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
        super(Registration.CRYSTAL_FURNACE_CONTAINER.get(), windowId, world, pos, playerInventory, player);
        this.te = (BlockCrystalFurnaceTile) world.getBlockEntity(pos);
    }




}
