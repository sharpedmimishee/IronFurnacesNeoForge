package ironfurnaces.items;

import ironfurnaces.IronFurnaces;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class ItemSpooky extends Item {


    public ItemSpooky(Properties properties) {
        super(properties);
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext pContext, List<Component> tooltip, TooltipFlag pTooltipFlag) {

        tooltip.add(Component.translatable("tooltip.ironfurnaces.spooky_right_click").setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
        tooltip.add(Component.translatable("tooltip.ironfurnaces.spooky1").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.ITALIC));
        tooltip.add(Component.translatable("tooltip.ironfurnaces.spooky2").setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
    }
}
