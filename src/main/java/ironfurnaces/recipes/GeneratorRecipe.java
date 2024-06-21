package ironfurnaces.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import ironfurnaces.init.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class GeneratorRecipe implements Recipe<SingleRecipeInput> {

    public final String name;
    public int energy;
    public ItemStack stack;

    public GeneratorRecipe(String name, int energy, ItemStack stack)
    {
        this.name = name;
        this.energy = energy;
        this.stack = stack;
    }

    @Override
    public boolean isIncomplete() {
        return stack.isEmpty();
    }

    public ItemStack getIngredient()
    {
        return stack;
    }

    public int getEnergy()
    {
        return energy;
    }

    public static int getTotalCount(SingleRecipeInput inventory, ItemStack input) {
        ItemStack stack = inventory.getItem(0);
        if (!stack.isEmpty() && stack.getItem() == input.getItem()) {
            return stack.getCount();
        }
        return 0;
    }


    @Override
    public boolean matches(SingleRecipeInput inv, Level p_44003_) {
        int required = stack.getCount();
        int found = getTotalCount(inv, stack);
        return found >= required;
    }

    @Override
    public ItemStack assemble(SingleRecipeInput p_343633_, HolderLookup.Provider p_332698_) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider p_331967_) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Registration.GENERATOR_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return Registration.GENERATOR_RECIPE_TYPE.get();
    }

    public interface Factory<T extends GeneratorRecipe> {
        T create(String name, int energy, ItemStack stack);
    }

    public static class Serializer<T extends GeneratorRecipe> implements RecipeSerializer<T> {

        final GeneratorRecipe.Factory<T> factory;
        private final MapCodec<T> codec;
        private final StreamCodec<RegistryFriendlyByteBuf, T> streamCodec;

        public Serializer(GeneratorRecipe.Factory<T> factory) {
            this.factory = factory;
            this.codec = RecordCodecBuilder.mapCodec(
                    h -> h.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(p_298324_ -> p_298324_.name),
                                    Codec.INT.optionalFieldOf("energy", 0).forGetter(j -> j.energy),
                                    ItemStack.STRICT_CODEC.fieldOf("item").forGetter(j -> j.stack)
                            )
                            .apply(h, factory::create)
            );
            this.streamCodec = StreamCodec.of(this::toNetwork, this::fromNetwork);

        }



        private T fromNetwork(RegistryFriendlyByteBuf buf) {
            String s = buf.readUtf();
            int energy = buf.readVarInt();
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buf);
            return this.factory.create(s, energy, itemstack);
        }

        private void toNetwork(RegistryFriendlyByteBuf buf, T recipe) {
            buf.writeUtf(recipe.name);
            buf.writeVarInt(recipe.energy);
            ItemStack.STREAM_CODEC.encode(buf, recipe.stack);

        }

        @Override
        public MapCodec<T> codec() {
            return codec;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
            return streamCodec;
        }



    }
}
