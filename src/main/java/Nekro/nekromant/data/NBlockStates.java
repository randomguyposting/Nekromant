package Nekro.nekromant.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import Nekro.nekromant.data.Providers.NBlockstateProvider;
import Nekro.nekromant.registry.NBlocks;

public class NBlockStates extends NBlockstateProvider {

    public NBlockStates(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Override
    public String getName() {
        return "Blockstates";
    }

    @Override
    protected void registerStatesAndModels() {
        block(NBlocks.PURPLE_DUNGEON_BRICKS);
    }
}