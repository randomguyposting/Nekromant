package Nekro.nekromant.registry.custom;

import Nekro.nekromant.registry.NeBlocks;
import Nekro.nekromant.registry.NeItems;
import com.google.common.collect.ImmutableMap;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;


import java.util.List;
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

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        if(Screen.hasShiftDown()) {
            p_41423_.add(new TranslatableComponent("tooltip.nekromant.extracter"));
        } else {
            p_41423_.add(new TranslatableComponent("tooltip.nekromant.extracter_shift"));
        }
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
    }
    @Override
    public void setDamage(ItemStack stack, int damage) {
        stack.getOrCreateTag().putInt("Damage", Math.max(0, 10));
        super.setDamage(stack, damage);
    }
    private boolean canExtracter(Block block) {
        return EXTRACTER_ITEM_CRAFT.containsKey(block);
    }
}


