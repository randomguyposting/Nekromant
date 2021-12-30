package Nekro.nekromant.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import Nekro.nekromant.data.Providers.NItemmodelProvider;
import Nekro.nekromant.registry.NBlocks;
import Nekro.nekromant.registry.NItems;

public class NItemModels extends NItemmodelProvider {

    public NItemModels(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Override
    public String getName() {
        return "Itemmodels";
    }

    @Override
    protected void registerModels() {
    block(NBlocks.PURPLE_DUNGEON_BRICKS);
    }
}