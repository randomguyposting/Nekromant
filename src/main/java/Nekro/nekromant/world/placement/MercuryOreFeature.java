package Nekro.nekromant.world.placement;

import Nekro.nekromant.registry.NeBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class MercuryOreFeature extends Feature<NoneFeatureConfiguration> {

    public MercuryOreFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }


    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        BlockPos blockpos = pContext.origin();
        WorldGenLevel worldgenlevel = pContext.level();
        Random random = pContext.random();
        BlockState state = worldgenlevel.getBlockState(blockpos);
        if (state == Blocks.STONE.defaultBlockState() && discardOnAir(blockpos, random, state, worldgenlevel)) {
            BlockPos.MutableBlockPos blockpos$mutableblockpos = blockpos.mutable();
            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = blockpos.mutable();

            worldgenlevel.setBlock(blockpos$mutableblockpos, NeBlocks.MERCURY_ORE.get().defaultBlockState(), 20);

            return true;
        } else {
            return false;
        }
    }

    public boolean discardOnAir(BlockPos pos, Random random, BlockState blockState, WorldGenLevel level){
        int Chance = random.nextInt(5);
        if(Chance < 3){
            return true;
        }

        blockState = level.getBlockState(pos.above());
        if(blockState == Blocks.AIR.defaultBlockState()){
            return false;
        }
        blockState = level.getBlockState(pos.below());
        if(blockState == Blocks.AIR.defaultBlockState()){
            return false;
        }
        blockState = level.getBlockState(pos.west());
        if(blockState == Blocks.AIR.defaultBlockState()){
            return false;
        }
        blockState = level.getBlockState(pos.south());
        if(blockState == Blocks.AIR.defaultBlockState()){
            return false;
        }
        blockState = level.getBlockState(pos.east());
        if(blockState == Blocks.AIR.defaultBlockState()){
            return false;
        }
        blockState = level.getBlockState(pos.north());
        if(blockState == Blocks.AIR.defaultBlockState()){
            return false;
        }

        return true;
    }
}