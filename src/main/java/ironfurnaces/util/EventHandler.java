package ironfurnaces.util;


import ironfurnaces.init.Registration;
import ironfurnaces.tileentity.furnaces.BlockMillionFurnaceTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.ExplosionKnockbackEvent;

import java.util.List;

public class EventHandler {


    @SubscribeEvent
    public static void explosionEvent(ExplosionKnockbackEvent event)
    {

        List<BlockPos> list = event.getExplosion().getToBlow();
        for (BlockPos pos : list)
        {
            Level world = event.getLevel();
            if (world.getBlockEntity(pos) instanceof BlockMillionFurnaceTile)
            {
                event.getExplosion().getToBlow().remove(pos);
                world.removeBlockEntity(pos);
                world.removeBlock(pos, false);

                world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY() + 6f, pos.getZ(), new ItemStack(Registration.RAINBOW_COAL.get())));
            }
        }
    }

}
