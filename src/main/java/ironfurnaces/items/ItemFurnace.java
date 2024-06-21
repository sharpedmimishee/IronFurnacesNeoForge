package ironfurnaces.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class ItemFurnace extends BlockItem {

    private int cooktime;

    public ItemFurnace(Block block, Properties properties, int cooktime) {
        super(block, properties);
        this.cooktime = cooktime;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext pContext, List<Component> tooltip, TooltipFlag pTooltipFlag) {

        tooltip.add(Component.literal("Cooktime: " + cooktime).withStyle(ChatFormatting.GRAY));
    }

}
