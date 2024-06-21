package ironfurnaces.tileentity;

import ironfurnaces.container.BlockWirelessEnergyHeaterContainer;
import ironfurnaces.energy.FEnergyStorage;
import ironfurnaces.init.Registration;
import ironfurnaces.items.ItemHeater;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BlockWirelessEnergyHeaterTile extends TileEntityInventory {




    public BlockWirelessEnergyHeaterTile(BlockPos pos, BlockState state) {
        super(Registration.HEATER_TILE.get(), pos, state, 1);
    }

    public FEnergyStorage energyStorage = new FEnergyStorage(1000000, 1000000, 0) {
        @Override
        protected void onEnergyChanged() {
            setChanged();
        }
    };


    public static void tick(Level level, BlockPos worldPosition, BlockState blockState, BlockWirelessEnergyHeaterTile e) {
        ItemStack stack = e.getItem(0);
        if (!stack.isEmpty()) {
            stack.set(Registration.WIRELESS_BLOCK_POS_X.get(), e.worldPosition.getX());
            stack.set(Registration.WIRELESS_BLOCK_POS_Y.get(), e.worldPosition.getY());
            stack.set(Registration.WIRELESS_BLOCK_POS_Z.get(), e.worldPosition.getZ());

        }

    }

    public int getEnergy() {
        return energyStorage.getEnergy();
    }

    public int getCapacity() {
        return energyStorage.getCapacity();
    }

    public void setEnergy(int energy) {
        energyStorage.setEnergy(energy);
    }

    public void setMaxEnergy(int energy) {
        energyStorage.setCapacity(energy);
    }

    public void removeEnergy(int energy) {
        energyStorage.setEnergy(energyStorage.getEnergy() - energy);
    }


    @Override
    public void loadAdditional(CompoundTag nbt, HolderLookup.Provider provider) {
        super.loadAdditional(nbt, provider);
        setEnergy(nbt.getInt("Energy"));

    }

    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider provider) {
        super.saveAdditional(nbt, provider);
        nbt.putInt("Energy", getEnergy());
    }

    @Override
    public int[] IgetSlotsForFace(Direction side) {
        return new int[0];
    }

    @Override
    public boolean IcanExtractItem(int index, ItemStack stack, Direction direction) {
        return true;
    }

    @Override
    public String IgetName() {
        return "container.ironfurnaces.wireless_energy_heater";
    }

    @Override
    public boolean IisItemValidForSlot(int index, ItemStack stack) {
        return stack.getItem() instanceof ItemHeater;
    }

    @Override
    public AbstractContainerMenu IcreateMenu(int i, Inventory playerInventory, Player playerEntity) {
        return new BlockWirelessEnergyHeaterContainer(i, level, worldPosition, playerInventory, playerEntity);
    }
}
