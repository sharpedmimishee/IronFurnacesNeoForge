package ironfurnaces.items.augments;

import ironfurnaces.IronFurnaces;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class ItemAugmentGenerator extends ItemAugmentBlue {

    public ItemAugmentGenerator(Properties properties) {
        super(properties);
    }



    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext pContext, List<Component> tooltip, TooltipFlag pTooltipFlag) {

        super.appendHoverText(stack, pContext, tooltip, pTooltipFlag);

        tooltip.add(Component.translatable("tooltip." + IronFurnaces.MOD_ID + ".augment_generator_pro").setStyle(Style.EMPTY.applyFormat((ChatFormatting.GREEN))));
        tooltip.add(Component.translatable("tooltip." + IronFurnaces.MOD_ID + ".augment_generator_con").setStyle(Style.EMPTY.applyFormat(ChatFormatting.DARK_RED)));


    }




}
