package ironfurnaces.items;

import ironfurnaces.IronFurnaces;
import ironfurnaces.gui.furnaces.BlockIronFurnaceScreenBase;
import ironfurnaces.init.Registration;
import ironfurnaces.util.StringHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class ItemHeater extends Item {


    public ItemHeater(Properties properties) {
        super(properties);
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext pContext, List<Component> tooltip, TooltipFlag pTooltipFlag) {
        if (BlockIronFurnaceScreenBase.isShiftKeyDown())
        {
            if (stack.get(Registration.WIRELESS_BLOCK_POS_X.get()) != null && stack.get(Registration.WIRELESS_BLOCK_POS_Y.get()) != null && stack.get(Registration.WIRELESS_BLOCK_POS_Z.get()) != null) {
                int x = stack.get(Registration.WIRELESS_BLOCK_POS_X.get());
                int y = stack.get(Registration.WIRELESS_BLOCK_POS_Y.get());
                int z = stack.get(Registration.WIRELESS_BLOCK_POS_Z.get());
                tooltip.add(Component.translatable("tooltip." + IronFurnaces.MOD_ID + ".heater").setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.translatable("tooltip." + IronFurnaces.MOD_ID + ".heaterX").setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))).append(Component.literal("" + x).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY)))));
                tooltip.add(Component.translatable("tooltip." + IronFurnaces.MOD_ID + ".heaterY").setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))).append(Component.literal("" + y).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY)))));
                tooltip.add(Component.translatable("tooltip." + IronFurnaces.MOD_ID + ".heaterZ").setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))).append(Component.literal("" + z).setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY)))));
            } else {
                tooltip.add(Component.translatable("tooltip." + IronFurnaces.MOD_ID + ".heater_not_bound").setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.translatable("tooltip." + IronFurnaces.MOD_ID + ".heater_tip").setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
                tooltip.add(Component.translatable("tooltip." + IronFurnaces.MOD_ID + ".heater_tip1").setStyle(Style.EMPTY.applyFormat((ChatFormatting.GRAY))));
            }
        }
        else
        {
            tooltip.add(StringHelper.getShiftInfoText());
        }
    }

}
