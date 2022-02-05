package Nekro.nekromant.blocks;

import Nekro.nekromant.registry.NeBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class SmallBasket extends ChestBlock {
    public SmallBasket(BlockBehaviour.Properties p_51490_, Supplier<BlockEntityType<? extends ChestBlockEntity>> p_51491_) {
        super(p_51490_, p_51491_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TYPE, ChestType.SINGLE).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }
    public SmallBasket(Properties properties) {
        this(properties, NeBlockEntityTypes.PURPLE_BASKET::get);
    }

    /*@Nonnull
    @Override
    public InteractionResult use(@Nonnull BlockState state, Level level, @Nonnull BlockPos pos, @Nonnull Player player, @Nonnull InteractionHand hand, @Nonnull BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof TreasureChestBlockEntity treasureChestBlockEntity) {
                MenuProvider menuProvider = this.getMenuProvider(state, level, pos);
                } else if (!ChestBlock.isChestBlockedAt(level, pos) && menuProvider != null) {
                    player.openMenu(menuProvider);
                    player.awardStat(this.getOpenChestStat());
                    PiglinAi.angerNearbyPiglins(player, true);
                }
            }
            return InteractionResult.CONSUME;
        }*/
    }

