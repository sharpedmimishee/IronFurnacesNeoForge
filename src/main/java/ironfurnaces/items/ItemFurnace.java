package ironfurnaces.items;

import ironfurnaces.Config;
import ironfurnaces.init.Registration;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class ItemFurnace extends BlockItem {


    public ItemFurnace(Block block, Properties properties) {
        super(block, properties);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext pContext, List<Component> tooltip, TooltipFlag pTooltipFlag) {

        tooltip.add(Component.literal("Cooktime: " + getCooktime(stack)).withStyle(ChatFormatting.GRAY));

    }



    private static int getCooktime(ItemStack stack)
    {
        Item item = stack.getItem();
        if (item == Registration.ALLTHEMODIUM_FURNACE_ITEM.get())
        {
            return Config.allthemodiumFurnaceSpeed.get();
        }
        if (item == Registration.VIBRANIUM_FURNACE_ITEM.get())
        {
            return Config.vibraniumFurnaceSpeed.get();
        }
        if (item == Registration.UNOBTAINIUM_FURNACE_ITEM.get())
        {
            return Config.unobtainiumFurnaceSpeed.get();
        }
        if (item == Registration.COPPER_FURNACE_ITEM.get())
        {
            return Config.copperFurnaceSpeed.get();
        }
        if (item == Registration.CRYSTAL_FURNACE_ITEM.get())
        {
            return Config.crystalFurnaceSpeed.get();
        }
        if (item == Registration.DIAMOND_FURNACE_ITEM.get())
        {
            return Config.diamondFurnaceSpeed.get();
        }
        if (item == Registration.EMERALD_FURNACE_ITEM.get())
        {
            return Config.emeraldFurnaceSpeed.get();
        }
        if (item == Registration.GOLD_FURNACE_ITEM.get())
        {
            return Config.goldFurnaceSpeed.get();
        }
        if (item == Registration.IRON_FURNACE_ITEM.get())
        {
            return Config.ironFurnaceSpeed.get();
        }
        if (item == Registration.NETHERITE_FURNACE_ITEM.get())
        {
            return Config.netheriteFurnaceSpeed.get();
        }
        if (item == Registration.OBSIDIAN_FURNACE_ITEM.get())
        {
            return Config.obsidianFurnaceSpeed.get();
        }
        if (item == Registration.SILVER_FURNACE_ITEM.get())
        {
            return Config.silverFurnaceSpeed.get();
        }
        return 0;
    }

}
