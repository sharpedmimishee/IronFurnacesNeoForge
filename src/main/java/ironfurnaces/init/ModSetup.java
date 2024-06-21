package ironfurnaces.init;

import net.minecraft.world.item.Item;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashMap;
import java.util.Map;

public class ModSetup {


    public static final Map<Item, Integer> SMOKING_BURNS = new HashMap<>();
    public static final Map<Item, Boolean> HAS_RECIPE = new HashMap<>();
    public static final Map<Item, Boolean> HAS_RECIPE_SMOKING = new HashMap<>();
    public static final Map<Item, Boolean> HAS_RECIPE_BLASTING = new HashMap<>();

    public static void init(final FMLCommonSetupEvent event) {

    }




}
