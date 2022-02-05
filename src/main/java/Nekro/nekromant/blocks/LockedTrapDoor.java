package Nekro.nekromant.blocks;

import Nekro.nekromant.registry.NeItems;
import Nekro.nekromant.registry.NeItems;
import Nekro.nekromant.registry.NeTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class LockedTrapDoor extends TrapDoorBlock {
    public LockedTrapDoor(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState p_57540_, Level p_57541_, BlockPos p_57542_, Player p_57543_, InteractionHand p_57544_, BlockHitResult p_57545_) {
        Item item = p_57543_.getMainHandItem().getItem();

        if(p_57540_.getValue(OPEN)){return InteractionResult.PASS;}

        //I hate this shitload of code and might need another solution, this is embarissing
        if (NeTags.Blocks.CRIPPLING_KEY.contains(p_57540_.getBlock())) {
            if (item == NeItems.CRIPPLING_KEY.get()) {

                p_57540_ = p_57540_.cycle(OPEN);
                p_57541_.setBlock(p_57542_, p_57540_, 2);
                if (p_57540_.getValue(WATERLOGGED)) {
                    p_57541_.scheduleTick(p_57542_, Fluids.WATER, Fluids.WATER.getTickDelay(p_57541_));
                }
                this.playSound(p_57543_, p_57541_, p_57542_, p_57540_.getValue(OPEN));
                p_57543_.getMainHandItem().shrink(1);
                return InteractionResult.sidedSuccess(p_57541_.isClientSide);
            }
        }
        p_57541_.levelEvent(p_57543_, p_57540_.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), p_57542_, 0);
        if(NeTags.Items.KEYS.contains(p_57543_.getMainHandItem().getItem())){
            p_57543_.displayClientMessage(new TextComponent("Damn it, no fit"), true);
        }else {
            p_57543_.displayClientMessage(new TextComponent("Can only be opened with a key.."), true);
        }
        return InteractionResult.sidedSuccess(p_57541_.isClientSide);
        }
    @Override
    public void neighborChanged(BlockState p_52776_, Level p_52777_, BlockPos p_52778_, Block p_52779_, BlockPos p_52780_, boolean p_52781_) {}

    private int getCloseSound() {
        return this.material == Material.METAL ? 1011 : 1012;
    }

    private int getOpenSound() {
        return this.material == Material.METAL ? 1005 : 1006;
    }
}
