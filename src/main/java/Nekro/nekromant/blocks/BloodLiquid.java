package Nekro.nekromant.blocks;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public class BloodLiquid extends LiquidBlock {
    public BloodLiquid(Supplier<? extends FlowingFluid> supplier, Properties properties) {
        super(supplier, properties.noCollission().strength(100F).noDrops());
    }
}
