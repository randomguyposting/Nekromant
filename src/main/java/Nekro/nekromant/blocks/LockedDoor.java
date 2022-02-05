package Nekro.nekromant.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class LockedDoor extends DoorBlock{
    public LockedDoor(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState p_52769_, Level p_52770_, BlockPos p_52771_, Player p_52772_, InteractionHand p_52773_, BlockHitResult p_52774_) {

        Item item = p_52772_.getMainHandItem().getItem();

        if(p_52769_.getValue(OPEN)){return InteractionResult.PASS;}

        if (Locked.isMatch(p_52769_, item)) {
                this.doOpen(p_52769_, p_52770_, p_52771_, p_52772_);
                return InteractionResult.sidedSuccess(p_52770_.isClientSide);
            }

        p_52770_.levelEvent(p_52772_, p_52769_.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), p_52771_, 0);

        if(Locked.isKey(item)){
            p_52772_.displayClientMessage(new TextComponent("Damn it, no fit"), true);
        }else {
            p_52772_.displayClientMessage(new TextComponent("Can only be opened with a key.."), true);
        }
        return InteractionResult.sidedSuccess(p_52770_.isClientSide);
    }

    @Override
    public void neighborChanged(BlockState p_52776_, Level p_52777_, BlockPos p_52778_, Block p_52779_, BlockPos p_52780_, boolean p_52781_) {}

    private int getCloseSound() {
        return this.material == Material.METAL ? 1011 : 1012;
    }

    private int getOpenSound() {
        return this.material == Material.METAL ? 1005 : 1006;
    }

    private void doOpen(BlockState p_52769_, Level p_52770_, BlockPos p_52771_, Player p_52772_){
        p_52769_ = p_52769_.cycle(OPEN);
        p_52770_.setBlock(p_52771_, p_52769_, 10);
        p_52770_.levelEvent(p_52772_, p_52769_.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), p_52771_, 0);
        p_52770_.gameEvent(p_52772_, this.isOpen(p_52769_) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, p_52771_);
        p_52772_.getMainHandItem().shrink(1);
    }
}