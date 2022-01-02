package Nekro.nekromant.registry.custom;

import Nekro.nekromant.registry.NeBlocks;
import Nekro.nekromant.registry.NeItems;
import com.google.common.collect.ImmutableMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;


import java.util.Map;

public class Extracter extends Item {

    private static final Map<Block, Item> EXTRACTER_ITEM_CRAFT =
            new ImmutableMap.Builder<Block, Item>()
                    .put(NeBlocks.MERCURY_ORE.get(), NeItems.MERCURY.get())
                    .build();

    public Extracter(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            Level level = pContext.getLevel();
            BlockPos positionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(positionClicked).getBlock();

            if (canExtracter(blockClicked)) {
                ItemEntity entityItem = new ItemEntity(level,
                        positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                        new ItemStack(EXTRACTER_ITEM_CRAFT .get(blockClicked), 1));

                level.destroyBlock(positionClicked, false);
                level.addFreshEntity(entityItem);
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> {
                    p.broadcastBreakEvent(pContext.getHand());
                });
            }
        }

        return InteractionResult.SUCCESS;
    }

    private boolean canExtracter(Block block) {
        return EXTRACTER_ITEM_CRAFT.containsKey(block);
    }
}