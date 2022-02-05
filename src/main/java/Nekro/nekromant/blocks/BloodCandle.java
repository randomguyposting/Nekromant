package Nekro.nekromant.blocks;

import Nekro.nekromant.registry.NeParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class BloodCandle extends CandleBlock {
    public BloodCandle(Properties properties){
        super(properties);
    }

    private static void addParticlesAndSound(Level p_151910_, Vec3 p_151911_, Random p_151912_) {
        float f = p_151912_.nextFloat();
        if (f < 0.3F) {
            p_151910_.addParticle(ParticleTypes.SMOKE, p_151911_.x, p_151911_.y, p_151911_.z, 0.0D, 0.0D, 0.0D);
            if (f < 0.17F) {
                p_151910_.playLocalSound(p_151911_.x + 0.5D, p_151911_.y + 0.5D, p_151911_.z + 0.5D, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + p_151912_.nextFloat(), p_151912_.nextFloat() * 0.7F + 0.3F, false);
            }
        }

        p_151910_.addParticle(NeParticles.BLOOD_FLAME.get(), p_151911_.x, p_151911_.y, p_151911_.z, 0.0D, 0.0D, 0.0D);
    }

    @Override
    public void animateTick(BlockState p_151929_, Level p_151930_, BlockPos p_151931_, Random p_151932_) {
        if (p_151929_.getValue(LIT)) {
            this.getParticleOffsets(p_151929_).forEach((p_151917_) -> {
                addParticlesAndSound(p_151930_, p_151917_.add((double)p_151931_.getX(), (double)p_151931_.getY(), (double)p_151931_.getZ()), p_151932_);
            });
        }
    }
}
