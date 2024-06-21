package ironfurnaces.capability;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;

public class PlayerFurnacesListProvider implements INBTSerializable<CompoundTag> {

    public PlayerFurnacesList furnacesList = new PlayerFurnacesList();

    @Override
    public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        CompoundTag furnaces = new CompoundTag();
        for (int i = 0; i < furnacesList.listFurances.size(); i++)
        {
            CompoundTag blockpos = new CompoundTag();
            blockpos.putInt("X", furnacesList.listFurances.get(i).getX());
            blockpos.putInt("Y", furnacesList.listFurances.get(i).getY());
            blockpos.putInt("Z", furnacesList.listFurances.get(i).getZ());
            furnaces.put("furnace" + i, blockpos);
        }


        tag.put("furnaces", furnaces);
        tag.putInt("count", furnacesList.listFurances.size());
        return tag;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag tag) {
        int size = tag.getInt("count");
        CompoundTag furances = tag.getCompound("furnaces");
        for (int i = 0; i < size; i++)
        {
            CompoundTag furance = furances.getCompound("furnace" + i);
            BlockPos pos = new BlockPos(furance.getInt("X"), furance.getInt("Y"), furance.getInt("Z"));
            furnacesList.listFurances.add(pos);
        }
    }
}
