package ironfurnaces.capability;

import ironfurnaces.init.Registration;
import ironfurnaces.tileentity.BlockWirelessEnergyHeaterTile;
import ironfurnaces.tileentity.furnaces.BlockIronFurnaceTileBase;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;

import java.util.Iterator;
import java.util.List;

public class CapabilityIronFurnaces {

    //public static final EntityCapability<IPlayerFurnacesList, Void> FURNACES_LIST = EntityCapability.createVoid(ResourceLocation.fromNamespaceAndPath(IronFurnaces.MOD_ID, "furnace_list"), IPlayerFurnacesList.class);

    public static void register(RegisterCapabilitiesEvent event)
    {
        List furnaces = List.of(
                Registration.COPPER_FURNACE_TILE,
                Registration.CRYSTAL_FURNACE_TILE,
                Registration.DIAMOND_FURNACE_TILE,
                Registration.EMERALD_FURNACE_TILE,
                Registration.GOLD_FURNACE_TILE,
                Registration.IRON_FURNACE_TILE,
                Registration.MILLION_FURNACE_TILE,
                Registration.NETHERITE_FURNACE_TILE,
                Registration.OBSIDIAN_FURNACE_TILE,
                Registration.SILVER_FURNACE_TILE,
                Registration.ALLTHEMODIUM_FURNACE_TILE,
                Registration.VIBRANIUM_FURNACE_TILE,
                Registration.UNOBTAINIUM_FURNACE_TILE
        );
        Iterator var3 = furnaces.iterator();

        while(var3.hasNext()) {
            BlockEntityType type = (BlockEntityType)var3.next();
            event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, type, (sidedContainer, side) -> {
                return (IItemHandler)(side == null ? new InvWrapper((Container) sidedContainer) : new SidedInvWrapper((WorldlyContainer)sidedContainer, side));
            });
            event.registerBlockEntity(
                    Capabilities.EnergyStorage.BLOCK, // capability to register for
                    (BlockEntityType)var3.next(), // block entity type to register for
                    (furnace_entity, side) -> ((BlockIronFurnaceTileBase)furnace_entity).energyStorage
            );
        }


        List heater = List.of(
                Registration.HEATER_TILE
        );
        Iterator heater_iterator = heater.iterator();

        while(heater_iterator.hasNext()) {
            BlockEntityType type = (BlockEntityType)heater_iterator.next();
            event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, type, (sidedContainer, side) -> {
                return (IItemHandler)(side == null ? new InvWrapper((Container) sidedContainer) : new SidedInvWrapper((WorldlyContainer)sidedContainer, side));
            });
            event.registerBlockEntity(
                    Capabilities.EnergyStorage.BLOCK, // capability to register for
                    (BlockEntityType)heater_iterator.next(), // block entity type to register for
                    (be, side) -> ((BlockWirelessEnergyHeaterTile)be).energyStorage
            );
        }

    }

}
