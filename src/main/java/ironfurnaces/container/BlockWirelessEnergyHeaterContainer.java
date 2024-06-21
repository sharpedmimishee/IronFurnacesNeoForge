package ironfurnaces.container;

import ironfurnaces.init.Registration;
import ironfurnaces.tileentity.BlockWirelessEnergyHeaterTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;


public class BlockWirelessEnergyHeaterContainer extends BlockWirelessEnergyHeaterContainerBase {



    public BlockWirelessEnergyHeaterContainer(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
        super(Registration.HEATER_CONTAINER.get(), windowId, world, pos, playerInventory, player);
        this.te = (BlockWirelessEnergyHeaterTile) world.getBlockEntity(pos);
    }

}
