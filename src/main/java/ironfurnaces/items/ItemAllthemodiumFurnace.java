package ironfurnaces.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class ItemAllthemodiumFurnace extends ItemFurnace {


    public ItemAllthemodiumFurnace(Block block, Properties properties) {
        super(block, properties);
    }


    @Override
    public void onCraftedBy(ItemStack pStack, Level pLevel, Player pPlayer) {
        super.onCraftedBy(pStack, pLevel, pPlayer);
        String name = pStack.getDisplayName().copy().getString().replaceAll("]", "").replaceAll("\\[", "");
        Component component = Component.literal(name);
        pStack.set(DataComponents.CUSTOM_NAME, component.copy().withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GOLD));
    }
}
