package ironfurnaces.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ItemVibraniumFurnace extends ItemFurnace {


    public ItemVibraniumFurnace(Block block, Properties properties) {
        super(block, properties);
    }


    @Override
    public void onCraftedBy(ItemStack pStack, Level pLevel, Player pPlayer) {
        super.onCraftedBy(pStack, pLevel, pPlayer);
        String name = pStack.getDisplayName().copy().getString().replaceAll("]", "").replaceAll("\\[", "");
        Component component = Component.literal(name);
        pStack.set(DataComponents.CUSTOM_NAME, component.copy().withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GREEN));
    }
}
