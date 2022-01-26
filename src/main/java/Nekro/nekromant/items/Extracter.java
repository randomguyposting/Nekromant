package Nekro.nekromant.items;

import Nekro.nekromant.registry.NeBlocks;
import Nekro.nekromant.registry.NeCreativeModeTab;
import Nekro.nekromant.registry.NeItems;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;


import java.util.List;
import java.util.Map;

public class Extracter extends SwordItem {

    private static final Map<Block, Item> EXTRACTER_ITEM_CRAFT =
            new ImmutableMap.Builder<Block, Item>()
                    .put(NeBlocks.MERCURY_ORE.get(), NeItems.MERCURY.get())
                    .build();

    public Extracter() {
        super(Tiers.IRON, 1, -1.4f, new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_MISC).durability(532));
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
    public boolean hurtEnemy(ItemStack p_43278_, LivingEntity p_43279_, LivingEntity p_43280_) {
        if(p_43279_.getType() == EntityType.ZOMBIE){
            p_43279_.spawnAtLocation(NeItems.BLOOD_DROP.get());
        }
        p_43278_.hurtAndBreak(1, p_43280_, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
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

    private boolean canExtracter(Block block) {
        return EXTRACTER_ITEM_CRAFT.containsKey(block);
    }
}